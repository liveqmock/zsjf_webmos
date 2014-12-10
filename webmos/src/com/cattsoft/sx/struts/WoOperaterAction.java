package com.cattsoft.sx.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.xmlbeans.XmlException;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.config.SysConfig;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sx.delegate.WoOperaterDelegate;
import com.cattsoft.xml4mos.xmlbeans.FailReasonResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.ResourceQueryResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.ResoursQueryResponseInfoPkg;
import com.cattsoft.xml4mos.xmlbeans.SystemStatusResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.WoListInitResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.FailReasonResponseDocument.FailReasonResponse;
import com.cattsoft.xml4mos.xmlbeans.ResourceQueryResponseDocument.ResourceQueryResponse;
import com.cattsoft.xml4mos.xmlbeans.ResourceQueryResponseDocument.ResourceQueryResponse.ResourceQueryResponseInfos;
import com.cattsoft.xml4mos.xmlbeans.ResoursQueryResponseInfoPkg.ResPrptyInfo;
import com.cattsoft.xml4mos.xmlbeans.WoListInitResponseDocument.WoListInitResponse;
import com.cattsoft.xml4mos.xmlbeans.WoListInitResponseDocument.WoListInitResponse.WoListInit;


public class WoOperaterAction extends DispatchAction{
	
	private static Logger log = Logger.getLogger(WoOperaterAction.class);
	
	public WoOperaterAction(){
		
		
	}
	
	/**
	 * 回单工单列表初始化
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 * @throws XmlException 
	 */
	public ActionForward initWoList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, XmlException {
		log.debug("初始化工单列表 ");
		
		String requestxml=getXML(request);
		String responsexml=WoOperaterDelegate.getDelegate().initWoList(requestxml);
		
		//注销掉的测试用 
		//解析Xml
		/*try {
			WoOperateResponseDocument REEE = WoOperateResponseDocument.Factory.parse(requestxml);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	//	WoListInitRequestDocument requestxml=null;
		WoListInitResponseDocument woListInitRepDoc = WoListInitResponseDocument.Factory.parse(responsexml);
		WoListInitResponse loginRep = woListInitRepDoc.getWoListInitResponse();
		WoListInit woListInit = loginRep.getWoListInit();
        if(woListInit!=null){
        	byte[] xmlBytes = responsexml.toString().getBytes("utf-8");
			response.setContentLength(xmlBytes.length);
			response.getOutputStream().write(xmlBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
        }
			
		//}
		return null;
	
	}
	/**
	 * 初始化资源信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 * @throws XmlException 
	 */
	public ActionForward initWoResInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, XmlException {
		log.debug("初始化资源信息");
		String responsexml=null;
		String requestxml=getXML(request);
		responsexml=WoOperaterDelegate.getDelegate().initWoResInfo(requestxml);
		
//		ResourceQueryResponseDocument resQueryRepDoc = ResourceQueryResponseDocument.Factory.newInstance();
//		ResourceQueryResponse resQueryRep = resQueryRepDoc.addNewResourceQueryResponse();
//		ResourceQueryResponseInfos resQueryRepInfo =  resQueryRep.addNewResourceQueryResponseInfos();
//		ResoursQueryResponseInfoPkg resRepInfoPkg1 = resQueryRepInfo.addNewResourceResponseInfoPkg();
//		ResPrptyInfo resPrptyInfo1 = resRepInfoPkg1.addNewResPrptyInfo();
//		resPrptyInfo1.setNoFlag("A");
//		resPrptyInfo1.setResPrptyId("2000000");
//		resPrptyInfo1.setResPrptyName("交换机名称");
//		resPrptyInfo1.setResPrptyValue("ADT9001");
//		
//		ResoursQueryResponseInfoPkg resRepInfoPkg2 = resQueryRepInfo.addNewResourceResponseInfoPkg();
//		ResPrptyInfo resPrptyInfo2 = resRepInfoPkg2.addNewResPrptyInfo();
//		resPrptyInfo2.setNoFlag("A");
//		resPrptyInfo2.setResPrptyId("2000001");
//		resPrptyInfo2.setResPrptyName("交换机端口");
//		resPrptyInfo2.setResPrptyValue("ADT9001");
//		
//		ResoursQueryResponseInfoPkg resRepInfoPkg3 = resQueryRepInfo.addNewResourceResponseInfoPkg();
//		ResPrptyInfo resPrptyInfo3 = resRepInfoPkg3.addNewResPrptyInfo();
//		resPrptyInfo3.setNoFlag("A");
//		resPrptyInfo3.setResPrptyId("3000088");
//		resPrptyInfo3.setResPrptyName("OLT端口编码");
//		resPrptyInfo3.setResPrptyValue("ADT9001");
//		
//		ResoursQueryResponseInfoPkg resRepInfoPkg4 = resQueryRepInfo.addNewResourceResponseInfoPkg();
//		ResPrptyInfo resPrptyInfo4 = resRepInfoPkg4.addNewResPrptyInfo();
//		resPrptyInfo4.setNoFlag("P");
//		resPrptyInfo4.setResPrptyId("2000000");
//		resPrptyInfo4.setResPrptyName("交换机名称");
//		resPrptyInfo4.setResPrptyValue("ADT9001");
		
		
		//解析Xml
		ResourceQueryResponseDocument resourceQueryRepDoc=ResourceQueryResponseDocument.Factory.parse(responsexml.toString());
		ResourceQueryResponse resourceQueryRep = resourceQueryRepDoc.getResourceQueryResponse();
		ResourceQueryResponseInfos resourceQueryResponseInfos = resourceQueryRep.getResourceQueryResponseInfos();
		ResoursQueryResponseInfoPkg[] resourceQueryResponseInfoPkg = resourceQueryResponseInfos.getResourceResponseInfoPkgArray();
		
		List list = new ArrayList();
		
		String resPrpty = "";
		//如果初始化缓存则使用缓存地址
		if(!StringUtil.isBlank(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))
				&& SysConstants.TRUE.equals(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_INIT_CONFIG, null, null, null, null, null))){
			resPrpty = SysConfigData.getSysConfigCurValue(
					SysConstants.SYS_CONFIG_MOS_RES_PRPTY, null, null, null,
					null, null);
		}else{
			//没有初始化则使用常量
//			resPrpty = SysConstants.MOS_RES_PRPTY;
			resPrpty = SysConfig.getConfig().getProperty(
			"res_show_list");
		}
//		String resPrpty = SysConfigData.getSysConfigCurValue(
//				SysConstants.SYS_CONFIG_MOS_RES_PRPTY, null, null,
//				null, null, null);
		Pattern pattern = Pattern.compile("[^0-9]");
		String resPrptyString[] = pattern.split(resPrpty);
		
