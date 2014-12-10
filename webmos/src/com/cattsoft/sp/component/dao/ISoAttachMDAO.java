package com.cattsoft.sp.component.dao;

import java.util.List;

import org.apache.struts.upload.FormFile;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

/**
 * 
 * Title: 服务开通系统<br>
 * Description: <br>
 * Date: 2008-12-24 <br>
 * Copyright (c) 2008 CATTSoft<br>
 * 
 * @author shilei
 */
public interface ISoAttachMDAO extends IDAO {
	public void updateSoAttach(FormFile file, String soAttachId)
			throws AppException, SysException;

	public GenericVO findByPK(GenericVO vo) throws AppException, SysException;
	public List findSoAttachListByVO(GenericVO vo) throws AppException, SysException;
	/**
	 * Mos Native是以byte[]上传，故重载此方法以适应byte[]
	 * @param bytes
	 * @param soAttachId
	 * @throws AppException
	 * @throws SysException
	 * @author maxun
	 * CreateTime 2012-11-13 15:08:08
	 */
	public void updateSoAttach(byte[] bytes, String soAttachId)
			throws AppException, SysException;
}
