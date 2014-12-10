/**
 * 
 */
package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.MosCallLogDelegate;
import com.cattsoft.webpub.util.ReqUtil;

/**
 * @author maxun
 * CreateTime 2012-10-8 上午10:55:59
 */
public class MosCallLogAction extends DispatchAction{
	/**
	 * 查询通话记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author maxun
	 */
	public ActionForward queryCallLog4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject requestJsonObject=JSONObject.fromObject(ReqUtil.getRequestStr(request));
		JSONObject mosCallLogJsonObject=new JSONObject();
		if (requestJsonObject != null && !StringUtil.isBlank(requestJsonObject.getString("woNbr"))) {
			mosCallLogJsonObject.put("woNbr", requestJsonObject.getString("woNbr"));
		}
		String responseJson = MosCallLogDelegate.getDelegate().queryMosCallLog(mosCallLogJsonObject.toString());
		if("[]".equals(responseJson)||StringUtil.isBlank(responseJson)) {
//			throw new AppException("", "没有通话记录！");
			responseJson=StringUtil.getAppException4MOS("没有通话记录！");
		}
		if (responseJson!=null) {
			ReqUtil.write(response, responseJson);
		}
		return null;
	}
	
	/**
	 * 查询通话记录详情
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author maxun
	 */
	public ActionForward queryCallLogDetail4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject requestJsonObject=JSONObject.fromObject(ReqUtil.getRequestStr(request));
		JSONObject mosCallLogJsonObject=new JSONObject();
		if (requestJsonObject != null && !StringUtil.isBlank(requestJsonObject.getString("mosCallLogId"))) {
			mosCallLogJsonObject.put("mosCallLogId", requestJsonObject.getString("mosCallLogId"));
		}
		String responseJson = MosCallLogDelegate.getDelegate().queryMosCallLogDetail(mosCallLogJsonObject.toString());
		if("".equals(responseJson)||StringUtil.isBlank(responseJson)) {
//			throw new AppException("", "没有通话记录详情！");
			responseJson=StringUtil.getAppException4MOS("没有通话记录详情！");
		}
		if (responseJson!=null) {
			ReqUtil.write(response, responseJson);
		}
		return null;
	}
	public ActionForward addCallLog4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		
		String jsonStr = ReqUtil.getRequestStr(request);
		
		String isSuccess = MosCallLogDelegate.getDelegate().addMosCallLog4MOS(jsonStr);
		if(isSuccess!=null){
			ReqUtil.write(response, isSuccess);
		}else{
			ReqUtil.write(response, "success");
		}
		
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