		for(int i=0;i<resourceQueryResponseInfoPkg.length;i++){
			//resourceQueryResponseInfoPkg
			ResPrptyInfo[] resPrptyInfo = resourceQueryResponseInfoPkg[i].getResPrptyInfoArray();
			for(int k=0;k<resPrptyInfo.length;k++){
				for(int j=0;j<resPrptyString.length;j++){
					if(resPrptyInfo[k].getResPrptyId().equals(resPrptyString[j])){
						Map map = new HashMap();
						map.put("noFlag", resPrptyInfo[k].getNoFlag());
						map.put("resPrptyId", resPrptyInfo[k].getResPrptyId());
						map.put("resPrptyName", resPrptyInfo[k].getResPrptyName());
						map.put("resPrptyValue", resPrptyInfo[k].getResPrptyValue());
						list.add(map);
					}
				}
			}
			
		}
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		
		if (jsonArray!=null) {
			byte[] xmlBytes = jsonArray.toString().getBytes("utf-8");
			response.setContentLength(xmlBytes.length);
			response.getOutputStream().write(xmlBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	    return null;
		
	}

	/**
	 * 系统状态查询status，暂时调用资源侧方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 */
	public ActionForward systemStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		log.debug("初始化工单列表 ");
		
		String requestxml=getXML(request);
		String responsexml=WoOperaterDelegate.getDelegate().systemStatus(requestxml);
		
		//注销掉的测试用 
		//解析Xml
		/*try {
			WoOperateResponseDocument REEE = WoOperateResponseDocument.Factory.parse(requestxml);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		SystemStatusResponseDocument systemStatusResponseDoc = null;
		try {
			systemStatusResponseDoc = SystemStatusResponseDocument.Factory.parse(responsexml);
		}catch (XmlException e) {
				throw new AppException("", "返回XML格式异常！"+responsexml);
			}
			byte[] xmlBytes = responsexml.toString().getBytes("utf-8");
			response.setContentLength(xmlBytes.length);
			response.getOutputStream().write(xmlBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		return null;
	}
	/**
	 *   @param request
	 * @return
	 * @throws IOException
	 */
	private String getXML(HttpServletRequest request) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		return sb.toString();
	}
	/**
	  *获取失败原因
	 */
	
