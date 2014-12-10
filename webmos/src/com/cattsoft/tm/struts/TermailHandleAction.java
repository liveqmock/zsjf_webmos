package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.xmlbeans.XmlException;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.ResourceQueryDelegate;
import com.cattsoft.tm.delegate.TermailHandleDelegate;
import com.cattsoft.tm.vo.ScanTermailBackSVO;
import com.cattsoft.tm.vo.ScanTermailSVO;
import com.cattsoft.webpub.util.ReqUtil;
import com.cattsoft.xml4mos.xmlbeans.DeviceCheckRequestDocument;
import com.cattsoft.xml4mos.xmlbeans.DeviceQueryRequest;
import com.cattsoft.xml4mos.xmlbeans.DeviceStaffRelation;
import com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationRequest;
import com.cattsoft.xml4mos.xmlbeans.MaintainInfo;
import com.cattsoft.xml4mos.xmlbeans.ResultInfo;
import com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffResponse.MacAddressList;
import com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationRequest.DeviceStaffRelations;
import com.cattsoft.xml4mos.xmlbeans.ResultInfo.MaintainInfos;
/**
 * 终端领取功能
 * @author xueweiwei
 *
 */
public class TermailHandleAction extends DispatchAction{

	private static Logger log = Logger.getLogger(ResourceAction.class);
	
	public TermailHandleAction(){		
	}
	
