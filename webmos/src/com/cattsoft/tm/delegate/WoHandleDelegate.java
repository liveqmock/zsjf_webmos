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
 * 
 * Title: 服务开通系统<br>
 * Description: 施工处理<br>
 * Date: 2007-6-15 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author 白小亮
 */

public class WoHandleDelegate {

	private static final Logger log = Logger.getLogger(WoHandleDelegate.class);

	// private SessionContext context;

	private static WoHandleDelegate delegate = new WoHandleDelegate();

	public static WoHandleDelegate getDelegate() {
		return delegate;
	}
	
	

	/**
	 * 初始化工单领取的工单列表
	 * @param jsonStr
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String query4MOS(String jsonStr) throws AppException, SysException {

		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_INIT_FETCH_LIST, "", jsonStr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	
	

	}	
	


	


	

	/*public List fetchBatWo4MOS(List wo,String woStaffId) throws SysException,
	AppException {
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_RETURN_INIT, "", mapStr);
			
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
		return result;
}
*/
	
	
	
/**
 * 主要是得到工区类型
 * @param woListString
 * @return
 * @throws SysException
 * @throws AppException
 */
	public String initSendTo4MOS(String woListString) throws SysException, AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		//String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
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
		
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String workAreaTypeList = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			workAreaTypeList= client.svcCallIOMByMosNative(SysConstants.FUNCODE_WORK_AREA_TYPE, null, woListString);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(workAreaTypeList)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(workAreaTypeList)); 
		}
		
		return workAreaTypeList;
	}
	

	/**
	 * 获得转派工区列表JSON字符串
	 * @param infoJsonObject
	 * @return
	 * @throws SysException 
	 */
	public String getChangeWorkArea4MOS(String infoJsonObject) throws AppException,SysException{
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
	//	String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
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
		
		
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String workAreaList = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
            workAreaList= client.svcCallIOMByMosNative(SysConstants.FUNCODE_CHANGE_WORK_AREA, null, infoJsonObject);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		
		if(StringUtil.isExcetionInfo(workAreaList)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(workAreaList)); 
		}
		
		return workAreaList;
		
	}
	/**
	 * 
	 * @param userInfoJson封装了前台传送的用户信息
	 * @throws SysException 
	 * @return返回转派页面中的本地网列表的JSON字符串形式
	 */
	public String getChangeLocalNet4MOS(String userInfoJson) throws AppException,SysException{
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
	//	String urlStr = "http://127.0.0.1:7001/web/services/";
		String urlStr = SysConfigData.getSysConfigCurValue(
				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
				null, null);
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String workAreaList = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
            workAreaList= client.svcCallIOMByMosNative(SysConstants.FUNCODE_CHANGE_LOCAL_NET, null, userInfoJson);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		if(StringUtil.isExcetionInfo(workAreaList)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(workAreaList)); 
		}
		
		return workAreaList;
		
	}
	

	/**
	 * 调用webservice层的得到转派原因列表方法
	 * @param failreasonSVOJson
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String findfailReasonName4MOS(String failreasonSVOJson)
			throws SysException, AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		//String urlStr = "http://127.0.0.1:7001/web/services/";
		
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
		
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//				null, null);
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String failReasonList = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			failReasonList= client.svcCallIOMByMosNative(SysConstants.FUNCODE_CHANGE_FAIL_REASON, null, failreasonSVOJson);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		
		if(StringUtil.isExcetionInfo(failReasonList)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(failReasonList)); 
		}
		
		return failReasonList;
	}

	/**
	 * 调用webservice层得到施工人员列表
	 * @param quryVOJson
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String getWorkStaff4MOS(String quryVOJson)
			throws SysException, AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		//String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
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
		
		
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String failReasonList = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			failReasonList = client.svcCallIOMByMosNative(
					SysConstants.FUNCODE_WORK_STAFF, null,
					quryVOJson);
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		}
		log.debug("client: " + client);
		
		
		if(StringUtil.isExcetionInfo(failReasonList)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(failReasonList)); 
		}
		
		return failReasonList;
	}

	public String sendTo4MOS(String woSVOJson) throws SysException,
			AppException {
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		//String urlStr = "http://127.0.0.1:7001/web/services/";
//		String urlStr = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
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
		
		urlStr = urlStr + "IM4MOSServices";
		URL url;
		String failReasonList = null;
		try {
			url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			failReasonList = client.svcCallIOMByMosNative(
					SysConstants.FUNCODE_CHANGE_ORDER_SUCCESS, null, woSVOJson);
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

	

	
	
//	/**
//	 * 初始化工单处理的工单列表
//	 * @param jsonStr
//	 * @return
//	 * @throws AppException
//	 * @throws SysException
//	 * @author maxun
//	 */
//	public String initWoLists4MOS(String jsonStr) throws AppException, SysException {
//		
//		try{
//			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
//			IM4MOSServices_PortType client = null;
//
////			String urlStr = "http://127.0.0.1:7001/web/services/";
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
//			urlStr = urlStr + "IM4MOSServices";
//			URL url = new URL(urlStr);
//			
//			client = service.getIM4MOSServices(url);
//			log.debug("client: " + client);
//			
//			String resultstr = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_INIT_WOLISTS, "", jsonStr);
//		
//			log.debug("commit:" + DateUtil.getDBDate());
//		
//			return resultstr;
//
//		} catch (com.cattsoft.im.service.webservice.client.AppException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (com.cattsoft.im.service.webservice.client.SysException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (MalformedURLException e) {
//			log.info(e.toString());
//			throw new AppException("", "webserviceURL地址错误！");
//		} catch (ServiceException e) {
//			log.info(e.toString());
//			throw new AppException("", "调用远程webservice方法失败！");
//		}
//		return null;
//	}	
	