		public ActionForward woReturnInit4MOS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AppException, SysException, IOException, XmlException {
			log.debug("获取失败原因 ");
       // 获得xml字符串
		String requestXml = getXML(request);
		if (StringUtil.isBlank(requestXml)) {
			throw new AppException("", "MOS客户端请求为空");
		}
		// 解析Xml
//		FailReasonRequestDocument loginReqDoc = FailReasonRequestDocument.Factory
//				.parse(requestXml);
//		FailReasonRequest userInfo = loginReqDoc.getFailReasonRequest();
//		String systemName = userInfo.getSystemName();
//		String reasonCat = userInfo.getReasonCat();
//		String dutyFlag = userInfo.getDutyFlag();
//		log.debug(systemName + reasonCat + dutyFlag);
		// 创建服务器xml
//		FailReasonResponseDocument loginRepDoc = FailReasonResponseDocument.Factory
//				.newInstance();
//		FailReasonResponse loginRep = loginRepDoc.addNewFailReasonResponse();
//		FailReasons woListInit = loginRep.addNewFailReasons();
//		woListInit.addName("测试头忙");
//		woListInit.addFailReasonId("1");
//		FailReasons woListInit1 = loginRep.addNewFailReasons();
//		woListInit1.addName("测试超时");
//		woListInit1.addFailReasonId("2");
//		FailReasons woListInit2 = loginRep.addNewFailReasons();
//		woListInit2.addName("找不到对应测试头");
//		woListInit2.addFailReasonId("3");
//		byte[] xmlBytes = loginRepDoc.toString().getBytes("utf-8");
//		rep.setContentLength(xmlBytes.length);
//		rep.getOutputStream().write(xmlBytes);
//		rep.getOutputStream().flush();
//		rep.getOutputStream().close();
		String responsexml=WoOperaterDelegate.getDelegate().failReasonQuery(requestXml);
		FailReasonResponseDocument loginRepDoc = null;
		try {
			loginRepDoc = FailReasonResponseDocument.Factory.parse(responsexml);
			FailReasonResponse loginRep = loginRepDoc.getFailReasonResponse();
			loginRep.setFailReasons(loginRep.getFailReasons());
		}catch (XmlException e) {
				e.printStackTrace();
		}
		byte[] xmlBytes = responsexml.toString().getBytes("utf-8");
		response.setContentLength(xmlBytes.length);
		response.getOutputStream().write(xmlBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}
	/**
	 * 退单的返回结果
	 * @throws XmlException 
	 */
		public ActionForward woReturn4MOS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AppException, SysException, IOException, XmlException {
			log.debug("退单的返回结果 "); 
		// 获得xml字符串
		String requestXml = getXML(request);
		if (StringUtil.isBlank(requestXml)) {
			throw new AppException("", "MOS客户端请求为空");
		}
		String responsexml=WoOperaterDelegate.getDelegate().woOperate(requestXml);
		// 解析Xml
//		WoOperateRequestDocument loginReqDoc = WoOperateRequestDocument.Factory.parse(requestXml);
//		WoOperate userInfo = loginReqDoc.getWoOperateRequest().getWoOperate();
//		String failReasonId = userInfo.getFailReasonId();
//		String failReasonName = userInfo.getFailReasonName();
//		log.debug(failReasonId + failReasonName);
		// 创建服务器xml
//		WoOperateResponseDocument loginRepDoc = WoOperateResponseDocument.Factory
//				.newInstance();
//		WoOperateResponse loginRep = loginRepDoc.addNewWoOperateResponse();
//		com.cattsoft.xml4mos.xmlbeans.WoOperateResponseDocument.WoOperateResponse.WoOperate loginResult = loginRep
//				.addNewWoOperate();
//		loginResult.setResultCode("0");// 0成功，1用户名错误，2密码错误，3用户名和密码错误
//		byte[] xmlBytes = loginRepDoc.toString().getBytes("utf-8");
//		response.setContentLength(xmlBytes.length);
//		response.getOutputStream().write(xmlBytes);
//		response.getOutputStream().flush();
//		response.getOutputStream().close();
//		WoOperateResponseDocument loginRepDoc = null;
//		try {
//			loginRepDoc = WoOperateResponseDocument.Factory.parse(responsexml);
//			WoOperateResponse loginRep = loginRepDoc.getWoOperateResponse();
//			loginRep.setWoOperate(loginRep.getWoOperate());
//		}catch (XmlException e) {
//				e.printStackTrace();
//			}
		byte[] xmlBytes = responsexml.toString().getBytes("utf-8");
		response.setContentLength(xmlBytes.length);
		response.getOutputStream().write(xmlBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}
	/**
	 * 回单
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @throws IOException
	 * @throws XmlException
	 */
		//开始解析并创建
		public ActionForward overTime4MOS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			log.debug("超时......");      
			//获得xml字符串
			String requestXml = getXML(request);
			if (StringUtil.isBlank(requestXml)) {
				throw new AppException("", "MOS客户端请求为空");
			}
			String responsexml=WoOperaterDelegate.getDelegate().failReasonQuery(requestXml);
			//解析Xml
//			FailReasonRequestDocument loginReqDoc=FailReasonRequestDocument.Factory.parse(requestXml);
//			FailReasonRequest userInfo = loginReqDoc.getFailReasonRequest();
//			String systemName = userInfo.getSystemName();
//			String reasonCat = userInfo.getReasonCat();
//			String dutyFlag = userInfo.getDutyFlag();
//			log.debug(systemName+reasonCat+dutyFlag);
			//创建服务器xml
//			FailReasonResponseDocument loginRepDoc = FailReasonResponseDocument.Factory.newInstance();
//			FailReasonResponse loginRep = loginRepDoc.addNewFailReasonResponse();
//			FailReasons woListInit = loginRep.addNewFailReasons();
//			woListInit.addName("aaaaaa");
//			woListInit.addFailReasonId("1");
//			FailReasons woListInit1 = loginRep.addNewFailReasons();
//			woListInit1.addName("bbbbbbb");
//			woListInit1.addFailReasonId("2");
//			FailReasons woListInit2 = loginRep.addNewFailReasons();
//			woListInit2.addName("cccccc");
//			woListInit2.addFailReasonId("3");
//			FailReasons woListInit3 = loginRep.addNewFailReasons();
//			woListInit2.addName("ddddddd");
//			woListInit2.addFailReasonId("4");
//			FailReasons woListInit4 = loginRep.addNewFailReasons();
//			woListInit2.addName("eeeeeee");
//			woListInit2.addFailReasonId("5");
			byte[] xmlBytes = responsexml.toString().getBytes("utf-8");
			response.setContentLength(xmlBytes.length);
			response.getOutputStream().write(xmlBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			return null;
		}	
		
	public ActionForward woSuccessReturn(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException,
			IOException, XmlException {
		log.debug("回单......"); 
		// 获得xml字符串
		String requestXml = getXML(request);
		if (StringUtil.isBlank(requestXml)) {
			throw new AppException("", "MOS客户端请求为空");
		}
		String responsexml=WoOperaterDelegate.getDelegate().woOperate(requestXml);
		// 解析Xml
//		WoOperateRequestDocument resourceReqDoc = WoOperateRequestDocument.Factory
//				.parse(requestXml);
//		System.out.println("requestXmlrequestXml="+requestXml);
//		WoOperate woOperate = resourceReqDoc.getWoOperateRequest()
//				.getWoOperate();
//		String woNbr = woOperate.getWoNbr();
//		System.out.println("----------------------" + woNbr);
//		String rtStaffId = woOperate.getRtStaffId();
//		System.out.println("----------------------" + rtStaffId);
//		String getOverTimeId = woOperate.getOverTimeId();
//		System.out.println("----------------------" + getOverTimeId);
//		String overTimeName = woOperate.getOverTimeName();
//		System.out.println("----------------------" + overTimeName);
//		String operateType = woOperate.getOperateType();
//		System.out.println("----------------------" + operateType);
//		String deviceName = woOperate.getResourceBackInfo().getDeviceName();
//		System.out.println("----------------------" + deviceName);
//		String deviceCapacity = woOperate.getResourceBackInfo().getDeviceCapacity();
//		System.out.println("----------------------" + deviceCapacity);
//		String MDFEPAIR = woOperate.getResourceBackInfo().getMDFEPAIR();
//		System.out.println("----------------------" + MDFEPAIR);
//		String MDFDPAIR = woOperate.getResourceBackInfo().getMDFDPAIR();
//		System.out.println("----------------------" + MDFDPAIR);
//		String MDFEIPAIR = woOperate.getResourceBackInfo().getMDFEIPAIR();
//		System.out.println("----------------------" + MDFEIPAIR);
//		String MDFEOPAIR = woOperate.getResourceBackInfo().getMDFEOPAIR();
//		System.out.println("----------------------" + MDFEOPAIR);
//		String port = woOperate.getResourceBackInfo().getPort();
//		System.out.println("----------------------" + port);
//		String phyAccNbr = woOperate.getResourceBackInfo().getPhyAccNbr();
//		System.out.println("----------------------" + phyAccNbr);
//		String remarks = (String) woOperate.getRemarks();
//		System.out.println("----------------------" + remarks);
//		WoOperateResponseDocument recourceRepDoc = WoOperateResponseDocument.Factory
//				.newInstance();
//		WoOperateResponse woOperateResponse = recourceRepDoc
//				.addNewWoOperateResponse();
//		com.cattsoft.xml4mos.xmlbeans.WoOperateResponseDocument.WoOperateResponse.WoOperate woOperat2 = woOperateResponse
//				.addNewWoOperate();
//		woOperat2.setResultCode("0");// 0成功，1用户名错误，2密码错误，3用户名和密码错误
//		woOperat2.setResultDesc("");
		byte[] xmlBytes = responsexml.toString().getBytes("utf-8");
		response.setContentLength(xmlBytes.length);
		response.getOutputStream().write(xmlBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}
	//资源查询
//	public ActionForward ziYuanResourceReturn(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		log.debug("回单......"); 
//		// 获得xml字符串
//		String requestXml = getXML(request);
//		if (StringUtil.isBlank(requestXml)) {
//			throw new AppException("", "MOS客户端请求为空");
//		}
//		//String responsexml=WoOperaterDelegate.getDelegate().woOperate(requestXml);
//		// 解析Xml
//		DEVICEINFOREQDocument deviceinfoReqDoc = DEVICEINFOREQDocument.Factory.parse(requestXml);
//		System.out.println("requestXmlrequestXml="+requestXml);
//		DEVICEINFOREQ deviceinforeq = deviceinfoReqDoc.getDEVICEINFOREQ();
//		String deviceName = deviceinforeq.getDEVICENAME();
//		System.out.println("----------------------" + deviceName);
//		String deviceType = deviceinforeq.getDEVICETYPE();
//		System.out.println("----------------------" + deviceType);
//		 
//		DEVICEINFORSPDocument deviceinfoRepDoc = DEVICEINFORSPDocument.Factory.newInstance();
//		DEVICEINFORSP deviceinfoResponse = deviceinfoRepDoc.addNewDEVICEINFORSP();
//		deviceinfoResponse.setRESPCODE("0");// 0成功，1用户名错误，2密码错误，3用户名和密码错误
//		deviceinfoResponse.setRESPDESC("des");
//		DEVICELIST  deviceList =  deviceinfoResponse.addNewDEVICELIST();
//		deviceList.setDEVICENAME("aaaaa");
//		deviceList.setDEVICETYPE("bbb");
//		PORTLIST q = deviceList.addNewPORTLIST();
//		q.setPORTNAME("ccc");
//		q.setSTATUS("ddd");
//		EXCHLIST exch = deviceList.addNewEXCHLIST();
//		exch.setEXCHCODE("eee");
//		exch.setEXCHNAME("fff");
//		CONNECTORLIST connector = deviceList.addNewCONNECTORLIST();
//		connector.setCONNECTORNAME("ggg");
//		connector.setSTATUS("hhh");
//		
//		byte[] xmlBytes = deviceinfoRepDoc.toString().getBytes("utf-8");
//		response.setContentLength(xmlBytes.length);
//		response.getOutputStream().write(xmlBytes);
//		response.getOutputStream().flush();
//		response.getOutputStream().close();
//		return null;
//	}
//	//资源查询
//	public ActionForward ziYuanResource(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		log.debug("回单......"); 
//		// 获得xml字符串
//		String requestXml = getXML(request);
//		if (StringUtil.isBlank(requestXml)) {
//			throw new AppException("", "MOS客户端请求为空");
//		}
//		//String responsexml=WoOperaterDelegate.getDelegate().woOperate(requestXml);
//		// 解析Xml
//		SystemStatusResponseDocument deviceinfoReqDoc = SystemStatusResponseDocument.Factory.newInstance();
//		System.out.println("requestXmlrequestXml="+requestXml);
//		SystemStatusResponse deviceinforeq = deviceinfoReqDoc.addNewSystemStatusResponse();
//		SystemStatus l = deviceinforeq.addNewSystemStatus();
//		l.addOrderId("232");
//		l.addStsId("egfrr");
//		l.addStsWords("efe");
//		
//		byte[] xmlBytes = deviceinfoReqDoc.toString().getBytes("utf-8");
//		response.setContentLength(xmlBytes.length);
//		response.getOutputStream().write(xmlBytes);
//		response.getOutputStream().flush();
//		response.getOutputStream().close();
//		return null;
//	}
	

}
