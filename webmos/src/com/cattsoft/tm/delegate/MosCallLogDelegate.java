/**
 * 
 */
package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.IM4MOSServicesService;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesServiceLocator;
import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;


/**
 * @author maxun
 * CreateTime 2012-9-29 上午10:00:34
 */
public class MosCallLogDelegate {
	private static final Logger log = Logger.getLogger(MosCallLogDelegate.class);

	private static MosCallLogDelegate delegate = null;

	public static MosCallLogDelegate getDelegate() {
		if (delegate != null) {

		} else {
			delegate = new MosCallLogDelegate();
		}
		return delegate;
	}
	
	
	public String queryMosCallLog(String mosCallLogJson) throws SysException, AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//				null, null);
		String urlStr = "";
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String result = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			result = client.svcCallIOMByMosNative(
					SysConstants.FUNCODE_QUERY_MOS_CALL_LOG, null, mosCallLogJson);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(result)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}
	
	public String queryMosCallLogDetail(String mosCallLogJson) throws SysException, AppException {
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			String urlStr = "";
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
			}
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			String mosCallLog = client.svcCallIOMByMosNative(SysConstants.FUNCODE_QUERY_MOS_CALL_LOG_DETAIL, "", mosCallLogJson);
			
			if(StringUtil.isExcetionInfo(mosCallLog)){
				throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(mosCallLog)); 
			}
			
			return mosCallLog;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！");
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！");
		}
	}
	
	public String addMosCallLog4MOS(String paraMapString)throws AppException,SysException {
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
			String urlStr = "";
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
			}
		//	String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			String call = client.svcCallIOMByMosNative(SysConstants.FUNCODE_ADD_MOS_CALL_LOG,null,paraMapString);
		    
			if(StringUtil.isExcetionInfo(call)){
				throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(call)); 
			}
			
			return call;
		}  catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！");
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！");
		}
	}
	
	
}
