/**
 * 
 */
package com.cattsoft.sx.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;

import javax.ejb.CreateException;
import javax.naming.NamingException;
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
import com.cattsoft.pub.util.SysInit;


/**
 * @author maxun
 * CreateTime 2012-9-29 上午10:00:34
 */
public class StaffLocationDelegate {
	private static final Logger log = Logger.getLogger(StaffLocationDelegate.class);

	private static StaffLocationDelegate delegate = null;

	public static StaffLocationDelegate getDelegate() {
		if (delegate != null) {

		} else {
			delegate = new StaffLocationDelegate();
		}
		return delegate;
	}
	
	public String addStaffLocation4MOS(String paramStr) throws SysException, AppException {
		String str = "";
		try{
			RmsServiceForMos service = new RmsServiceForMosLocator();
			RmsServiceForMosDelegate client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
			String urlStr = "";
		
			 urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_FLAG_ADDR, null, null, null,null, null);
		
			 if(!"IOM".equals(urlStr) ){
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
				
	//			String urlStr = SysConstants.SYS_CONFIG_MOS_SERVER_ADDR;
				URL url = new URL(urlStr);
				client = service.getRmsServiceForMosPort(url);
				String mosStaffLocationRep = client.realPosition(paramStr);
				return mosStaffLocationRep;
			}
			else{
			 str=	addIomStaffLocation4MOS(paramStr);
			}
			
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
		return str;
	}
	
	public String addAutoSignatureLocation4MOS(String paramStr) throws SysException, AppException {
		String str = "";
//		try{
//			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
//			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,null, null);
//			urlStr = urlStr + "IM4MOSServices";
//			URL url = new URL(urlStr);
//			client = service.getIM4MOSServices(url);
//			log.debug("client: " + client);
//			str =	client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_ADD_STAFF_LOCATION, "", paramStr);
//		log.info("----------------RESPONXML"+str);
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
		str=addIomStaffLocation4MOS(paramStr);
		return str;
	}
	
	public String addIomStaffLocation4MOS(String paramStr) throws SysException, AppException {
		String result="";
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,null, null);
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
		 result =	client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_ADD_STAFF_IOM_LOCATION, "", paramStr);
		log.info("----------------RESPONXML"+result);
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
}
