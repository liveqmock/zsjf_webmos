package com.cattsoft.tm.component.dao;

import java.util.List;

import com.cattsoft.pub.dao.ISDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;

public interface IMaterialBackFillSDAO extends ISDAO {
	public void addBat(List list) throws AppException, SysException;
	public void add(GenericVO vo) throws AppException, SysException ;
	public GenericVO findByPK(GenericVO vo) throws AppException, SysException ;
	public List findByVO(GenericVO vo) throws AppException, SysException ;
	public void update(GenericVO vo) throws AppException, SysException ;
	public void delete(GenericVO vo) throws AppException, SysException ;
	public void unable(GenericVO vo) throws AppException, SysException ;
}
