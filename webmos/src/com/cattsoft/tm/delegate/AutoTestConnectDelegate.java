package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.im.service.webservice.client.IM4MOSServicesService;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesServiceLocator;
import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;


public class AutoTestConnectDelegate {
	private static Log log = LogFactory.getLog(AutoTestConnectDelegate.class);
	private static AutoTestConnectDelegate delegate = null;
	private AutoTestConnectDelegate() {

	}

	public static AutoTestConnectDelegate getDelegate() {
		if (delegate == null) {
			delegate = new AutoTestConnectDelegate();
		}
		return delegate;
	}	

	public String initTestStep4MOS(String jsonStr) throws SysException, AppException {
		return "";
	}
	
	public String autoTestStep4MOS(String jsonStr) throws SysException, AppException {
		return "";
	}

}
