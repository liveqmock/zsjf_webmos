package com.cattsoft.tm.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.xmlbeans.XmlException;

import com.alibaba.fastjson.JSONArray;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.DeviceCoordinateDelegate;
import com.cattsoft.tm.delegate.ResourceQueryDelegate;
import com.cattsoft.tm.delegate.TerminalHandleDelegate;
import com.cattsoft.tm.vo.ScanTermailSVO;
import com.cattsoft.webpub.util.ReqUtil;
import com.cattsoft.xml4mos.xmlbeans.ChangeTerminalRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.ChangeTerminalResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.DEVICEINFOREQDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceCheckRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceCheckResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceQueryRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceQueryResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceStaffRelation;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryRequest;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationResponseDocument;
import com.cattsoft.xml4mos.xmlbeans.RESINFOREQDocument;
import com.cattsoft.xml4mos.xmlbeans.RESINFORSP;
import com.cattsoft.xml4mos.xmlbeans.RESINFORSPDocument;
import com.cattsoft.xml4mos.xmlbeans.DictionaryQueryRequest.DictionaryParameters.DictionaryParameter;
import com.cattsoft.xml4mos.xmlbeans.RESINFORSP.CUSTOMERINFO;
import com.cattsoft.xml4mos.xmlbeans.RESINFORSP.NBRINFO;
import com.cattsoft.xml4mos.xmlbeans.RESINFORSP.RESINFO;

/**
 * 终端处理Action 终端领用 、终端变更、、、
 * 
 * @author fushuang 2013-09-13
 */