//	工单查询4MOS
//	public String initWoList4MOS(String jsonStr) throws AppException, SysException {
//	
//		try{
//			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
//			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
//
//	//		String urlStr = "http://127.0.0.1:7001/web/services/";
//			urlStr = urlStr + "IM4MOSServices";
//			URL url = new URL(urlStr);
//			
//			client = service.getIM4MOSServices(url);
//			log.debug("client: " + client);
//			
//			String resultstr = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_INIT_WOLIST,null,jsonStr);
//		
//			log.debug("commit:" + DateUtil.getDBDate());
//		
//			return resultstr;
//
//		} catch (com.cattsoft.im.service.webservice.client.AppException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (com.cattsoft.im.service.webservice.client.SysException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (MalformedURLException e) {
//			log.info(e.toString());
//			throw new AppException("", "webserviceURL地址错误！");
//		} catch (ServiceException e) {
//			log.info(e.toString());
//			throw new AppException("", "调用远程webservice方法失败！");
//		}
//		return null;
//	}	
//	
//	流程查询4MOS
	public String queryProcess4MOS(String jsonStr) throws AppException, SysException {

		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_PROCESS_QUERY, "", jsonStr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	
	}	

    //	发送短信4MOS
	public String sendMsg4MOS(String jsonStr) throws AppException, SysException {
	
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
			
			
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
			

	//		String urlStr = "http://127.0.0.1:7001/web/services/";
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			String resultstr = client.svcCallIOMByMosNative(SysConstants.FUNCODE_MSG_SEND, "", jsonStr);
		
			if(StringUtil.isExcetionInfo(resultstr)){
				throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(resultstr)); 
			}
			
			return resultstr;

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
		

	
	

