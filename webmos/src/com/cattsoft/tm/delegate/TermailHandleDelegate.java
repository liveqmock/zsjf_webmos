package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.im.service.webservice.client.IMos2Rms;
import com.cattsoft.im.service.webservice.client.IMos2RmsService;
import com.cattsoft.im.service.webservice.client.IMos2RmsServiceLocator;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sp.delegate.SoManagerDelegate;

public class TermailHandleDelegate {

	private static Logger log = Logger.getLogger(SoManagerDelegate.class);

	private static TermailHandleDelegate delegateInstance = null;

	private TermailHandleDelegate() {

	}
	public static TermailHandleDelegate getDelegate() {
		if (delegateInstance == null)
			return new TermailHandleDelegate();
		return delegateInstance;
	}
	public String termailHandle(String paramStr,String funcode) throws AppException, SysException {

		IMos2RmsService service = new IMos2RmsServiceLocator();
		IMos2Rms client=null;
	
		String urlStr = SysConstants.MOS_SERVICE_ADDR_FOR_RMS;
		URL url;
		String failReasonList = null;
		try {
			url = new URL(urlStr);
			client = service.getIMos2RmsPort(url);
			failReasonList = client.mos2Rms(funcode, "", paramStr);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(failReasonList)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(failReasonList)); 
		}
		
		return failReasonList;
	
	}
	
	
	
}
