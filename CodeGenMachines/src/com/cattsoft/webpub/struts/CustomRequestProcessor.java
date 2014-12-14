package com.cattsoft.webpub.struts;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.RequestProcessor;

//import com.cattsoft.sm.vo.SysUserExtendedMVO;

/**
 * 
 * Title: 服务开通系统<br>
 * Description: 为了方便集中处理客户端的请求，如编码、权限等，<br>
 * 在struts的RequestProcessor中可以统一加入处理代码。<br>
 * 在此处定义好，还需要在struts-config.xml文件中加入定义。<br>
 * Date: 2007-9-15 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class CustomRequestProcessor extends RequestProcessor {
	private static Log log = LogFactory.getLog(CustomRequestProcessor.class);

	public CustomRequestProcessor() {
	}

	/**
	 * http请求的预处理函数。本函数中，仅对请求的编码进行改变，改为GBK，以统一解决中文问题。
	 * 
	 * @param request
	 *            HttpServletRequest http请求的request
	 * @param response
	 *            HttpServletResponse http请求的响应
	 * @return boolean
	 */
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("GB2312");
			// 以下判断session是否失效。。。
			String url = request.getRequestURI();
			String method = request.getParameter("method");
			if (log.isDebugEnabled())
				log.debug(url);
			//SysUserExtendedMVO suve = (SysUserExtendedMVO) request.getSession().getAttribute(
			//		SysUserExtendedMVO.SESSION_NAME);
			// 判断登录地址是否包含登录地址
		/*	if (url.indexOf("loginAction.do") == -1) {
				if (suve == null) {
					if (log.isDebugEnabled())
						log.debug("session 失效，重新登录。。。");
					response.sendRedirect(request.getContextPath() + "/redirect.jsp");
					return false;
				}
			} else {// 如果包括登录地址，再判断方法是否为登录方法或不登录系统访问系统链接的接口。

				if (log.isDebugEnabled())
					log.debug(method);
				if (!method.equals("login") && !method.equalsIgnoreCase("directVisitUrl")) {
					if (suve == null) {
						if (log.isDebugEnabled())
							log.debug("session 失效，重新登录。。。方法为loginAction.do里的方法。");
						response.sendRedirect(request.getContextPath() + "/redirect.jsp");
						return false;
					}
				}

			}
*/
			/**
			 * mod CRM不用鉴权封住此段 cason_lau //鉴权。。。 if(log.isDebugEnabled()) log.debug("开始鉴权。。。");
			 * //包含登录链接的不鉴权 if (url.indexOf("loginAction.do") == -1) { int localNetId=0; if
			 * (suve.getCurrentWorkAreaVO() == null) localNetId =
			 * suve.getSysUserVO().getPartyRole().getParty(). getLocalNetId().intValue(); else
			 * localNetId=suve.getCurrentWorkAreaVO().getLocalNetId().intValue(); Long sysUserId =
			 * suve.getSysUserVO().getSysUserId(); String href = url + "?method=" + method;
			 * if(log.isDebugEnabled()) log.debug(href); boolean
			 * bl=SMSysUserDelegate.getDelegate().authUserFunc(sysUserId, href,localNetId);
			 * if(log.isDebugEnabled()) log.debug("是否有权限："+bl); if(!bl) throw new
			 * AppException("3300013"); }
			 */

		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} 

		return true;
	}
}
