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
 * 资源核查
 * @author xieyunchao
 *
 */
public class DeviceCoordinateDelegate {
	
	private static final Logger log = Logger.getLogger(DeviceCoordinateDelegate.class);

	private static DeviceCoordinateDelegate delegate = new DeviceCoordinateDelegate();

	public static DeviceCoordinateDelegate getDelegate() {
		return delegate;
	}

	/**
	 * 无参构造函数
	 */
	public DeviceCoordinateDelegate() {
	}
	
	
	/**
	 * 调用资源webservice服务
	 * @param jsonStr
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	public String callRmsService(String jsonStr,String funcCode) throws SysException, AppException  {
		log.debug("传入请求参数为：" + jsonStr);
		IMos2RmsService service = new IMos2RmsServiceLocator();
		IMos2Rms client=null;
		String res=null;
		String urlStr = SysConfigData.getSysConfigCurValue(SysConstants.MOS_SERVICE_ADDR_FOR_RMS_TEMP, null, null, null, null, null);
//		String urlStr = "http://10.22.1.15:8080/trms/services/Mos2RmsService";
//		String urlStr = "http://10.21.1.29:8080/trms/services/Mos2RmsService";
//		String urlStr = "http://192.168.100.233:1991/trms/services/Mos2RmsService";
//		urlStr = "http://10.22.1.41:8080/trms/services/Mos2RmsService";
		log.debug("请求webservice地址为：" + urlStr);
		URL url;
		String responseFromRms = null;
		try {
			url = new URL(urlStr);
			client = service.getIMos2RmsPort(url);
			responseFromRms = client.mos2Rms(funcCode, "", jsonStr);
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
		log.debug("res: " + res);
		if(StringUtil.isExcetionInfo(responseFromRms)){
			throw new AppException("", "调用远程webservice方法失败！" + StringUtil.getExcetionInfo(responseFromRms)); 
		}
		return responseFromRms;
	}
	
	/**
	 * 调用资源webservice服务
	 * @param jsonStr
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
//	public String showDeviceList4MOS(String jsonStr,String funcCode) throws SysException, AppException  {
//		com.cattsoft.xml4mos.xmlbeans.DeviceCheckResponseDocument doc=com.cattsoft.xml4mos.xmlbeans.DeviceCheckResponseDocument.Factory.newInstance();
//		DeviceCheckResponse deviceCheck=doc.addNewDeviceCheckResponse();
//		deviceCheck.setLocalNetId("1111");
//		deviceCheck.setServiceAreaId("12222");
//		deviceCheck.setResultKey("0");
//		deviceCheck.setResultValue("成功");
//		
//		DeviceCheckInfos checkInfos=deviceCheck.addNewDeviceCheckInfos();
//		DeviceCheckInfo info1=checkInfos.addNewDeviceCheckInfo();
//		info1.setDeviceId("1111");
//		info1.setDeviceName("吉林市长效路汪霖小区231098-A交接箱");
//		info1.setDeviceInstallAddress("吉林市长效路汪霖小区32号楼东侧基站旁边");
//		info1.setDeviceFactoryId("111");
//		info1.setDeviceFactoryName("华为");
//		info1.setDeviceModel("CB-201");
//		info1.setLatitude("116.282962");
//		info1.setLongitude("39.987946");
//		
//		DeviceCheckInfo info2=checkInfos.addNewDeviceCheckInfo();
//		info2.setDeviceId("1111");
//		info2.setDeviceName("吉林市长效路汪霖小区231098-A交接箱");
//		info2.setDeviceInstallAddress("吉林市长效路汪霖小区32号楼东侧基站旁边");
//		info2.setDeviceFactoryId("111");
//		info2.setDeviceFactoryName("华为");
//		info2.setDeviceModel("CB-201");
//		info2.setLatitude("");
//		info2.setLongitude("");
//		
//		
//		DeviceCheckInfo info3=checkInfos.addNewDeviceCheckInfo();
//		info3.setDeviceId("1111");
//		info3.setDeviceName("吉林市长效路汪霖小区231098-A交接箱");
//		info3.setDeviceInstallAddress("吉林市长效路汪霖小区32号楼东侧基站旁边");
//		info3.setDeviceFactoryId("111");
//		info3.setDeviceFactoryName("华为");
//		info3.setDeviceModel("CB-201");
//		info3.setLatitude("");
//		info3.setLongitude("");
//		
//		DeviceCheckInfo info4=checkInfos.addNewDeviceCheckInfo();
//		info4.setDeviceId("1111");
//		info4.setDeviceName("吉林市长效路汪霖小区231098-A交接箱");
//		info4.setDeviceInstallAddress("吉林市长效路汪霖小区32号楼东侧基站旁边");
//		info4.setDeviceFactoryId("111");
//		info4.setDeviceFactoryName("华为");
//		info4.setDeviceModel("CB-201");
//		info4.setLatitude("116.282962");
//		info4.setLongitude("39.987946");
//		
//		System.out.println("doc==========="+doc.toString());
//		return doc.toString();
		
//	}

}
