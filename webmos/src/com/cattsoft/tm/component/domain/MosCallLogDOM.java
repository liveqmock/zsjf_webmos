/**
 * 
 */
package com.cattsoft.tm.component.domain;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cattsoft.pub.MaxId;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.tm.component.dao.IMosCallLogSDAO;
import com.cattsoft.tm.vo.MosCallLogSVO;

/**
 * @author maxun
 * CreateTime 2012-9-27 下午3:54:06
 */
public class MosCallLogDOM {
	/**
	 * 查询通话记录
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @author maxun
	 */
	public String queryMosCallLog(String mosCallLogJson) throws AppException, SysException{
		
		JSONObject mosCallLogJsonObject=JSONObject.fromObject(mosCallLogJson);
		MosCallLogSVO mosCallLog=new MosCallLogSVO();
		mosCallLog.setWoNbr(mosCallLogJsonObject.getString("woNbr"));
		
		IMosCallLogSDAO mosCallLogDao=(IMosCallLogSDAO) DAOFactory.getDAO(IMosCallLogSDAO.class);
		List mosCallLogList=mosCallLogDao.findByVO(mosCallLog);
		JSONArray mosCallLogJsonArray=null;
		if(mosCallLogList!=null&&mosCallLogList.size()>0) {
			mosCallLogJsonArray=new JSONArray();
			for(int i=0;i<mosCallLogList.size();i++) {
				MosCallLogSVO mosCallLogSvo=(MosCallLogSVO) mosCallLogList.get(i);
				JSONObject mosCallLogVoJsonObject=new JSONObject();
				mosCallLogVoJsonObject.put("bookTime", mosCallLogSvo.getBookTime().getTime());
				mosCallLogVoJsonObject.put("calledPhoneNo", mosCallLogSvo.getCalledPhoneNo());
				mosCallLogVoJsonObject.put("callerPhoneNo", mosCallLogSvo.getCallerPhoneNo());
				mosCallLogVoJsonObject.put("callDuration", mosCallLogSvo.getCallDuration());
				mosCallLogVoJsonObject.put("endTime", mosCallLogSvo.getEndTime().getTime());
				mosCallLogVoJsonObject.put("mosCallLogId", mosCallLogSvo.getMosCallLogId());
				mosCallLogVoJsonObject.put("remarks", mosCallLogSvo.getRemarks());
				mosCallLogVoJsonObject.put("startTime", mosCallLogSvo.getStartTime().getTime());
				mosCallLogVoJsonObject.put("woNbr", mosCallLogSvo.getWoNbr());
				mosCallLogJsonArray.add(mosCallLogVoJsonObject);
			}
			return mosCallLogJsonArray.toString();
		}
		return null;
	}
	/**
	 * 查询通话记录详情
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @author maxun
	 */
	public String queryMosCallLogDetail(String mosCallLogJson) throws AppException, SysException{
		
		JSONObject mosCallLogJsonObject=JSONObject.fromObject(mosCallLogJson);
		MosCallLogSVO mosCallLog=new MosCallLogSVO();
		mosCallLog.setMosCallLogId(mosCallLogJsonObject.getString("mosCallLogId"));
		
		IMosCallLogSDAO mosCallLogDao=(IMosCallLogSDAO) DAOFactory.getDAO(IMosCallLogSDAO.class);
		MosCallLogSVO mosCallLogSvo=(MosCallLogSVO) mosCallLogDao.findByPK(mosCallLog);
		if(mosCallLogSvo!=null) {
				JSONObject mosCallLogVoJsonObject=new JSONObject();
				mosCallLogVoJsonObject.put("bookTime", mosCallLogSvo.getBookTime().getTime());
				mosCallLogVoJsonObject.put("calledPhoneNo", mosCallLogSvo.getCalledPhoneNo());
				mosCallLogVoJsonObject.put("callerPhoneNo", mosCallLogSvo.getCallerPhoneNo());
				mosCallLogVoJsonObject.put("callDuration", mosCallLogSvo.getCallDuration());
				mosCallLogVoJsonObject.put("endTime", mosCallLogSvo.getEndTime().getTime());
				mosCallLogVoJsonObject.put("mosCallLogId", mosCallLogSvo.getMosCallLogId());
				mosCallLogVoJsonObject.put("remarks", mosCallLogSvo.getRemarks());
				mosCallLogVoJsonObject.put("startTime", mosCallLogSvo.getStartTime().getTime());
				mosCallLogVoJsonObject.put("woNbr", mosCallLogSvo.getWoNbr());
				return mosCallLogVoJsonObject.toString();
		}
		return null;
	}
	public void addMosCallLog4MOS(String paraMapStr) throws SysException, AppException{
		com.alibaba.fastjson.JSONObject toOkJsonObject = com.alibaba.fastjson.JSONObject.parseObject(paraMapStr);
		String callerNum = (String) toOkJsonObject.get("callerNum");//主叫号码
		String calledNum = (String) toOkJsonObject.get("calledNum");//被叫号码
		String woNum = (String) toOkJsonObject.get("woNum");//工单号码
		Date startDate = new Date((Long)toOkJsonObject.get("startDate"));//通话开始时间
		Date endDate =  new Date((Long) toOkJsonObject.get("endDate"));//通话结束时间
		String callTime = toOkJsonObject.get("callTime").toString();//通话时长
		Date reservationDate = new Date((Long) toOkJsonObject.get("reservationDate"));//预约时间
		String remark = (String) toOkJsonObject.get("remark");//备注
		MosCallLogSVO mosCallLogSVO = new MosCallLogSVO();
		mosCallLogSVO.setMosCallLogId(MaxId.getSequenceNextVal(SysConstants.MOS_CALL_LOG_ID_SEQ));
		mosCallLogSVO.setBookTime(reservationDate);
		mosCallLogSVO.setCallDuration(callTime);
		mosCallLogSVO.setCallerPhoneNo(callerNum);
		mosCallLogSVO.setCalledPhoneNo(calledNum);
		mosCallLogSVO.setWoNbr(woNum);
		mosCallLogSVO.setEndTime(endDate);
		mosCallLogSVO.setStartTime(startDate);
		mosCallLogSVO.setRemarks(remark);
		IMosCallLogSDAO mosCallLogDao=(IMosCallLogSDAO) DAOFactory.getDAO(IMosCallLogSDAO.class);
		mosCallLogDao.add(mosCallLogSVO);

	}
}
