package com.cattsoft.tm.component.domain;

import com.cattsoft.pub.MaxId;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.tm.component.dao.IStaffLocationSDAO;
import com.cattsoft.tm.vo.StaffLocationSVO;

/**
 * 
 * @author maxun
 * CreateTime 2013-1-6 17:04:36
 */
public class StaffLocationDOM {

	public void addStaffLocation4MOS(String staffLocationJson) throws SysException, AppException {
		com.alibaba.fastjson.JSONObject staffLocationJsonObject = com.alibaba.fastjson.JSONObject.parseObject(staffLocationJson);
		String staffId = staffLocationJsonObject.getString("staffId");
		String location = staffLocationJsonObject.getString("location");
		
		StaffLocationSVO staffLocationSVO = new StaffLocationSVO();
		staffLocationSVO.setStaffLocatioinId(MaxId.getSequenceNextVal(SysConstants.STAFF_LOCATIOIN_ID_SEQ));
		staffLocationSVO.setStaffId(staffId);
		staffLocationSVO.setLocation(location);
		staffLocationSVO.setCreateTime(DateUtil.getDBDate());
		staffLocationSVO.setSts(SysConstants.USE_YES_STS);
		staffLocationSVO.setStsDate(DateUtil.getDBDate());
		
		IStaffLocationSDAO staffLocationDao=(IStaffLocationSDAO) DAOFactory.getDAO(IStaffLocationSDAO.class);
		staffLocationDao.add(staffLocationSVO);
	}
}
