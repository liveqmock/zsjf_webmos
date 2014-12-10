package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.KbTopicDelegate;
import com.cattsoft.webpub.util.ReqUtil;

/**
 * 
 * Title: 服务开通系统-知识库子系统<br>
 * Description: 讨论主题管理<br>
 * Date: 2012-8-21 <br>
 * Copyright (c) 2012 CATTSoft<br>
 * 
 * @author 鲁攀
 */
public class KbTopicAction extends DispatchAction {

	private static final Logger log = Logger.getLogger(KbTopicAction.class);

	/**
	 * 无参构造函数
	 */
	public KbTopicAction() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * 用于掌上运维知识库讨论主题查询
	 * 
	 * @param mapping
	 *            action mapping
	 * @param actionForm
	 *            action form
	 * @param request
	 *            http servlet request
	 * @param rep
	 *            http servlet response
	 * @return action forward
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward listByForum4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws Exception {
		 //从request 中取出json条件串,从而获得条件
		String jsonString =  ReqUtil.getRequestStr(request);
		JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		//把对象转化成为json字符串
		JSONObject json=new JSONObject();
		
		Map paraMap = new HashMap();
		String forumId = request.getParameter("forumId");
		paraMap.put("forum_id", forumId);
		paraMap.put("start_from", "0");
		paraMap.put("count", "10");
		Map resultMap = KbTopicDelegate.getDelegate().findKbTopic4REST(paraMap);
		List topicList = (List) resultMap.get("topicList");
		JSONArray topicsJSON = JSONArray.fromObject(topicList);
		
		rep.setContentType("text/json;charset=utf-8");
		rep.setCharacterEncoding("UTF-8");
		
		byte[] jsonBytes;
	
			ReqUtil.write(rep, topicsJSON.toString());
		return null;
	}


	/**
	 * 用于掌上运维知识库讨论主题检索
	 * 
	 * @param mapping
	 *            action mapping
	 * @param actionForm
	 *            action form
	 * @param request
	 *            http servlet request
	 * @param rep
	 *            http servlet response
	 * @return action forward
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward searchAll4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws Exception {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String keywords = request.getParameter("keywords");
		if(StringUtil.isBlank(keywords)){
			log.info("参数keywords为空!");
			throw new AppException("","参数keywords为空");
		}
		Map paraMap = new HashMap();
		log.info("keywords=" + keywords);
		try {
			keywords = URLEncoder.encode(URLEncoder.encode(keywords, "utf-8"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("keywords=" + keywords);
		paraMap.put("search_keywords", keywords);
		paraMap.put("start_from", "0");
		paraMap.put("count", "200");
		Map resultMap = KbTopicDelegate.getDelegate().searchAll4REST(paraMap);
		List topicList = (List) resultMap.get("topicList");
		JSONArray topicsJSON = JSONArray.fromObject(topicList);
		
		rep.setContentType("text/json;charset=utf-8");
		rep.setCharacterEncoding("UTF-8");
		
		byte[] jsonBytes;
	
			ReqUtil.write(rep, topicsJSON.toString());
		return null;
	}
	
	/**
	 * 获得从客户端传入的json字符串
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJSON(HttpServletRequest request) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		return sb.toString();
	}
}
