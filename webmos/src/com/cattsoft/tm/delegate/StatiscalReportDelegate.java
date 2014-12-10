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
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;


public class StatiscalReportDelegate {
	private static final Logger log = Logger.getLogger(StatiscalReportDelegate.class);
	private static StatiscalReportDelegate delegate = new StatiscalReportDelegate();
	public static StatiscalReportDelegate getDelegate() {
		return delegate;
	}
	
	
	
//	统计报表4MOS
	public String queryReport4MOS(String jsonStr) throws AppException, SysException {
	
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
			String resultstr = client.svcCallIOMByMosNative(SysConstants.FUNCODE_STATIS_REPORT, "", jsonStr);
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
	
	
//	查询报表列表4MOS
	public String queryReportList4MOS(String jsonStr) throws AppException, SysException {
	
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
//			String urlStr = SysConfigData.getSysConfigCurValue(
//					SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,
//					null, null);
//	//		String urlStr = "http://127.0.0.1:7001/web/services/";
			
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
			String resultstr = client.svcCallIOMByMosNative(SysConstants.FUNCODE_QUERY_REPORT_LIST, "", jsonStr);
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
