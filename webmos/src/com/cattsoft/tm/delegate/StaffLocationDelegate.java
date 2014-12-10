/**
 * 
 */
package com.cattsoft.tm.delegate;

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
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
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
	
	public void addStaffLocation4MOS(String staffLocationJson) throws SysException, AppException {
		try{
			IM4MOSServicesService service = new IM4MOSServicesServiceLocator();
			IM4MOSServices_PortType client = null;
			String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SERVER_ADDR, null, null, null,null, null);
			urlStr = urlStr + "IM4MOSServices";
			URL url = new URL(urlStr);
			client = service.getIM4MOSServices(url);
			log.debug("client: " + client);
			client.svcCallIOMByMosNative(SysConstants.SYS_CONFIG_ADD_STAFF_LOCATION, "", staffLocationJson);
		
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
