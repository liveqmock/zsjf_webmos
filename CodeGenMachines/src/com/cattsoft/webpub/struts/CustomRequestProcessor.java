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
 * Title: ����ͨϵͳ<br>
 * Description: Ϊ�˷��㼯�д���ͻ��˵���������롢Ȩ�޵ȣ�<br>
 * ��struts��RequestProcessor�п���ͳһ���봦����롣<br>
 * �ڴ˴�����ã�����Ҫ��struts-config.xml�ļ��м��붨�塣<br>
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
	 * http�����Ԥ���������������У���������ı�����иı䣬��ΪGBK����ͳһ����������⡣
	 * 
	 * @param request
	 *            HttpServletRequest http�����request
	 * @param response
	 *            HttpServletResponse http�������Ӧ
	 * @return boolean
	 */
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("GB2312");
			// �����ж�session�Ƿ�ʧЧ������
			String url = request.getRequestURI();
			String method = request.getParameter("method");
			if (log.isDebugEnabled())
				log.debug(url);
			//SysUserExtendedMVO suve = (SysUserExtendedMVO) request.getSession().getAttribute(
			//		SysUserExtendedMVO.SESSION_NAME);
			// �жϵ�¼��ַ�Ƿ������¼��ַ
		/*	if (url.indexOf("loginAction.do") == -1) {
				if (suve == null) {
					if (log.isDebugEnabled())
						log.debug("session ʧЧ�����µ�¼������");
					response.sendRedirect(request.getContextPath() + "/redirect.jsp");
					return false;
				}
			} else {// ���������¼��ַ�����жϷ����Ƿ�Ϊ��¼�����򲻵�¼ϵͳ����ϵͳ���ӵĽӿڡ�

				if (log.isDebugEnabled())
					log.debug(method);
				if (!method.equals("login") && !method.equalsIgnoreCase("directVisitUrl")) {
					if (suve == null) {
						if (log.isDebugEnabled())
							log.debug("session ʧЧ�����µ�¼����������ΪloginAction.do��ķ�����");
						response.sendRedirect(request.getContextPath() + "/redirect.jsp");
						return false;
					}
				}

			}
*/
			/**
			 * mod CRM���ü�Ȩ��ס�˶� cason_lau //��Ȩ������ if(log.isDebugEnabled()) log.debug("��ʼ��Ȩ������");
			 * //������¼���ӵĲ���Ȩ if (url.indexOf("loginAction.do") == -1) { int localNetId=0; if
			 * (suve.getCurrentWorkAreaVO() == null) localNetId =
			 * suve.getSysUserVO().getPartyRole().getParty(). getLocalNetId().intValue(); else
			 * localNetId=suve.getCurrentWorkAreaVO().getLocalNetId().intValue(); Long sysUserId =
			 * suve.getSysUserVO().getSysUserId(); String href = url + "?method=" + method;
			 * if(log.isDebugEnabled()) log.debug(href); boolean
			 * bl=SMSysUserDelegate.getDelegate().authUserFunc(sysUserId, href,localNetId);
			 * if(log.isDebugEnabled()) log.debug("�Ƿ���Ȩ�ޣ�"+bl); if(!bl) throw new
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
