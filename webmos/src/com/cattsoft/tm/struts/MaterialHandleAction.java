package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.alibaba.fastjson.JSON;
import com.cattsoft.tm.delegate.MaterialDelegate;
import com.cattsoft.tm.vo.ChgServSpecMaterialMVO;
import com.cattsoft.tm.vo.MaterialBackFillSVO;
import com.cattsoft.tm.vo.MaterialSpecSVO;
import com.cattsoft.webpub.util.ReqUtil;

public class MaterialHandleAction extends DispatchAction {

	public ActionForward initMaterialTypeData4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String jsonStr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject initMaterialProObject = com.alibaba.fastjson.JSONObject
				.parseObject(jsonStr);
		ChgServSpecMaterialMVO chgServSpecMaterialMVO = new ChgServSpecMaterialMVO();
		String meterialSnCode = (String) initMaterialProObject.get("smnumber");
		String prodId = (String) initMaterialProObject.get("prodId");
		String chgServSpecId = (String) initMaterialProObject
				.get("chgServSpecId");
		String areaId = (String) initMaterialProObject.get("areaId");
		String localNetId = (String) initMaterialProObject.get("localNetId");
		String workorder = (String) initMaterialProObject.get("workorder");
		if (meterialSnCode != null) {
			chgServSpecMaterialMVO.setMeterialSnCode(meterialSnCode);
		}
		if (prodId != null) {
			chgServSpecMaterialMVO.setProdId(prodId);
		}
		if (chgServSpecId != null) {
			chgServSpecMaterialMVO.setChgServSpecId(chgServSpecId);
		}
		if (areaId != null) {
			chgServSpecMaterialMVO.setAreaId(areaId);
		}
		if (localNetId != null) {
			chgServSpecMaterialMVO.setLocalNetId(localNetId);
		}
		if (workorder != null) {
			chgServSpecMaterialMVO.setWorkOrder(workorder);
		}
		String returnStr = MaterialDelegate.getDelegate()
				.initMaterialTypeData4MOS(initMaterialProObject.toString());
		// String woListString = JSON.toJSONString(returnStr);
		ReqUtil.write(response, returnStr);
		return null;
	}

	public ActionForward findMaterialTypeData4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String jsonStr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject initMaterialProObject = com.alibaba.fastjson.JSONObject
				.parseObject(jsonStr);
		MaterialSpecSVO materialSpecSVO = new MaterialSpecSVO();
		String meterialSnCode = (String) initMaterialProObject.get("smnumber");
		if (meterialSnCode != null) {
			materialSpecSVO.setMeterialSnCode(meterialSnCode);
		}
		// JSONObject materialTypeJsonObject=new JSONObject();
		// materialTypeJsonObject.put("chgServSpecMaterialMVO",
		// materialSpecSVO);
		String returnStr = MaterialDelegate.getDelegate()
				.findMaterialTypeData4MOS(initMaterialProObject.toString());
		// String woListString = JSON.toJSONString(returnStr);
		ReqUtil.write(response, returnStr);
		return null;
	}

	public ActionForward insertIntoMaterialData4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonStr = getJSON(request);
		com.alibaba.fastjson.JSONObject initMaterialProObject = com.alibaba.fastjson.JSONObject
				.parseObject(jsonStr);
		String flag = (String) initMaterialProObject.get("flag");
		String jsonlist = (String) initMaterialProObject.get("materialList");
		List<MaterialBackFillSVO> materialList = JSON.parseArray(jsonlist,
				MaterialBackFillSVO.class);
		JSONObject materialTypeJsonObject = new JSONObject();

		MaterialDelegate.getDelegate().insertIntoMaterialData4MOS(
				initMaterialProObject.toString());

		String isSuccess = "success";
		byte[] jsonBytes = isSuccess.getBytes("utf-8");
		response.setContentLength(jsonBytes.length);
		response.getOutputStream().write(jsonBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}

	// 删除对应的所有材料
	public ActionForward deleteAllMaterialByWo4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonStr = getJSON(request);
		com.alibaba.fastjson.JSONObject initMaterialProObject = com.alibaba.fastjson.JSONObject
				.parseObject(jsonStr);
		String workorder = (String) initMaterialProObject.get("workorder");
		MaterialDelegate.getDelegate().deleteAllMaterialByWo4MOS(workorder);

		String isSuccess = "success";
		byte[] jsonBytes = isSuccess.getBytes("utf-8");
		response.setContentLength(jsonBytes.length);
		response.getOutputStream().write(jsonBytes);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}

	// 查询材料回填表，判断是否回填
	public ActionForward queryWoCount4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonStr = ReqUtil.getRequestStr(request);
		com.alibaba.fastjson.JSONObject initMaterialProObject = com.alibaba.fastjson.JSONObject
				.parseObject(jsonStr);

		String workorder = (String) initMaterialProObject.get("workorder");
		String count = (String) MaterialDelegate.getDelegate()
				.queryWoCount4MOS(workorder);
		ReqUtil.write(response, count);
		return null;
	}

	public String updateMaterialData4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jsonStr = ReqUtil.getRequestStr(request);

		String res = MaterialDelegate.getDelegate().updateIntoMaterialData4MOS(
				jsonStr);

		res = "success";
		ReqUtil.write(response, res);
		return null;
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

}
