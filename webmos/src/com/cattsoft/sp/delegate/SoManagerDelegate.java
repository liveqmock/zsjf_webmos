package com.cattsoft.sp.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesService;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesServiceLocator;
import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.SysConfigData;


public class SoManagerDelegate {
	private static Logger log = Logger.getLogger(SoManagerDelegate.class);

	private static SoManagerDelegate delegateInstance = null;

	private SoManagerDelegate() {

	}

	public static SoManagerDelegate getDelegate() {
		if (delegateInstance == null)
			return new SoManagerDelegate();
		return delegateInstance;
	}

	
	/**
	 * 功能：外堪处理信息回填
	 * 
	 * @param SoNbr：定单编号；
	 * @throws SysException
	 * @throws AppException
	 * @return void
	 */
	public String feedbackWo4MOS(String paramStr) throws AppException,
			SysException {
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
		//String urlStr = "http://127.0.0.1:7001/web/services/";
			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			String mosCallLog = client.svcCallIOMByMosNative(SysConstants.FUNCODE_MOD_FEEDBACK_WO, "", paramStr);
			return mosCallLog;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！");
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！");
		}
		return null;
	
	}
	
}
