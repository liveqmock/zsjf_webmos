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
 * Description:工单查询Delegate <br>
 * Date: 2007-6-21 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class WoQueryDelegate {
	private static Logger log = Logger.getLogger(WoQueryDelegate.class);

	private static WoQueryDelegate delegate = null;

	private WoQueryDelegate() {

	}

	public static WoQueryDelegate getDelegate() {
		if (delegate == null) {
			delegate = new WoQueryDelegate();
		}
		return delegate;
	}

	
	/**
	 * 查询工单列表
	 * @throws SysException 
	 * @throws AppException 
	 */
	public String getWoListBySoNbr4MOS(String advQueryVo) throws AppException, SysException{
		IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
		IM4MOSServices_PortType client = null;
		//String urlStr = "http:127.0.0.1:7001/web/services/";
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
            workAreaList= client.svcCallIOMByMosNative(SysConstants.FUNCODE_WO_LIST, null, advQueryVo);
		} catch (RemoteException e) {
		//	 TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServiceException e) {
		//	 TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("client: " + client);
		return workAreaList;
	}
	

}
