package com.cattsoft.webpub.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.LogUtil;


/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: ��������������<br>
 * Date: 2007-9-17 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class RelatedSelect {
	private static final Logger log = Logger.getLogger(RelatedSelect.class);

	
	public static final String RELATION_SELECT = "relationSelect";
	public static final String SELECT_VALUE = "value";
	
	
	
	
	
	
	/**
	 * ��list<LabelValueBean>ת����xml
	 * @param list
	 * @param relatedSelectName
	 * @return
	 * @throws AppException
	 */
	public static String convert2XML(List list,String relatedSelectName) throws AppException {
		StringBuffer xml = new StringBuffer("<response>");
		LabelValueBean lvbean ; 
		if(null == list||list.size()==0){
			xml.append("<relationSelect>");
			xml.append(relatedSelectName.trim());
			xml.append("</relationSelect>");
			xml.append("<option>");
			xml.append("<label>");
			xml.append("</label>");
			xml.append("<value>");
			xml.append("</value>");
			xml.append("</option>");
			xml.append("</response>");
			return xml.toString();
		}
		
		xml.append("<relationSelect>");
		xml.append(relatedSelectName.trim());
		xml.append("</relationSelect>");
		
		for(int i=0;i<list.size();i++){
			Object obj = list.get(i);
			if( !(obj instanceof LabelValueBean)){
				throw new AppException("500001","����Ĳ�����Ԫ�����ͱ�����List<LabelValueBean>��");
			}
			lvbean = (LabelValueBean)obj;
			xml.append("<option>");
			xml.append("<label>");
			xml.append(lvbean.getLabel());
			xml.append("</label>");
			xml.append("<value>");
			xml.append(lvbean.getValue());
			xml.append("</value>");
			xml.append("</option>");
		}
		
		xml.append("</response>");
		
		return xml.toString();
	}
	
	
	/**
	 * ��ת�����xml����
	 * @param request
	 * @param response
	 * @param list
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public static HttpServletResponse writeResponse(HttpServletRequest request,HttpServletResponse response,List list) throws SysException, AppException{
		String cartXml = "";
		
		String relatedSelectName = request.getParameter(RELATION_SELECT);
		
		cartXml = convert2XML(list,relatedSelectName);
		LogUtil.debug(log, "to_axaj:"+cartXml);
//		 ��XMLд��response.
		response.setContentType("text/xml;charset=UTF-8");
		try {
			response.getWriter().write(cartXml);
		} catch (IOException e) {
			LogUtil.error(log, e.getMessage());
			throw new SysException("500002","responseд�����",e);
		}
		return response;
	}

	/**
	 * ���ѡ���Ĳ���
	 * @param request
	 * @return
	 */
	public static String getSelectValue(HttpServletRequest request){
		return request.getParameter(SELECT_VALUE);
	}

	


	
}
