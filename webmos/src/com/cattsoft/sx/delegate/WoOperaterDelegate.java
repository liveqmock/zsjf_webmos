package com.cattsoft.sx.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.IM4MOSServicesService;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesServiceLocator;
import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.im.service.webservice.client.RmsServiceForMos;
import com.cattsoft.im.service.webservice.client.RmsServiceForMosDelegate;
import com.cattsoft.im.service.webservice.client.RmsServiceForMosLocator;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sp.delegate.SoManagerDelegate;

public class WoOperaterDelegate {
	
	private static Logger log = Logger.getLogger(SoManagerDelegate.class);

	private static WoOperaterDelegate delegateInstance = null;

	private WoOperaterDelegate() {

	}
	public static WoOperaterDelegate getDelegate() {
		if (delegateInstance == null)
			return new WoOperaterDelegate();
		return delegateInstance;
	}
	
	/**
	 * 功能：初始化工单列表 
	 * 
	 * @param SoNbr：定单编号；
	 * @throws SysException
	 * @throws AppException
	 * @return void
	 */
	public String initWoList(String paramStr) throws AppException,
			SysException {
		try{
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate	 client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION, null, null, null,
//					null, null);
			
			String urlStr = "";
			//如果初始化缓存则使用缓存地址
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}
			
			
//	    	String urlStr =SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION;
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.woListInit(paramStr);
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
	
	
	/**
	 * 功能：status表配置查询 
	 * 
	 * @param SoNbr：定单编号；
	 * @throws SysException
	 * @throws AppException
	 * @return void
	 */
	public String systemStatus(String paramStr) throws AppException,
			SysException {
		try{
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate	 client = null;
//			String urlStr =SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
			
			String urlStr = "";
			//如果初始化缓存则使用缓存地址
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}
			
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.systemStatus(paramStr);
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
	
	/**
     * 初始化资源信息
     * @param paramStr
     * @return
     * @throws AppException
     * @throws SysException
     */
	public String initWoResInfo(String paramStr) throws AppException, SysException {
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
//			String urlStr = SysConstants.SYS_CONFIG_MOS_SERVER_ADDR;
			
			String urlStr = "";
			//如果初始化缓存则使用缓存地址
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}
			
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.rmsQuery(paramStr);
			return mosCallLog;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！");
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！");
		}

	}
	
	
	/**
	 * 预约工单 ，信息回填资源侧
	 */
	public String woBook(String paramStr) throws AppException, SysException {
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
			
			String urlStr = "";
			//如果初始化缓存则使用缓存地址
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}
			
			
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.workBook(paramStr);
			return mosCallLog;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！");
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！");
		}
	}
	/**
	 * 功能：初始化工单列表 
	 * 
	 * @param SoNbr：定单编号；
	 * @throws SysException
	 * @throws AppException
	 * @return void
	 */
	public String failReasonQuery(String paramStr) throws AppException,
			SysException {
		try{
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate	 client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION, null, null, null,
//					null, null);
			
			String urlStr = "";
			//如果初始化缓存则使用缓存地址
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}
			
			
//	    	String urlStr =SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION;
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.failReasonQuery(paramStr);
			log.debug(mosCallLog);
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
	/**
	 * 功能：初始化工单列表 
	 * 
	 * @param SoNbr：定单编号；
	 * @throws SysException
	 * @throws AppException
	 * @return void
	 */
	public String woOperate(String paramStr) throws AppException,
			SysException {
		try{
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate	 client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION, null, null, null,
//					null, null);
			
			String urlStr = "";
			//如果初始化缓存则使用缓存地址
			if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
					&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
						null, null);
			}else{
				//没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}
			
			log.debug("request参数： " + paramStr);
			
//	    	String urlStr =SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION;
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.woOperate(paramStr);
			
			log.debug("response参数： " + mosCallLog);
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
	

}
