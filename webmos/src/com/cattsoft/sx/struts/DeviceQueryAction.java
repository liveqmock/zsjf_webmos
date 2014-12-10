package com.cattsoft.sx.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.xmlbeans.XmlException;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.sx.delegate.DeviceQueryDelegate;
import com.cattsoft.sx.delegate.WoOperaterDelegate;

public class DeviceQueryAction extends DispatchAction{

private static Logger log = Logger.getLogger(DeviceQueryAction.class);
	
	public DeviceQueryAction(){		
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
	public ActionForward queryDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, XmlException {
		log.debug("资源查询 ");
		
		String requestxml=getXML(request);
		String responsexml=DeviceQueryDelegate.getDelegate().queryDevice(requestxml);
		byte[] xmlBytes = responsexml.toString().getBytes("utf-8");
		response.setContentLength(xmlBytes.length);
		response.getOutputStream().write(xmlBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}
}