	/**
	 * 获得从客户端传入的json字符串
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJSON(HttpServletRequest request) throws IOException {
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
	 * 查询该用户名下所领取的设备列表
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
	public ActionForward queryTermailList4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, XmlException {
		log.debug("终端列表查询 ");
		
		String jsonStr=getJSON(request);
		com.alibaba.fastjson.JSONObject termailRequestObject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		//创建请求的xml
		com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffRequest deviceQueryReqDec = com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffRequest.Factory.newInstance();		
		deviceQueryReqDec.setStaffId(termailRequestObject.getString("staffId"));
		
		//获得资源传送的xml
	//	String responsexml=TermailHandleDelegate.getDelegate().termailHandle(deviceQueryReqDec.toString(),SysConstants.FUNCODE_QUERY_TERMAIL);
		
		//创建测试xml
		com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffResponse termailListRep1 = com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffResponse.Factory.newInstance();
		termailListRep1.setResultKey("0");
		termailListRep1.setResultValue("成功");
		MacAddressList macAddressList = termailListRep1.addNewMacAddressList();
		com.cattsoft.xml4mos.xmlbeans.MacAddress macAddress1 = macAddressList.addNewMacAddress();
		macAddress1.setLocalNetId("432");
		macAddress1.setMacAddress("111111");
		macAddress1.setServiceAreaId("43201");
		macAddress1.setStaffId("130000000");
		
		com.cattsoft.xml4mos.xmlbeans.MacAddress macAddress2 = macAddressList.addNewMacAddress();
		macAddress2.setLocalNetId("432");
		macAddress2.setMacAddress("222222");
		macAddress2.setServiceAreaId("43201");
		macAddress2.setStaffId("130000000");
		
		com.cattsoft.xml4mos.xmlbeans.MacAddress macAddress3 = macAddressList.addNewMacAddress();
		macAddress3.setLocalNetId("432");
		macAddress3.setMacAddress("333333");
		macAddress3.setServiceAreaId("43201");
		macAddress3.setStaffId("130000000");
		
		com.cattsoft.xml4mos.xmlbeans.MacAddress macAddress4 = macAddressList.addNewMacAddress();
		macAddress4.setLocalNetId("432");
		macAddress4.setMacAddress("444444");
		macAddress4.setServiceAreaId("43201");
		macAddress4.setStaffId("130000000");
		
		//解析xml并转换成json字符串
		com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffResponse termailListRep = com.cattsoft.xml4mos.xmlbeans.DeviceQueryByStaffResponse.Factory.parse(termailListRep1.toString());
		com.cattsoft.xml4mos.xmlbeans.MacAddress macAddress[] = termailListRep.getMacAddressList().getMacAddressArray();
		
		List<String> termailList = new ArrayList<String>();
		for(int i=0;i<macAddress.length;i++){
			termailList.add(macAddress[i].getMacAddress());
		}
		
		Map<String,Object> termailMap = new HashMap<String,Object>();
		termailMap.put("resultCode", termailListRep.getResultKey());
		termailMap.put("resultValue", termailListRep.getResultValue());
		termailMap.put("macAddressList", termailList);
		
		
		String termailJsonObject = com.alibaba.fastjson.JSONObject.toJSONString(termailMap); 
		
		
		byte[] jsonBytes = termailJsonObject.getBytes("utf-8");
		response.setContentLength(jsonBytes.length);
		response.getOutputStream().write(jsonBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}
	/**
	 * 终端详情
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
	public ActionForward queryTermailDetail4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, XmlException {
		log.debug("终端详情 ");
		String jsonStr=getJSON(request);
		com.alibaba.fastjson.JSONObject termailDetailRequestObject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		//创建请求的xml
		com.cattsoft.xml4mos.xmlbeans.DeviceQueryRequest deviceQueryReq = com.cattsoft.xml4mos.xmlbeans.DeviceQueryRequest.Factory.newInstance();				
		deviceQueryReq.setMacAddress((String) termailDetailRequestObject.get("macAddress"));
		
		//获得资源传送过来的xml
		String responsexml=TermailHandleDelegate.getDelegate().termailHandle(deviceQueryReq.toString(),SysConstants.FUNCODE_TERMAIL_DETAIL);
		
		//解析xml并转换成json字符串		
		com.cattsoft.xml4mos.xmlbeans.DeviceQueryResponse termailDetailRep = com.cattsoft.xml4mos.xmlbeans.DeviceQueryResponse.Factory.parse(responsexml.toString());
		
		JSONObject termailDetailJsonObject=new JSONObject();
		termailDetailJsonObject.put("resultCode", termailDetailRep.getResult().getResultKey());
		termailDetailJsonObject.put("sn", termailDetailRep.getSN());
		termailDetailJsonObject.put("factory", termailDetailRep.getFactory());
		termailDetailJsonObject.put("model", termailDetailRep.getModel());
		termailDetailJsonObject.put("barCode", termailDetailRep.getBarCode());
		termailDetailJsonObject.put("protocol", termailDetailRep.getProtocol());
		termailDetailJsonObject.put("hardwareVersion", termailDetailRep.getHardWareVersion());
		
		byte[] jsonBytes = termailDetailJsonObject.toString().getBytes("utf-8");
		response.setContentLength(jsonBytes.length);
		response.getOutputStream().write(jsonBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
		
	}
	/**
	 * 领取或退还终端
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
	public ActionForward addOrDeleteTermail4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, XmlException {
		log.debug("领取或退还终端 ");
		String jsonStr=getJSON(request);
		com.alibaba.fastjson.JSONObject termailAddRequestObject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		String addOrDel = (String) termailAddRequestObject.get("addOrDel");//判断是领取还是退还
		//获取要领取的终端列表
		List<ScanTermailSVO> termailHandleList = com.alibaba.fastjson.JSON.parseArray((String) termailAddRequestObject.get("deviceStaffRelation"), ScanTermailSVO.class);
		
		//创建请求的xml
		com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationRequestDocument termailHandleReqDec =  com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationRequestDocument.Factory.newInstance();
		MaintainDeviceStaffRelationRequest termailHandleReq = termailHandleReqDec.addNewMaintainDeviceStaffRelationRequest();
		DeviceStaffRelations termailHandleRels = termailHandleReq.addNewDeviceStaffRelations();
		for(int i=0;i<termailHandleList.size();i++){
			DeviceStaffRelation termailHandleRel = termailHandleRels.addNewDeviceStaffRelation();
			termailHandleRel.setLocalNetId(termailHandleList.get(i).getLocalNetId());
			termailHandleRel.setServiceAreaId(termailHandleList.get(i).getAreaId());
			termailHandleRel.setStaffId(termailHandleList.get(i).getStaffId());
			termailHandleRel.setMacAddress(termailHandleList.get(i).getMacAddress());
		}
		
		//获得资源传送过来的xml
//		String responsexml;
//		if(addOrDel.equals("add")){//判断是领取还是退还
//			responsexml=TermailHandleDelegate.getDelegate().termailHandle(termailHandleReqDec.toString(),SysConstants.FUNCODE_TERMAIL_ADD);
//		}else{
//			responsexml=TermailHandleDelegate.getDelegate().termailHandle(termailHandleReqDec.toString(),SysConstants.FUNCODE_TERMAIL_DELETE);
//		}
		
		//创建测试XML
		com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationResponseDocument termailHandleBackRepDoc = com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationResponseDocument.Factory.newInstance();
		com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationResponse  termailHandleBackRep = termailHandleBackRepDoc.addNewMaintainDeviceStaffRelationResponse();
		ResultInfo termailHandleBack = termailHandleBackRep.addNewResultInfo();
		termailHandleBack.setResultCode("0");
		termailHandleBack.setResultRemarks("全部成功");
		MaintainInfos termailHandleBackList = termailHandleBack.addNewMaintainInfos();
//		
		MaintainInfo termailHandleBackInfo1 = termailHandleBackList.addNewMaintainInfo();
		termailHandleBackInfo1.setFlag("1");
		termailHandleBackInfo1.setMacAddress("1111111");
		termailHandleBackInfo1.setRemark("入库失败");
		
		MaintainInfo termailHandleBackInfo2 = termailHandleBackList.addNewMaintainInfo();
		termailHandleBackInfo2.setFlag("1");
		termailHandleBackInfo2.setMacAddress("222222");
		termailHandleBackInfo2.setRemark("入库失败");
		
		
		
		//解析xml
	//	String termailBackJson = StringUtil.xml2JSON(termailHandleBackRepDoc.toString());
		com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationResponseDocument maintainDeviceStaffRelationRepDoc = com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationResponseDocument.Factory.parse(termailHandleBackRepDoc.toString());
		com.cattsoft.xml4mos.xmlbeans.MaintainDeviceStaffRelationResponse MaintainDeviceStaffRelationRep = maintainDeviceStaffRelationRepDoc.getMaintainDeviceStaffRelationResponse();
		com.cattsoft.xml4mos.xmlbeans.ResultInfo resultInfo = MaintainDeviceStaffRelationRep.getResultInfo();
		
		String resultCode = resultInfo.getResultCode();
		String resultRemarks = resultInfo.getResultRemarks();
		MaintainInfos maintainInfos = resultInfo.getMaintainInfos();
		MaintainInfo maintainInfo[] = maintainInfos.getMaintainInfoArray();
		
		List<String> termailBackList = new ArrayList<String>();
		for(int i=0;i<maintainInfo.length;i++){
			termailBackList.add(maintainInfo[i].getMacAddress());
		}
		
		Map<String,Object> termailMap = new HashMap<String,Object>();
		termailMap.put("resultCode", resultCode);
		termailMap.put("resultRemarks",resultRemarks);
		termailMap.put("termailBackList", termailBackList);
		
		
		String termailBackJsonObject = com.alibaba.fastjson.JSONObject.toJSONString(termailMap); 
		
		byte[] jsonBytes = termailBackJsonObject.toString().getBytes("utf-8");
		response.setContentLength(jsonBytes.length);
		response.getOutputStream().write(jsonBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
		
	}
}