//	//4mos initWoDetail 修改后的方法
//	public String initWoDetail4MOS(String jsonStr) throws SysException, AppException {
//	
//		try{
//			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
//			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
//	//		String urlStr = "http://127.0.0.1:7001/web/services/";
//			urlStr = urlStr + "IM4MOSServices";
//			URL url = new URL(urlStr);
//			
//			client = service.getIM4MOSServices(url);
//			log.debug("client: " + client);
//			
//			String resultstr = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_Detail, "", jsonStr);
//		
//			log.debug("commit:" + DateUtil.getDBDate());
//		
//			return resultstr;
//
//		} catch (com.cattsoft.im.service.webservice.client.AppException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (com.cattsoft.im.service.webservice.client.SysException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (MalformedURLException e) {
//			log.info(e.toString());
//			throw new AppException("", "webserviceURL地址错误！");
//		} catch (ServiceException e) {
//			log.info(e.toString());
//			throw new AppException("", "调用远程webservice方法失败！");
//		}
//		return null;
//	}	
//	
	
	
	
	

	public String handleLater4MOS(String woNumJson) throws SysException,AppException {
		
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			//String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,null, null);
//			String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			String handle = client.svcCallIOMByMosNative(SysConstants.FUNCODE_HANDLE_LATER, "", woNumJson);
			
			if(StringUtil.isExcetionInfo(handle)){
				throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(handle)); 
			}
			
			return handle;
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
	
	
	
	/**
	 * 批量领单
	 * @ejb.interface-method view-type = "both"
	 * @param woJSONstr
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String fetchBatWo4MOS(String woJSONstr) throws SysException,AppException{
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_FETCH, "", woJSONstr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	
	}
	
	
	
	
	

	
	
	
	/**
	 * 初始化工单处理的工单列表
	 * @param jsonStr
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @author maxun
	 */
	public String initWoLists4MOS(String jsonStr) throws AppException, SysException {

		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_INIT_WOLISTS, "", jsonStr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	

	}	
	
	//4mos initWoDetail 修改后的方法
	public String initWoDetail4MOS(String jsonStr) throws SysException, AppException {
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_Detail, "", jsonStr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}	
	
	/**
	 * 手机终端调用，勿调用该方法
	 * @ejb.interface-method view-type = "both"
	 * @param woList
	 * @param retType
	 * @param paramMap
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String initReturnWo4MOS(String mapStr) throws SysException, AppException {
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_RETURN_INIT, "", mapStr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
		
	}
	
	
	/**
	 * 失败回单（退单处理）
	 * @param Map
	 *            paramMap 参数列表
	 * @throws AppException
	 * @throws SysException
	 */
	public String failReturn4MOS(String paramStr) throws AppException, SysException{
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_RETURN_FAIL, "", paramStr);
			
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
		
		
		if(StringUtil.isExcetionInfo(result)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		return result;
	}
	
	/**
	 * 成功回单
	 * @param Map
	 * paramMap 参数列表
	 * @throws AppException
	 * @throws SysException
	 */
	public String successReturn4MOS(String paramMapStr) throws AppException, SysException {
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_RETURN_SUCCESS, "", paramMapStr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	
	}
	
	
	/**
	 * MOS 工单查询用
	 * @param jsonstr
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String initWoList4MOS(String jsonstr) throws AppException, SysException{
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_INIT_WOLIST, "", jsonstr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}
	
	
	/**
	 * 初始化网格维护
	 * @param jsonstr
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String initServDept4MOS(String jsonstr) throws AppException, SysException{
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
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_INIT_SERV_DEPT, "", jsonstr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}
	
	
	/**
	 * 网格维护修改
	 * @param jsonstr
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String modiServDept4MOS(String jsonstr) throws AppException, SysException{
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
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_MODI_SERV_DEPT, "", jsonstr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}
	
	/**
	 * 网格数据联动
	 * @param jsonstr
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String chgServDept4MOS(String jsonstr) throws AppException, SysException{
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
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_CHG_SERV_DEPT, "", jsonstr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}
	
	/**
	 * 预约功能
	 * @param jsonstr
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String upDateReservationTimeRecorde4MOS(String jsonstr) throws AppException, SysException{
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
			
			result = client.svcCallIOMByMosNative(SysConstants.FUNCODE_RESERVE_DATE_TIME, "", jsonstr);
			
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
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		
		return result;
	}
}