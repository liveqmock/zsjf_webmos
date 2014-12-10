/**
 * 
 */
package com.cattsoft.sx.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sx.delegate.StaffLocationDelegate;

/**
 * @author maxun
 * CreateTime 2012-10-8 上午10:55:59
 */
public class StaffLocationAction extends DispatchAction{

	public ActionForward addStaffLocation4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		
		String requestXml = getXML(request);
		
		String responseXml = StaffLocationDelegate.getDelegate().addStaffLocation4MOS(requestXml);
	//	responseXml = loginRepDoc.toString();
		if (responseXml!=null) {
			byte[] xmlBytes = responseXml.toString().getBytes("utf-8");
			response.setContentLength(xmlBytes.length);
			response.getOutputStream().write(xmlBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}		
		return null;
	}
	
	public ActionForward getSendLocationInterval(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		String sendLocationInterval=SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SEND_LOCATION_INTERVAL, null, null, null, null, null);
		if (sendLocationInterval!=null) {
			byte[] sendLocationIntervalBytes = sendLocationInterval.toString().getBytes("utf-8");
			response.setContentLength(sendLocationIntervalBytes.length);
			response.getOutputStream().write(sendLocationIntervalBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
		return null;
	}
	
	/**
	 * 获得从客户端传入的XML字符串
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getXML(HttpServletRequest request) throws IOException {
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