public class TerminalHandleAction extends DispatchAction {
	
//	public static void main(String[] args) throws SysException, AppException,
//			XmlException {
//		int flag = 1;
//		String result;
//		switch (flag) {
//		case 1:// 业务查询终端信息
//			RESINFOREQDocument doc1 = RESINFOREQDocument.Factory.newInstance();
//			doc1.addNewRESINFOREQ();
//			doc1.getRESINFOREQ().setACCNBR("7370651");
//			doc1.getRESINFOREQ().setAREACODE("470");
//			result = ResourceQueryDelegate.getDelegate().resQuery(
//					doc1.toString());
//			RESINFORSPDocument resultDoc1 = RESINFORSPDocument.Factory
//					.parse(result);
//			log.debug("传入参数为：\n" + doc1.toString());
//			log.debug("RMS返回结果为：\n" + resultDoc1.toString());
//			break;
//		case 2:// 终端变更
//			ChangeTerminalRequestDocument doc2 = ChangeTerminalRequestDocument.Factory
//					.newInstance();
//			doc2.addNewChangeTerminalRequest();
//			doc2.getChangeTerminalRequest().setAccNbr("7370651");
//			doc2.getChangeTerminalRequest().setSoNbr("1");
//			doc2.getChangeTerminalRequest().setWoNbr("1");
//			doc2.getChangeTerminalRequest().setStepId("1");
//			doc2.getChangeTerminalRequest().setFactoryId("940");
//			doc2.getChangeTerminalRequest().setModel("zjl-test");
//			doc2.getChangeTerminalRequest().setDeviceProtocol("1");
//			doc2.getChangeTerminalRequest().setLocalNetId("470");
//			doc2.getChangeTerminalRequest().setServiceAreaId("47001");
//			doc2.getChangeTerminalRequest().setMacAddress("eeff12");
//			doc2.getChangeTerminalRequest().setSeriesCode("");
//			result = TerminalHandleDelegate.getDelegate().callRmsService(
//					doc2.toString(), SysConstants.FUNCODE_TERMINAL_CHANGE);
//			ChangeTerminalResponseDocument resultDoc2 = ChangeTerminalResponseDocument.Factory
//					.parse(result);
//			log.debug("传入参数为：\n" + doc2.toString());
//			log.debug("RMS返回结果为：\n" + resultDoc2.toString());
//			break;
//		case 3:// 维护设备人员关系
//			MaintainDeviceStaffRelationRequestDocument doc3 = MaintainDeviceStaffRelationRequestDocument.Factory
//					.newInstance();
//			doc3.addNewMaintainDeviceStaffRelationRequest();
//			doc3.getMaintainDeviceStaffRelationRequest()
//					.addNewDeviceStaffRelations();
//			for (int i = 1; i <= 2; i++) {
//				DeviceStaffRelation dsr = doc3
//						.getMaintainDeviceStaffRelationRequest()
//						.getDeviceStaffRelations().addNewDeviceStaffRelation();
//				dsr.setLocalNetId("472");
//				dsr.setServiceAreaId("47201");
//				dsr.setMacAddress("SN-999999");
//				dsr.setStaffId("1");
//			}
//			result = TerminalHandleDelegate.getDelegate().callRmsService(
//					doc3.toString(),
//					SysConstants.FUNCODE_MAINTAIN_DEVICE_STAFF_RELATION);
//			MaintainDeviceStaffRelationResponseDocument resultDoc3 = MaintainDeviceStaffRelationResponseDocument.Factory
//					.parse(result);
//			log.debug("传入参数为：\n" + doc3.toString());
//			log.debug("RMS返回结果为：\n" + resultDoc3.toString());
//			break;
//		case 4:// 解除设备人员关系
//			MaintainDeviceStaffRelationRequestDocument doc4 = MaintainDeviceStaffRelationRequestDocument.Factory
//					.newInstance();
//			doc4.addNewMaintainDeviceStaffRelationRequest();
//			doc4.getMaintainDeviceStaffRelationRequest()
//					.addNewDeviceStaffRelations();
//			for (int i = 1; i <= 1; i++) {
//				DeviceStaffRelation dsr = doc4
//						.getMaintainDeviceStaffRelationRequest()
//						.getDeviceStaffRelations().addNewDeviceStaffRelation();
//				dsr.setLocalNetId("472");
//				dsr.setServiceAreaId("47201");
//				dsr.setMacAddress("SN-999999");
//				dsr.setStaffId("1");
//			}
//			result = TerminalHandleDelegate.getDelegate().callRmsService(
//					doc4.toString(),
//					SysConstants.FUNCODE_RELEASE_DEVICE_STAFF_RELATION);
//			MaintainDeviceStaffRelationResponseDocument resultDoc4 = MaintainDeviceStaffRelationResponseDocument.Factory
//					.parse(result);
//			log.debug("传入参数为：\n" + doc4.toString());
//			log.debug("RMS返回结果为：\n" + resultDoc4.toString());
//			break;
//		case 5:// 查询终端设备列表 staffId
//			DeviceQueryByStaffRequestDocument doc5 = DeviceQueryByStaffRequestDocument.Factory
//					.newInstance();
//			doc5.addNewDeviceQueryByStaffRequest();
//			doc5.getDeviceQueryByStaffRequest().setStaffId("1");
//			result = TerminalHandleDelegate.getDelegate().callRmsService(
//					doc5.toString(), SysConstants.FUNCODE_QUERY_TERMAIL);
//			DeviceQueryByStaffResponseDocument resultDoc5 = DeviceQueryByStaffResponseDocument.Factory
//					.parse(result);
//			log.debug("传入参数为：\n" + doc5.toString());
//			log.debug("RMS返回结果为：\n" + resultDoc5.toString());
//			break;
//		case 6:// 设备查询—根据MAC查
//			DeviceQueryRequestDocument doc6 = DeviceQueryRequestDocument.Factory
//					.newInstance();
//			doc6.addNewDeviceQueryRequest();
//			doc6.getDeviceQueryRequest().setMacAddress("SN-22222");
//			doc6.getDeviceQueryRequest().setStaffId("");
//			result = TerminalHandleDelegate.getDelegate().callRmsService(
//					doc6.toString(), SysConstants.FUNCODE_TERMAIL_DETAIL);
//			DeviceQueryResponseDocument resultDoc6 = DeviceQueryResponseDocument.Factory
//					.parse(result);
//			log.debug("传入参数为：\n" + doc6.toString());
//			log.debug("RMS返回结果为：\n" + resultDoc6.toString());
//			break;
//		case 7:// 资源查询—根据服务区
//			DeviceCheckRequestDocument doc7 = DeviceCheckRequestDocument.Factory
//					.newInstance();
//			doc7.addNewDeviceCheckRequest();
//			doc7.getDeviceCheckRequest().setServiceAreaId("47101");
//			doc7.getDeviceCheckRequest().setResourceType("30003");
//			doc7.getDeviceCheckRequest().addNewPagInfo().setPageNo("5");
//			doc7.getDeviceCheckRequest().getPagInfo().setPageSize("5");
//			result = TerminalHandleDelegate.getDelegate().callRmsService(
//					doc7.toString(),
//					SysConstants.FUNCODE_QUERY_FUNC_DEVICE_BY_ACC_NBR);
//			DeviceCheckResponseDocument resultDoc7 = DeviceCheckResponseDocument.Factory
//					.parse(result);
//			log.debug("传入参数为：\n" + doc7.toString());
//			log.debug("RMS返回结果为：\n" + resultDoc7.toString());
//			break;
//		case 8:// 修改资源状态
//			break;
//		case 9:// 资源查询
//			DEVICEINFOREQDocument doc9 = DEVICEINFOREQDocument.Factory
//					.newInstance();
//			doc9.addNewDEVICEINFOREQ().setDEVICENAME("");
//			doc9.getDEVICEINFOREQ().setDEVICETYPE("");
//		}
//	}

