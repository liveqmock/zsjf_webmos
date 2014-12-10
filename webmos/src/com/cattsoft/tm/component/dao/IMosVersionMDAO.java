package com.cattsoft.tm.component.dao;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.tm.vo.MosVersionSVO;

public interface IMosVersionMDAO extends IDAO{

	/**
	 * 查询版本最大号R
	 */
	public MosVersionSVO getLateVersion(String whichApp) throws SysException, AppException;
}
