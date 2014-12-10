package com.cattsoft.tz.delegate;

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


public class TZDeviceDelegate {
	private static Log log = LogFactory.getLog(TZDeviceDelegate.class);
	private static TZDeviceDelegate delegate = null;
	private TZDeviceDelegate() {

	}

	public static TZDeviceDelegate getDelegate() {
		if (delegate == null) {
			delegate = new TZDeviceDelegate();
		}
		return delegate;
	}	

	/**
	 * 调用IOM提供的服务
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String callIOMService4TZ(String funcId,String parameter) throws AppException,SysException{
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			
			String urlStr =  SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
						null, null);
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(funcId, "", parameter);
			
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！");
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！");
		}
		
		if(StringUtil.isExcetionInfo(result)){
			throw new AppException("", "" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}
	

}