	/**
	 * 终端变更初始化 查询终端信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initChangeTerminal4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result;
		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject
				.parseObject(jsonstr);
		String accNbr = json.getString("accNbr");
		String localNetId = json.getString("localNetId");
//		localNetId = "470";
		RESINFOREQDocument doc1 = RESINFOREQDocument.Factory.newInstance();
		doc1.addNewRESINFOREQ();
		doc1.getRESINFOREQ().setACCNBR(accNbr);
		doc1.getRESINFOREQ().setAREACODE(localNetId);
		result = ResourceQueryDelegate.getDelegate().resQuery(doc1.toString());
//		RESINFORSPDocument resultDoc1 = RESINFORSPDocument.Factory
//		.parse(result);
		// 把xml转换成json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("返回xml转换为json=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}
	
	public static void main(String args[]) {
		new TerminalHandleAction().getResString();
	}
	
	public String getResString() {
		com.cattsoft.xml4mos.xmlbeans.RESINFORSPDocument doc=com.cattsoft.xml4mos.xmlbeans.RESINFORSPDocument.Factory.newInstance();
		RESINFORSP rsp=doc.addNewRESINFORSP();
		CUSTOMERINFO custom=rsp.addNewCUSTOMERINFO();
		custom.setCUSTNAME("uuuuu");
		custom.setCUSTTYPE("M");
		NBRINFO nbrinfo=rsp.addNewNBRINFO();
		RESINFO resInfo=rsp.addNewRESINFO();
		System.out.println(doc.toString());
		String res=doc.toString();
		String json= com.cattsoft.pub.util.StringUtil.xml2JSON(res);
		System.out.println(json);
		return doc.toString();
		
	}

	/**
	 * 终端变更
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward changeTerminal4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject
				.parseObject(jsonstr);
		String accNbr = json.getString("accNbr");
		String localnetId = json.getString("localNetId");
		String areaId = json.getString("areaId");
		String soNbr="";
		String woNbr="";
		String stepId="";
		String macAddress="";
		String seriesCode="";
		if(json.containsKey("soNbr")){
			soNbr = json.getString("soNbr");
		}
		if(json.containsKey("woNbr")){
			woNbr = json.getString("woNbr");
		}
		
		if(json.containsKey("stepId")){
			stepId = json.getString("stepId");
		}
		
		if(json.containsKey("macAddress")){
			macAddress = json.getString("macAddress");
		}
		
		if(json.containsKey("seriesCode")){
			seriesCode = json.getString("seriesCode");
		}
		
		String factoryId = json.getString("factoryId");
		String model = json.getString("model");
		String deviceProtocol = json.getString("deviceProtocol");
		ChangeTerminalRequestDocument doc2 = ChangeTerminalRequestDocument.Factory
				.newInstance();
		doc2.addNewChangeTerminalRequest();
		doc2.getChangeTerminalRequest().setAccNbr(accNbr);
		doc2.getChangeTerminalRequest().setFactoryId(factoryId);
		doc2.getChangeTerminalRequest().setModel(model);
		doc2.getChangeTerminalRequest().setDeviceProtocol(deviceProtocol);
		doc2.getChangeTerminalRequest().setLocalNetId(localnetId);
		doc2.getChangeTerminalRequest().setServiceAreaId(areaId);
		if (!StringUtil.isBlank(soNbr)) {
			doc2.getChangeTerminalRequest().setSoNbr(soNbr);
		}

		if (!StringUtil.isBlank(woNbr)) {
			doc2.getChangeTerminalRequest().setWoNbr(woNbr);
		}

		if (!StringUtil.isBlank(stepId)) {
			doc2.getChangeTerminalRequest().setStepId(stepId);
		}

		if (!StringUtil.isBlank(macAddress)) {
			doc2.getChangeTerminalRequest().setMacAddress(macAddress);
		}

		if (!StringUtil.isBlank(seriesCode)) {
			doc2.getChangeTerminalRequest().setSeriesCode(seriesCode);
		}

		String result = TerminalHandleDelegate.getDelegate().callRmsService(
				doc2.toString(), SysConstants.FUNCODE_TERMINAL_CHANGE);
		ChangeTerminalResponseDocument resultDoc2 = ChangeTerminalResponseDocument.Factory
				.parse(result);
		// 把xml转换成json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("返回xml转换为json=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}

	/**
	 * 根据员工ID查询终端设备列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryDevicesByStaff4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject
				.parseObject(jsonstr);
		String staffId = json.getString("staffId");
		DeviceQueryByStaffRequestDocument doc5 = DeviceQueryByStaffRequestDocument.Factory
				.newInstance();
		doc5.addNewDeviceQueryByStaffRequest();
		doc5.getDeviceQueryByStaffRequest().setStaffId(staffId);
		String result = TerminalHandleDelegate.getDelegate().callRmsService(
				doc5.toString(), SysConstants.FUNCODE_QUERY_TERMAIL);
		DeviceQueryByStaffResponseDocument resultDoc5 = DeviceQueryByStaffResponseDocument.Factory
				.parse(result);
		// 把xml转换成json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("返回xml转换为json=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}

	/**
	 * 根据员工ID 终端mac地址 查询终端详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryDeviceByMacAddress4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject
				.parseObject(jsonstr);
		String staffId = json.getString("staffId");
		String macAddr = json.getString("macAddr");
		DeviceQueryRequestDocument doc6 = DeviceQueryRequestDocument.Factory
				.newInstance();
		doc6.addNewDeviceQueryRequest();
		doc6.getDeviceQueryRequest().setMacAddress(macAddr);
		doc6.getDeviceQueryRequest().setStaffId(staffId);
		String result = TerminalHandleDelegate.getDelegate().callRmsService(
				doc6.toString(), SysConstants.FUNCODE_TERMAIL_DETAIL);
		DeviceQueryResponseDocument resultDoc6 = DeviceQueryResponseDocument.Factory
				.parse(result);
		// 把xml转换成json
		String jsonResult = com.cattsoft.pub.util.StringUtil.xml2JSON(result);
		log.debug("返回xml转换为json=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}

	/**
	 * 终端领用
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward maintainDeviceStaffRelation4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject
				.parseObject(jsonstr);
		List<ScanTermailSVO> relList = com.alibaba.fastjson.JSON.parseArray((String) json.get("staffDevList"), ScanTermailSVO.class);
	//	JSONArray relList = json.getJSONArray("staffDevList");
		if (!relList.isEmpty() && relList.size() > 0) {
			MaintainDeviceStaffRelationRequestDocument doc3 = MaintainDeviceStaffRelationRequestDocument.Factory
					.newInstance();
			doc3.addNewMaintainDeviceStaffRelationRequest();
			doc3.getMaintainDeviceStaffRelationRequest()
					.addNewDeviceStaffRelations();
			for (int i = 0; i < relList.size(); i++) {
				//JSONObject jsonObj = (JSONObject) relList.get(i);
				DeviceStaffRelation dsr = doc3
						.getMaintainDeviceStaffRelationRequest()
						.getDeviceStaffRelations().addNewDeviceStaffRelation();
				dsr.setLocalNetId(relList.get(i).getLocalNetId());
				dsr.setServiceAreaId(relList.get(i).getAreaId());
				dsr.setMacAddress(relList.get(i).getMacAddress());
				dsr.setStaffId(relList.get(i).getStaffId());
			}
			String result = TerminalHandleDelegate
					.getDelegate()
					.callRmsService(doc3.toString(),
							SysConstants.FUNCODE_MAINTAIN_DEVICE_STAFF_RELATION);
			MaintainDeviceStaffRelationResponseDocument resultDoc3 = MaintainDeviceStaffRelationResponseDocument.Factory
					.parse(result);
			// 把xml转换成json
			String jsonResult = com.cattsoft.pub.util.StringUtil
					.xml2JSON(result);
			log.debug("返回xml转换为json=" + jsonResult);
			ReqUtil.write(response, jsonResult);
		}

		return null;
	}
	
	/**
	 * 解绑员工终端信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward releaseDeviceStaffRelation4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject
				.parseObject(jsonstr);
		//JSONArray relList = json.getJSONArray("staffDevList");
		List<ScanTermailSVO> relList = com.alibaba.fastjson.JSON.parseArray((String) json.get("staffDevList"), ScanTermailSVO.class);
		if (!relList.isEmpty() && relList.size() > 0) {
			MaintainDeviceStaffRelationRequestDocument doc3 = MaintainDeviceStaffRelationRequestDocument.Factory
					.newInstance();
			doc3.addNewMaintainDeviceStaffRelationRequest();
			doc3.getMaintainDeviceStaffRelationRequest()
					.addNewDeviceStaffRelations();
			for (int i = 0; i < relList.size(); i++) {
				//JSONObject jsonObj = (JSONObject) relList.get(i);
				DeviceStaffRelation dsr = doc3
						.getMaintainDeviceStaffRelationRequest()
						.getDeviceStaffRelations().addNewDeviceStaffRelation();
				dsr.setLocalNetId(relList.get(i).getLocalNetId());
				dsr.setServiceAreaId(relList.get(i).getAreaId());
				dsr.setMacAddress(relList.get(i).getMacAddress());
				dsr.setStaffId(relList.get(i).getStaffId());
			}
			String result = TerminalHandleDelegate
					.getDelegate()
					.callRmsService(doc3.toString(),
							SysConstants.FUNCODE_RELEASE_DEVICE_STAFF_RELATION);
			MaintainDeviceStaffRelationResponseDocument resultDoc3 = MaintainDeviceStaffRelationResponseDocument.Factory
					.parse(result);
			// 把xml转换成json
			String jsonResult = com.cattsoft.pub.util.StringUtil
					.xml2JSON(result);
			log.debug("返回xml转换为json=" + jsonResult);
			ReqUtil.write(response, jsonResult);
		}

		return null;
	}
	
	/**
	 * 字典表查询
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryDictionay4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonstr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject
				.parseObject(jsonstr);
		String dicType = json.getString("dicType");
		
		DictionaryQueryRequestDocument doc7 = DictionaryQueryRequestDocument.Factory.newInstance();
		DictionaryQueryRequest reqDoc7 = doc7.addNewDictionaryQueryRequest();
		reqDoc7.setDictionaryType(dicType);
		reqDoc7.addNewDictionaryParameters();
		if(SysConstants.FACTORY.equals(dicType)){//如果查询厂商
			
		}else if(SysConstants.DEVICE_MODE.equals(dicType)){
			DictionaryParameter parm = reqDoc7.getDictionaryParameters().addNewDictionaryParameter();
			parm.setParameterID("factoryId");
			parm.setParameterValue(json.getString("factoryId"));
		}else if(SysConstants.DEVICE_TREATY.equals(dicType)){
//			DictionaryParameter parm = reqDoc7.getDictionaryParameters().addNewDictionaryParameter();
//			parm.setParameterID("factoryId");
//			parm.setParameterValue(json.getString("factoryId"));
//			DictionaryParameter parm1 = reqDoc7.getDictionaryParameters().addNewDictionaryParameter();
//			parm1.setParameterID("subType");//factoryId subType
//			parm1.setParameterValue(json.getString("subType"));//940 6002
		}
		
		String result = DeviceCoordinateDelegate.getDelegate().callRmsService(
				doc7.toString(),
				SysConstants.FUNCODE_QUERY_DICTIONARY_BY_PARAMETER);
		DictionaryQueryResponseDocument resultDoc7 = DictionaryQueryResponseDocument.Factory.parse(result);
		// 把xml转换成json
		String jsonResult = com.cattsoft.pub.util.StringUtil
				.xml2JSON(result);
		log.debug("返回xml转换为json=" + jsonResult);
		ReqUtil.write(response, jsonResult);
		return null;
	}

}
