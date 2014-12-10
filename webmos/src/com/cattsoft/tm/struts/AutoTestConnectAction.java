package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.tm.delegate.AutoTestConnectDelegate;
import com.cattsoft.webpub.util.ReqUtil;

public class AutoTestConnectAction extends DispatchAction{
	
	public ActionForward initTestStep4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonStr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject initTestStepProObject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		String funCode = (String) initTestStepProObject.get("funCode");
		/*
		 * 此处可调用外部系统获取测试步骤
		 */
		String returnStr = AutoTestConnectDelegate.getDelegate().initTestStep4MOS(initTestStepProObject.toString());
		if("disconnect".equals(funCode)) {
			returnStr="线路测试,端口测试,服务测试,网元测试";
		}else {
			returnStr="模拟测试,仿生测试,线路测试,激活测试";
		}
		ReqUtil.write(response, returnStr);
		return null;
	}	
	
	public ActionForward autoTestStep4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonStr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject initTestStepProObject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		String funCode = (String) initTestStepProObject.get("funCode");
		/*
		 * 此处可调用外部系统获取测试结果
		 */
		String returnStr = AutoTestConnectDelegate.getDelegate().autoTestStep4MOS(initTestStepProObject.toString());
		if("线路测试".equals(funCode)) {
			returnStr="1,测试过程异常";
		}else if("服务测试".equals(funCode)){
			returnStr="0,测试过程异常二";
		} else {
			returnStr="0,测试过程正常三";
		}
		ReqUtil.write(response, returnStr);
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
