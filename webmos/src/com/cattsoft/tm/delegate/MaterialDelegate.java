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


public class MaterialDelegate {
	private static Log log = LogFactory.getLog(MaterialDelegate.class);
	private static MaterialDelegate delegate = null;
	private MaterialDelegate() {

	}

	public static MaterialDelegate getDelegate() {
		if (delegate == null) {
			delegate = new MaterialDelegate();
		}
		return delegate;
	}
	

	public String initMaterialTypeData4MOS(String jsonStr) throws SysException, AppException {
	
		
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
//				null, null);
		String urlStr = "";
		//如果初始化缓存则使用缓存地址
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
//		String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_INIT_MATERIAL_TYPE,
					null, jsonStr);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		return vesion;
		
	}
	
	public String findMaterialTypeData4MOS(String jsonStr) throws SysException, AppException {
		
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
//				null, null);
		String urlStr = "";
		//如果初始化缓存则使用缓存地址
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_QUERY_MATERIAL_TYPE,
					null, jsonStr);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		return vesion;
		
	}
	
	
	public void insertIntoMaterialData4MOS( String jsonStr ) throws SysException, AppException {
		
		
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
//				null, null);
		
		String urlStr = "";
		//如果初始化缓存则使用缓存地址
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_ADD_MATERIAL_TYPE,
					null, jsonStr);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		log.debug("client: " + client);
		
		
	}
	
	
public String updateIntoMaterialData4MOS( String jsonStr ) throws SysException, AppException {
		
		
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
//				null, null);
		
		String urlStr = "";
		//如果初始化缓存则使用缓存地址
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String res=null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			res=client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_UPDATE_MATERIAL_TYPE,
					null, jsonStr);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(res)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(res)); 
		}
		
		return res;
		
	}
	
	public void deleteAllMaterialByWo4MOS( String jsonStr ) throws SysException, AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
//				null, null);
		
		String urlStr = "";
		//如果初始化缓存则使用缓存地址
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
//		String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_DELETE_MATERIAL_TYPE,
					null, jsonStr);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		log.debug("client: " + client);
	}
	public String queryWoCount4MOS(String jsonStr ) throws SysException, AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		// String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
//				null, null);
		
		String urlStr = "";
		//如果初始化缓存则使用缓存地址
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			urlStr = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
			urlStr = SysConstants.MOS_SELF_SERVER_ADDR_FOR_ACTION;
		}
		
		
//		String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String vesion = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			vesion = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_QUERY_WO_COUNT,
					null, jsonStr);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(vesion)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(vesion)); 
		}
		
		return vesion;
		
	}
}
