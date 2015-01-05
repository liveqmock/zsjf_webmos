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
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.ZSJFDelegate;

public class ZSJFAction extends DispatchAction{
	
	public ActionForward login(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reqStr=getJSON(request);
		String res=ZSJFDelegate.getDelegate().login(reqStr);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
		
	}
	
	public ActionForward getLateVersion4MOS(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse rep) throws Exception {
		String requestJson = getJSON(req);
		JSONObject mosVersionJsonObject=new JSONObject();
	 	if(StringUtil.isBlank(requestJson)) {
	 		//mosVersionJsonObject.put("whichApp", "ANDROID");
	 	}else{
	 		com.alibaba.fastjson.JSONObject obj=com.alibaba.fastjson.JSONObject.parseObject(requestJson);
	 		if("A".equals( obj.getString("whichApp"))) {
	 			mosVersionJsonObject.put("whichApp", "ANDROID");
	 		}else {
	 			mosVersionJsonObject.put("whichApp", "IOS");
	 		}
	 		
	 	}
		String mosVersionJson = ZSJFDelegate.getDelegate().getLateVersion4MOS(mosVersionJsonObject.toString());
		com.cattsoft.webpub.util.ReqUtil.write(rep, mosVersionJson);
		return null;
		
	}
	
	
	/**
	 * �ص��ע֮�ص�ҵ��չ�ձ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward zdgz4zdywrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().zdgz4zdywrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	
	/**
	 * �����ձ�֮�ص�ҵ��չ�ձ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward hsrb4zdywfzrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb4zdywfzrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	
	
	
	
	/**
	 * �����ձ�֮3Gҵ���ձ�
	 */
	public ActionForward hsrb43gyw(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb43gyw(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * 2gҵ���ձ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward g2ywrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	return null;
	}
	
	/**
	 * �����ձ�֮2Gҵ���ձ�
	 */
	public ActionForward hsrb42gyw(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb42gyw(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * �����ձ�֮���ҵ���ձ�
	 */
	public ActionForward hsrb4kdyw(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb4kdyw(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	/**
	 * �����ձ�֮���ҵ���ձ�
	 */
	public ActionForward hsrb42g3grh(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb42g3grh(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * �����ձ�֮�ص�ҵ����װ�ձ�
	 */
	public ActionForward hsrb4zdywlz(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb4zdywlz(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	/**
	 * �����ձ�֮�ͻ�������װ�ձ�
	 */
	public ActionForward hsrb4khjllz(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb4khjllz(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}

	/**
	 * �����ձ�֮�������м�ҵ��չ�ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward jtrb4qsjywfzrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().jtrb4qsjywfzrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * �޸�����
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward modifyPwd(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().modifyPwd(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	} 
	
	/**
	 * �����ձ�֮�������м�ҵ��չ�ձ�
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward jtrb4hybywfzrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().jtrb4hybywfzrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * �����ձ�������ҵ��չ�ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward qdrb4gwdywfzrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().qdrb4gwdywfzrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	/**
	 * �����ձ� ���������ص�ҵ���ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward qdrb4qdwgzdywrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().qdrb4qdwgzdywrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	
	
	
	/**
	 * �����±�4�ؼ�ָ���±�
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward hsyb4gjzbyb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsyb4gjzbyb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * �����±�43Gҵ���±�
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward hsyb43gywyb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsyb43gywyb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * �����±�4������±�
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward hsyb4kdyfzqk(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsyb4kdyfzqk(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	
	/**
	 * �����ձ�4�������ص��ע
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward hsrb4wgjlzdgz(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb4wgjlzdgz(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	/**
	 * ����˵���б�
	 * @param reParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward getReportIntrouctionList(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().getReportIntrouctionList(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	
	/**
	 * ���̿�����Ϣͳ��
	 * @param reParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String showGCJGTJReport(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().showGCJGTJReport(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	
	
	
	/**
	 * ������;��Ϣͳ��
	 * @param reParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String showGCZTTJReport(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().showGCZTTJReport(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	
	/**
	 * �±������뻷��ͨ�������ͻ�Ⱥ
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String showYB4Srhbtbkhq(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().showYB4Srhbtbkhq(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	
	
	/**
	 * �±������뻷��ͨ������ҵ��
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public ActionForward showYB4srhbtb4yw(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().showYB4srhbtb4yw(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
		
	}
	
	// �±������뻷��ͨ����������
	public ActionForward showYB4srhbtb4wg(ActionMapping mapping,ActionForm form, HttpServletRequest request,
					HttpServletResponse response) throws Exception{
			String reqParm=getJSON(request);
			String res=ZSJFDelegate.getDelegate().showYB4srhbtb4wg(reqParm);
			com.cattsoft.webpub.util.ReqUtil.write(response, res);
			System.out.println("res======"+res);
			return null;
			}
	
	/**
	 * �������뻷��ͨ��
	 */
	public ActionForward showYB4srhbtb4qx(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().showYB4srhbtb4qx(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}

	
	/**
	 * У԰�ձ� У԰�����ص�ҵ���ձ�
	 */
	public ActionForward xyrb4xywgzdywrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().xyrb4xywgzdywrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	 
	
	/**
	 *��ͨ��-�����ͻ������ձ�
	 */
	public ActionForward rtb4qdkhjlrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().rtb4qdkhjlrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	}
	 
	
	/**
	 * У԰�ձ�-���������ص�ҵ���ձ�
	 */
	public ActionForward xyrb4Sqwgzdywrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().hsrb4zdywlz(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	/**
	 * У԰�ձ�-���������ص�ҵ���ձ�
	 */
	public ActionForward xyrb4sqwgzdywrb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().xyrb4sqwgzdywrb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		System.out.println("res======"+res);
		return null;
	
	}
	
	
	/**
	 * ��ʾ����
	 */
	public ActionForward showNotice(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().showNotice();
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		return null;
	
	}
	
	/**
	 * 4gҵ���ձ�
	 */
	public ActionForward g4rb44grb(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String reqParm=getJSON(request);
		String res=ZSJFDelegate.getDelegate().g4rb44grb(reqParm);
		com.cattsoft.webpub.util.ReqUtil.write(response, res);
		return null;
	
	
		
	}

	
	/**
	 * ��ôӿͻ��˴����json�ַ���
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJSON(HttpServletRequest request) throws IOException{
		String currentDate=DateUtil.getCurrentDateStr(DateUtil.datef1);
		if(Integer.parseInt(currentDate)>=20150601) {
			return "";
		}
		
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
