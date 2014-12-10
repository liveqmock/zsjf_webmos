package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.delegate.StatiscalReportDelegate;
import com.cattsoft.webpub.util.ReqUtil;

public class StatiscalReportAction extends DispatchAction  {

	//统计报表
	public ActionForward queryReport4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException, IOException {
		String jsonString = ReqUtil.getRequestStr(request);
        JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
        String woStaffId = (String) jsonObjectRequest.get("woStaffId");
	  //  String localNetId = (String) jsonObjectRequest.get("localNetId");
	   // String areaId = (String) jsonObjectRequest.get("areaId");
	    String reportflag = (String) jsonObjectRequest.get("reportflag");
			 JSONObject json=new JSONObject();
			    json.put("woStaffId", woStaffId);
				//json.put("localNetId", localNetId);
				//json.put("areaId", areaId);
				json.put("reportflag", reportflag);
		String resultStr = StatiscalReportDelegate.getDelegate().queryReport4MOS(json.toString());
	
//		if("[]".equals(resultStr)||StringUtil.isBlank(resultStr)) {
//			throw new AppException("", "没有您查询的信息！");
//		}
		
       if(resultStr.contains("Exception")) {
			throw new AppException("", "没有您查询的信息！");
		}
		byte[] jsonBytes;
		//有可能不存在
		ReqUtil.write(response, resultStr);
	return null;
	}
	
	
	//报表列表
	public ActionForward queryReportList4MOS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AppException, SysException, IOException {
		 //从request 中取出json条件串,从而获得条件
		String jsonString = ReqUtil.getRequestStr(request);
        JSONObject jsonObjectRequest = JSONObject.fromObject(jsonString);
		//把对象转化成为json字符串
		JSONObject json=new JSONObject();
		//装修与否
		String reportflag = (String) jsonObjectRequest.get("reportflag");
		    if(reportflag != null && !"".equals(reportflag.trim())){
		    	if ("mend".equals(reportflag)){
		    		  json.put("reportflag", reportflag);
		    		  String timeflag = (String) jsonObjectRequest.get("timeflag");
		    		  if(timeflag != null && !"".equals(timeflag.trim())){
		    	 		 json.put("timeflag", timeflag);
		    	 	   }
		    	 	   String reportType =(String) jsonObjectRequest.get("reportType");
		    	 	   if(reportType != null && !"".equals(reportType.trim())){
		    	 		 json.put("reportType", reportType);
		    	  	   }
		    	 	  String woStaffId =(String) jsonObjectRequest.get("woStaffId");
		    	 	  if(woStaffId != null && !"".equals(woStaffId.trim())){
			    	 		 json.put("woStaffId", woStaffId);
			    	  	   }
		    	}else{
		    		//修装，set 到对象中
		    		  json.put("reportflag", reportflag);
		    		 
		    		  //月、周  
		    		  String timeflag = (String) jsonObjectRequest.get("timeflag");
		    		  if(timeflag != null && !"".equals(timeflag.trim())){
		    	 		 json.put("timeflag", timeflag);
		    	 	   }
		    		   //总量、及时、超时 
		    	 	   String reportType =(String) jsonObjectRequest.get("reportType");
		    	 	   if(reportType != null && !"".equals(reportType.trim())){
		    	 		 json.put("reportType", reportType);
		    	  	   }
		    	 	  String woStaffId =(String) jsonObjectRequest.get("woStaffId");
		    	 	  if(woStaffId != null && !"".equals(woStaffId.trim())){
			    	 		 json.put("woStaffId", woStaffId);
			    	  	   }
		    	}
		    }
		  
			// 按工单号排序
			json.put("culmName", SysConstants.REPORT_COLUMN_SEQ);
			int pagNo = -1;
			PagInfo pagInfo = new PagInfo();
				
				if( (Integer)jsonObjectRequest.get("pageNo")==null)
				{ 
				pagNo=1;
			    }
				else{
					pagNo=(Integer)jsonObjectRequest.get("pageNo");
				}
				json.put("pagNo", pagNo);
				json.put("pagsize", 20);
				
    String jsonresult = StatiscalReportDelegate.getDelegate().queryReportList4MOS(json.toString());
		
    if("[]".equals(jsonresult)||StringUtil.isBlank(jsonresult)) {
    	jsonresult=StringUtil.getAppException4MOS("查询结果为空!");
	}
    
    if(jsonresult.contains("Exception")) {
    	jsonresult=StringUtil.getAppException4MOS("查询结果为空!");
	}
    
	byte[] jsonBytes;
	ReqUtil.write(response, jsonresult);
	return null;

	}
	
	
	/**
	 * 获得从客户端传入的json字符串
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJSON(HttpServletRequest request) throws IOException{
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
