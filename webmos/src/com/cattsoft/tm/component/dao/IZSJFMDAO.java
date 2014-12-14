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
	 * 重点关注之重点业务日报
	 */
	public List zdgz4zdywrb(GenericVO vo) throws AppException, SysException;
	
	/**
	 * 呼市日报之重点业务发展日报
	 */
	public List hsrb4zdywfzrb(GenericVO vo) throws AppException, SysException;
	
	/**
	 * 呼市日报之3G业务日报
	 */
	public List hsrb43gyw(GenericVO vo) throws AppException, SysException ;
	
	/**
	 * 呼市日报之3G业务日报获取呼市列表
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsrb43gywDqList() throws AppException,SysException;
	
	/**
	 * 呼市日报之2G业务日报
	 */
	public List hsrb42gyw(GenericVO vo) throws AppException, SysException ;
	
	/**
	 * 呼市日报之宽带业务日报
	 */
	public List hsrb4kdyw(GenericVO vo) throws AppException, SysException;
	
	/**
	 * 呼市日报之重点业务揽装日报
	 */
	public List hsrb4zdywlz(Map vo) throws AppException, SysException;
	
	/**
	 * 呼市日报之客户经理揽装日报
	 */
	public List hsrb4khjllz(Map vo) throws AppException, SysException;
	
	/**
	 * 获取该去除重复后的呼市日报之客户经理缆桩日报中的部门
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getWgList4hsrb4khlzjlrb() throws AppException, SysException;
	
	/**
	 * 集团日报之区级、市级业务发展日报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List jtrb4qsjywfzrb(TRptJtbbQsfzrbSVO vo) throws AppException, SysException;
	
	
	/**
	 * 集团日报之行业部业务发展日报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List jtrb4hybywfzrb(TRptJtbbHybrbSVO vo) throws AppException, SysException;
	
	
	/**
	 * 渠道日报各网点业务发展日报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List qdrb4gwdywfzrb(Map m) throws AppException,SysException;
	
	/**
	 * 渠道日报 渠道网格重点业务日报
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List qdrb4qdwgzdywrb(Map m) throws AppException, SysException;
	
	/**
	 * 渠道日报各网点业务发展日报
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List  qdrb4gwdywfzrbwgList() throws AppException,SysException;
	
	/**
	 * 呼市月报4关键指标月报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb4gjzbyb(TRptHfybGjywytbSVO vo)  throws AppException,SysException;
	
	
	/**
	 * 呼市月报43G业务月报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb43gyb(TRptHfyb3gybSVO vo)  throws AppException,SysException;
	
	/**
	 * 获取该去除重复后的呼市月报之3G月报的地区
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List getWgList4hsyb43gyw() throws AppException, SysException;
	
	
	/**
	 * 呼市月报4宽带月发展情况
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsyb4kdyfzqk(TRptWgybKdyfzbbSVO vo)  throws AppException,SysException;
	
	/**
	 * 月报，收入环比通报，按客户群
	 * @param vo
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List showYB4Srhbtbkhq(TRptHfybKhqSVO vo)    throws AppException,SysException;
	
	
	/**
	 * 呼市日报4网格经理重点关注
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List hsrb4wgjlzdgz(TRptZdgzKhjlSVO vo)  throws AppException,SysException;
	
	
	public List getFuncNodeListByUser(SysUserSVO vo) throws AppException,SysException;
	
	
	
	/**
	 * 工程竣工信息统计
	 * @param reParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List showGCJGTJReport(TRptGcjgtjMVO vo) throws AppException,
			SysException;
	
	public List showGCZTTJReport(TRptGczttjSVO vo) throws AppException,
	SysException ;
	
	
	//月报，收入环比通报，按业务
	public List  showYB4srhbtb4yw(TRptHfybCpSVO vo)    throws AppException,SysException;
	
	//月报，收入环比通报，按网格
	public List showYB4srhbtb4wg(TRptHfybWgSVO vo) throws AppException,
	SysException;
	
	/**
	 * 旗县收入环比通报
	 */
	public List showYB4srhbtb4qx(TRptHfybQxSVO vo) throws AppException,
	SysException;
	
	/**
	 * 产品筛选条件-收入环比通报，按客户群
	 */
	public List getCpList4srhb4khq() throws AppException, SysException;

	/**
	 * 校园日报 校园网格重点业务日报
	 * 
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List xyrb4xywgzdywrb(Map m) throws AppException, SysException ;
	

	/**
	 * 日通报-渠道客户经理日报
	 * 
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public List rtb4qdkhjlrb(Map m) throws AppException, SysException;
}
