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
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.sx.delegate.LoginDelegate;
import com.cattsoft.sx.delegate.WoBookDelegate;
import com.cattsoft.xml4mos.xmlbeans.WoBookRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.WoBookRequestDocument.WoBookRequest;
import com.cattsoft.xml4mos.xmlbeans.WoBookRequestDocument.WoBookRequest.WoBook;

public class WoBookAction extends DispatchAction{
	
	private static Logger log = Logger.getLogger(WoBookAction.class);
	
	public WoBookAction(){		
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
	/**
	 * 预约功能
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 * @throws XmlException
	 */
	public ActionForward woBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, XmlException {
		log.debug("预约功能......");      
		String responseXml = null;
		//获得xml字符串
		String requestXml = getXML(request);
		if (StringUtil.isBlank(requestXml)) {
			throw new AppException("", "MOS客户端请求为空");
		}
		responseXml = WoBookDelegate.getDelegate().woBook(requestXml);
		if (responseXml!=null) {
			byte[] xmlBytes = responseXml.toString().getBytes("utf-8");
			response.setContentLength(xmlBytes.length);
			response.getOutputStream().write(xmlBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}	
				return null;
		
	}


}
