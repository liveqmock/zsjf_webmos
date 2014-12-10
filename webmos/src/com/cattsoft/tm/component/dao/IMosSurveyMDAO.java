package com.cattsoft.tm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

public interface IMosSurveyMDAO extends IDAO {

	public void addWithoutSignature(GenericVO vo) throws AppException, SysException;
	public void updateSignature(GenericVO vo) throws AppException, SysException;
	public List findByVO(GenericVO vo) throws AppException, SysException;
}
