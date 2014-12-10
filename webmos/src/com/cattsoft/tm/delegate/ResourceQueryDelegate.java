package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.RmsServiceForMos;
import com.cattsoft.im.service.webservice.client.RmsServiceForMosDelegate;
import com.cattsoft.im.service.webservice.client.RmsServiceForMosLocator;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sp.delegate.SoManagerDelegate;

public class ResourceQueryDelegate {

	private static Logger log = Logger.getLogger(SoManagerDelegate.class);

	private static ResourceQueryDelegate delegateInstance = null;

	private ResourceQueryDelegate() {

	}

	public static ResourceQueryDelegate getDelegate() {
		if (delegateInstance == null)
			return new ResourceQueryDelegate();
		return delegateInstance;
	}

	public String queryDevice(String paramStr) throws AppException,
			SysException {
		String urlStr = "";
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;
			// String urlStr = SysConfigData.getSysConfigCurValue(
			// SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
			// null, null);

			// 如果初始化缓存则使用缓存地址
			if (!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null,
					null, null))
					&& SysConstants.TRUE.equals(SysConfigData
							.getSysConfigCurValue(
									SysConstants.SYS_CONFIG_MOS_INIT_CONFIG,
									null, null, null, null, null))) {
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null,
						null, null, null);
			} else {
				// 没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}

			// String urlStr = SysConstants.SYS_CONFIG_MOS_SERVER_ADDR;
//			urlStr = "http://10.22.1.41:8080/trms/services/RmsForMosService";
			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosLoginRep = client.deviceQuery(paramStr);

			return mosLoginRep;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！" + urlStr
					+ e.getMessage());
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		}

	}

	public String systemStatus(String paramStr) throws AppException,
			SysException {
		String urlStr = "";
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;
			// String urlStr
			// =SysConstants.SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION;
			// String urlStr = SysConfigData.getSysConfigCurValue(
			// SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
			// null, null);

			// 如果初始化缓存则使用缓存地址
			if (!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null,
					null, null))
					&& SysConstants.TRUE.equals(SysConfigData
							.getSysConfigCurValue(
									SysConstants.SYS_CONFIG_MOS_INIT_CONFIG,
									null, null, null, null, null))) {
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null,
						null, null, null);
			} else {
				// 没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}

			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.systemStatus(paramStr);
			return mosCallLog;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！" + urlStr
					+ e.getMessage());
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		}

	}

	public String resQuery(String paramStr) throws AppException, SysException {
		String urlStr = "";
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;

			urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null, null, null);

			// urlStr = "http://10.21.1.29:8080/trms/services/RmsForMosService";
//			urlStr = "http://192.168.100.233:1991/trms/services/RmsForMosService";

			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.resQuery(paramStr);
			return mosCallLog;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！" + urlStr
					+ e.getMessage());
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		}

	}

	public String portAndConnQuery(String paramStr) throws AppException,
			SysException {
		String urlStr = "";
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;

			// 如果初始化缓存则使用缓存地址
			if (!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null,
					null, null))
					&& SysConstants.TRUE.equals(SysConfigData
							.getSysConfigCurValue(
									SysConstants.SYS_CONFIG_MOS_INIT_CONFIG,
									null, null, null, null, null))) {
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null,
						null, null, null);
			} else {
				// 没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}

			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.portAndConnQuery(paramStr);
			return mosCallLog;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！" + urlStr
					+ e.getMessage());
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		}

	}

	public String resChange(String paramStr) throws AppException, SysException {
		String urlStr = "";
		try {
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;

			// 如果初始化缓存则使用缓存地址
			if (!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null,
					null, null))
					&& SysConstants.TRUE.equals(SysConfigData
							.getSysConfigCurValue(
									SysConstants.SYS_CONFIG_MOS_INIT_CONFIG,
									null, null, null, null, null))) {
				urlStr = SysConfigData.getSysConfigCurValue(
						SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null,
						null, null, null);
			} else {
				// 没有初始化则使用常量
				urlStr = SysConstants.MOS_SERVER_ADDR_FOR_ACTION;
			}

			URL url = new URL(urlStr);
			client = service.getRmsServiceForMosPort(url);
			String mosCallLog = client.resChange(paramStr);
			return mosCallLog;
		} catch (RemoteException e) {
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		} catch (MalformedURLException e) {
			log.info(e.toString());
			throw new AppException("", "webserviceURL地址错误！" + urlStr
					+ e.getMessage());
		} catch (ServiceException e) {
			log.info(e.toString());
			throw new AppException("", "调用远程webservice方法失败！" + urlStr
					+ e.getMessage());
		}
	}

}
