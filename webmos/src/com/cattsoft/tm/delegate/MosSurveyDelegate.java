/**
 * 
 */
package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.xml.rpc.ServiceException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.IM4MOSServicesService;
import com.cattsoft.im.service.webservice.client.IM4MOSServicesServiceLocator;
import com.cattsoft.im.service.webservice.client.IM4MOSServices_PortType;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.pub.util.SysInit;
import com.cattsoft.sp.vo.SoAttachMVO;


/**
 * @author chenxiaofei
 * CreateTime 2012-10-19 上午10:00:34
 */
public class MosSurveyDelegate {
	private static final Logger log = Logger.getLogger(MosSurveyDelegate.class);

	private static MosSurveyDelegate delegate = null;

	public static MosSurveyDelegate getDelegate() {
		if (delegate != null) {

		} else {
			delegate = new MosSurveyDelegate();
		}
		return delegate;
	}
	
	
	
	public String addMosSurvey(String mosSurveyJson) throws SysException, AppException {
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
			
			String mosSurvey = client.svcCallIOMByMosNative(SysConstants.FUNCODE_ADD_MOS_SURVEY, "", mosSurveyJson);
			return mosSurvey;
		
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
	
	public String queryMOSSurvey4MOS(String mosSurveyJson) throws SysException, AppException {
		String mosSurvey =null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			//String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
//			String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			 mosSurvey = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_QUERY_MOS_SURVEY, "", mosSurveyJson);
			
			
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
		return mosSurvey;
	}
	public String addMOSPicture4MOS(String mosSurveyJson) throws SysException, AppException {
		String result=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			//String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,null, null);
			
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
			
//			String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			 result = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_ADD_MOS_PICTURE, "", mosSurveyJson);
			
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
	public String queryMOSPicture4MOS(String mosSurveyJson) throws SysException, AppException {
		String mosSurvey=null;
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			//String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			
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
			
			
//			String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			
			 mosSurvey = client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_QUERY_MOS_PICTURE, "", mosSurveyJson);
			
			//JSONObject requestjson=JSONObject.fromObject(mosSurvey);
			// surveyList=(List)requestjson.get("mosPictrueList");
			
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
		return mosSurvey;
	}
	
	public void deleteMOSPicture4MOS(String mosSurveyJson) throws SysException, AppException {
		
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			//String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR, null, null, null,null, null);
			
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
			
//			String urlStr = SysConstants.SYS_CONFIG_MOS_LOCAL_SERVER_ADDR;
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_DELETE_MOS_PICTURE, "", mosSurveyJson);
			
		
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
	}

	
}
