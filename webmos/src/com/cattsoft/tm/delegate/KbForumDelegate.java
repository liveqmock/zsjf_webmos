package com.cattsoft.tm.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.tm.vo.KbForumSVO;

/**
 * 
 * Title: 服务开通系统-知识库子系统<br>
 * Description: 讨论区管理<br>
 * Date: 2012-8-27 <br>
 * Copyright (c) 2012 CATTSoft<br>
 * 
 * @author 鲁攀
 */
public class KbForumDelegate {

	private static final Logger log = Logger.getLogger(KbForumDelegate.class);

	private static KbForumDelegate delegate = new KbForumDelegate();

	public static KbForumDelegate getDelegate() {
		return delegate;
	}

	/**
	 * 无参构造函数
	 */
	public KbForumDelegate() {
	}
	
	/**
	 * 查询知识库讨论区
	 * 
	 * @param paraMap
	 *            输入参数所有对象封装在Map
	 * @return 输出参数所有对象封装在Map
	 * @throws SysException
	 * @throws AppException
	 */
	public Map findKbForum4REST(Map paraMap) throws SysException, AppException {
		Map resultMap = new HashMap();
		try{
			// String urlStr = SysConfigData.getSysConfigCurValue(
			//	SysConstants.SYS_CONFIG_SMS_SERVER_ADDR, null, null, null,
			// null, null);
			paraMap.put("module", "forumApi");
			paraMap.put("action", "list");
			paraMap.put("api_key", "userapi");
			String paramStr = prepareParam(paraMap);
			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_JFORUM_ADDR, null, null, null,null, null);
			urlStr = urlStr + "forumApi/list.page";
//			String urlStr = "http://127.0.0.1:8080/JForum/forumApi/list.page";
			urlStr = urlStr + "?" + paramStr;
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// 设置发送请求的方式
			conn.setRequestMethod("POST");
			// 设置参数的格式类型
			conn.setRequestProperty("Content-Type", "text/html;charset=utf-8");
			// 打开输入输出，在output中传输参数
			conn.setDoInput(true);
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.close();
			// 正常时返回的状态码为200
			if (conn.getResponseCode() == 200) {
				// 获取返回的内容
				BufferedReader br = new BufferedReader(new InputStreamReader(conn
						.getInputStream(),"utf-8"));
				// 输出返回的信息
				String line;
				StringBuffer contentBuffer = new StringBuffer();
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					contentBuffer.append(line);
				}
				System.out.print(contentBuffer.toString());
				br.close();
				Document doc =null;
				List forumList = new ArrayList();
				// 下面的是通过解析xml字符串的
				doc = DocumentHelper.parseText(contentBuffer.toString()); // 将字符串转为XML
				Element rootElt = doc.getRootElement(); // 获取根节点
				Element forumsElement = rootElt.element("forums");
				Iterator forumItr = forumsElement.elementIterator("forum"); // 获取forum节点列表
				// 遍历forum节点
				while (forumItr.hasNext()) {
					Element forumElt = (Element) forumItr.next();
					KbForumSVO kbForumSVO = new KbForumSVO();
					kbForumSVO.setForumId(forumElt.attributeValue("id"));
					kbForumSVO.setForumName(forumElt.attributeValue("name"));
					kbForumSVO.setForumTopics(Integer.parseInt(forumElt.attributeValue("topics")));
					forumList.add(kbForumSVO);
				}
				resultMap.put("forumList", forumList);
			} else {
				log.info("POST" + " [ERROR] CODE: " + conn.getResponseCode());
			}
			
		}catch (ProtocolException ptclEx) {
			log.info(ptclEx.toString());
			throw new AppException("", "调用RESTful接口时协议异常！");
		} catch (IOException ioEx) {
			log.info(ioEx.toString());
			throw new AppException("", "方法体内进行输入输出操作时异常！");
		} catch (DocumentException docEx) {
			log.info(docEx.toString());
			throw new AppException("", "解析调用RESTful接口返回参数时异常！");
		}
		return resultMap;
	}
	
	/**
	 * 准备参数：将参数键值Map转化成参数串
	 * 
	 * @param paramMap
	 *            参数键值Map
	 * @return 格式化的参数串（key=value&key=value...）
	 */
	private static String prepareParam(Map<String, Object> paramMap) {
		StringBuffer sb = new StringBuffer();
		if (paramMap.isEmpty()) {
			return "";
		} else {
			for (String key : paramMap.keySet()) {
				String value = (String) paramMap.get(key);
				if (sb.length() < 1) {
					sb.append(key).append("=").append(value);
				} else {
					sb.append("&").append(key).append("=").append(value);
				}
			}
			return sb.toString();
		}
	}

}
