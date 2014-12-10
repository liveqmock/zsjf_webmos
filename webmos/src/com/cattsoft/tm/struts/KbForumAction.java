package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.tm.delegate.KbForumDelegate;
import com.cattsoft.webpub.util.ReqUtil;

/**
 * 
 * Title: 服务开通系统-知识库子系统<br>
 * Description: 讨论区管理<br>
 * Date: 2012-8-21 <br>
 * Copyright (c) 2012 CATTSoft<br>
 * 
 * @author 鲁攀
 */
public class KbForumAction extends DispatchAction {

	/**
	 * 无参构造函数
	 */
	public KbForumAction() {
	}


	/**
	 * 用于掌上运维知识库讨论区查询
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
	 * @throws Exception
	 */
	public ActionForward listForum4MOS(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse rep) throws Exception {
		
		 //从request 中取出json条件串,从而获得条件
		String jsonString =  ReqUtil.getRequestStr(request);
		JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		//把对象转化成为json字符串
		JSONObject json=new JSONObject();

		Map paraMap = new HashMap();
		Map resultMap = KbForumDelegate.getDelegate().findKbForum4REST(paraMap);
		List forumList = (List) resultMap.get("forumList");
		JSONArray forumJSON = JSONArray.fromObject(forumList);
		
//		rep.setContentType("text/json;charset=utf-8");
//		rep.setCharacterEncoding("UTF-8");
		
		byte[] jsonBytes;
		ReqUtil.write(rep, forumJSON.toString());
//			jsonBytes =forumJSON.toString().getBytes("utf-8");
//			rep.setContentLength(jsonBytes.length);
//			rep.getOutputStream().write(jsonBytes);
//			rep.getOutputStream().flush();
//			rep.getOutputStream().close();
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
