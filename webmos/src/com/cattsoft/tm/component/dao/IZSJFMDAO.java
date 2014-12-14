package com.cattsoft.tm.component.dao;

import java.util.List;
import java.util.Map;

import com.cattsoft.pub.dao.IDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.vo.SysUserSVO;
import com.cattsoft.tm.vo.TRptGcjgtjMVO;
import com.cattsoft.tm.vo.TRptGczttjSVO;
import com.cattsoft.tm.vo.TRptHfyb3gybSVO;
import com.cattsoft.tm.vo.TRptHfybCpSVO;
import com.cattsoft.tm.vo.TRptHfybGjywytbSVO;
import com.cattsoft.tm.vo.TRptHfybKhqSVO;
import com.cattsoft.tm.vo.TRptHfybQxSVO;
import com.cattsoft.tm.vo.TRptHfybWgSVO;
import com.cattsoft.tm.vo.TRptJtbbHybrbSVO;
import com.cattsoft.tm.vo.TRptJtbbQsfzrbSVO;
import com.cattsoft.tm.vo.TRptWgybKdyfzbbSVO;
import com.cattsoft.tm.vo.TRptZdgzKhjlSVO;

public interface IZSJFMDAO extends IDAO{
	
	/**
	 * �ص��ע֮�ص�ҵ���ձ�
	 */
	public List zdgz4zdywrb(GenericVO vo) throws AppException, SysException;
	
	/**
	 * �����ձ�֮�ص�ҵ��չ�ձ�
	 */
	public List hsrb4zdywfzrb(GenericVO vo) throws AppException, SysException;
	
	/**
	 * �����ձ�֮3Gҵ���ձ�
	 */
	public List hsrb43gyw(GenericVO vo) throws AppException, SysException ;
	
	/**
	 * �����ձ�֮3Gҵ���ձ���ȡ�����б�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsrb43gywDqList() throws AppException,SysException;
	
	/**
	 * �����ձ�֮2Gҵ���ձ�
	 */
	public List hsrb42gyw(GenericVO vo) throws AppException, SysException ;
	
	/**
	 * �����ձ�֮���ҵ���ձ�
	 */
	public List hsrb4kdyw(GenericVO vo) throws AppException, SysException;
	
	/**
	 * �����ձ�֮�ص�ҵ����װ�ձ�
	 */
	public List hsrb4zdywlz(Map vo) throws AppException, SysException;
	
	/**
	 * �����ձ�֮�ͻ�������װ�ձ�
	 */
	public List hsrb4khjllz(Map vo) throws AppException, SysException;
	
	/**
	 * ��ȡ��ȥ���ظ���ĺ����ձ�֮�ͻ�������׮�ձ��еĲ���
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getWgList4hsrb4khlzjlrb() throws AppException, SysException;
	
	/**
	 * �����ձ�֮�������м�ҵ��չ�ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List jtrb4qsjywfzrb(TRptJtbbQsfzrbSVO vo) throws AppException, SysException;
	
	
	/**
	 * �����ձ�֮��ҵ��ҵ��չ�ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List jtrb4hybywfzrb(TRptJtbbHybrbSVO vo) throws AppException, SysException;
	
	
	/**
	 * �����ձ�������ҵ��չ�ձ�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List qdrb4gwdywfzrb(Map m) throws AppException,SysException;
	
	/**
	 * �����ձ� ���������ص�ҵ���ձ�
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List qdrb4qdwgzdywrb(Map m) throws AppException, SysException;
	
	/**
	 * �����ձ�������ҵ��չ�ձ�
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List  qdrb4gwdywfzrbwgList() throws AppException,SysException;
	
	/**
	 * �����±�4�ؼ�ָ���±�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb4gjzbyb(TRptHfybGjywytbSVO vo)  throws AppException,SysException;
	
	
	/**
	 * �����±�43Gҵ���±�
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb43gyb(TRptHfyb3gybSVO vo)  throws AppException,SysException;
	
	/**
	 * ��ȡ��ȥ���ظ���ĺ����±�֮3G�±��ĵ���
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getWgList4hsyb43gyw() throws AppException, SysException;
	
	
	/**
	 * �����±�4����·�չ���
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb4kdyfzqk(TRptWgybKdyfzbbSVO vo)  throws AppException,SysException;
	
	/**
	 * �±������뻷��ͨ�������ͻ�Ⱥ
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List showYB4Srhbtbkhq(TRptHfybKhqSVO vo)    throws AppException,SysException;
	
	
	/**
	 * �����ձ�4�������ص��ע
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsrb4wgjlzdgz(TRptZdgzKhjlSVO vo)  throws AppException,SysException;
	
	
	public List getFuncNodeListByUser(SysUserSVO vo) throws AppException,SysException;
	
	
	
	/**
	 * ���̿�����Ϣͳ��
	 * @param reParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List showGCJGTJReport(TRptGcjgtjMVO vo) throws AppException,
			SysException;
	
	public List showGCZTTJReport(TRptGczttjSVO vo) throws AppException,
	SysException ;
	
	
	//�±������뻷��ͨ������ҵ��
	public List  showYB4srhbtb4yw(TRptHfybCpSVO vo)    throws AppException,SysException;
	
	//�±������뻷��ͨ����������
	public List showYB4srhbtb4wg(TRptHfybWgSVO vo) throws AppException,
	SysException;
	
	/**
	 * �������뻷��ͨ��
	 */
	public List showYB4srhbtb4qx(TRptHfybQxSVO vo) throws AppException,
	SysException;
	
	/**
	 * ��Ʒɸѡ����-���뻷��ͨ�������ͻ�Ⱥ
	 */
	public List getCpList4srhb4khq() throws AppException, SysException;

	/**
	 * У԰�ձ� У԰�����ص�ҵ���ձ�
	 * 
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List xyrb4xywgzdywrb(Map m) throws AppException, SysException ;
	

	/**
	 * ��ͨ��-�����ͻ������ձ�
	 * 
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List rtb4qdkhjlrb(Map m) throws AppException, SysException;
}
