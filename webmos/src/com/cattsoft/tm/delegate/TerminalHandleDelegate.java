package com.cattsoft.tm.delegate;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.cattsoft.im.service.webservice.client.IMos2Rms;
import com.cattsoft.im.service.webservice.client.IMos2RmsService;
import com.cattsoft.im.service.webservice.client.IMos2RmsServiceLocator;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;

/**
 * 终端处理
 * @author fushuang
 *
 */
public class TerminalHandleDelegate {
	
	private static final Logger log = Logger.getLogger(TerminalHandleDelegate.class);
	
	private static TerminalHandleDelegate delegate = null;
	
	private TerminalHandleDelegate(){
		
	}
	
	public static TerminalHandleDelegate getDelegate() {
		if(delegate == null){
			delegate = new TerminalHandleDelegate();
		}
		return delegate;
	}
	
	/**
	 * 调用资源服务
	 * @param jsonStr
	 * @param funcCode
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String callRmsService(String jsonStr,String funcCode) throws SysException, AppException  {
		log.debug("传入请求参数为：" + jsonStr);
		IMos2RmsService service = new IMos2RmsServiceLocator();
		IMos2Rms client=null;
		String res=null;
		String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.MOS_SERVICE_ADDR_FOR_RMS, null, null, null, null, null);
//		String urlStr = "http://10.22.1.15:8080/trms/services/Mos2RmsService";
//		String urlStr = "http://10.21.1.29:8080/trms/services/Mos2RmsService";
//		String urlStr = "http://10.21.1.29:8080/trms/services/RmsForMosService";
//		String urlStr = "http://192.168.100.233:1991/trms/services/Mos2RmsService";
		urlStr = "http://192.168.100.39:9009/trms/services/Mos2RmsService";
		log.debug("请求webservice地址为：" + urlStr);
		URL url;
		String result = null;
		try {
			url = new URL(urlStr);
			client = service.getIMos2RmsPort(url);
			result = client.mos2Rms(funcCode, "", jsonStr);
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			throw new AppException("", "调用远程webservice方法失败！" );
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new AppException("", "调用远程webservice方法失败！" );
			
		}
		log.debug("RMS返回结果为：\n" + result);
		if(StringUtil.isExcetionInfo(result)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(result)); 
		}
		return result;
	}
	

}
