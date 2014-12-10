package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.im.service.webservice.client.IM4MOSServicesService;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesServiceLocator;
import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.SysConfigData;



public class WoDetailDelegate {
	private static Log log = LogFactory.getLog(WoDetailDelegate.class);

	private static WoDetailDelegate delegate = null;
	
	private WoDetailDelegate(){
		
	}

	public static WoDetailDelegate getDelegate() {
		if(delegate == null)
		{
			delegate = new WoDetailDelegate();
		}
		return delegate;
	}
	
	public String getWoHandleInfo(String jsonStr) throws SysException, AppException {

		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			String urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
//	//		String urlStr = "http://127.0.0.1:7001/web/services/";
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			String resultstr = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_WO_HANDLE_INFO, "", jsonStr);
			log.debug("commit:" + DateUtil.getDBDate());
			return resultstr;
		}  catch (RemoteException e) {
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
