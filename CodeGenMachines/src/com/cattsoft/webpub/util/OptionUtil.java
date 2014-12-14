/*package com.cattsoft.webpub.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.BizConfig;
import com.cattsoft.pub.util.DataCache;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.component.dao.IAreaSDAO;
import com.cattsoft.sm.component.dao.IExchSDAO;
import com.cattsoft.sm.component.dao.ILocalNetSDAO;
import com.cattsoft.sm.delegate.SMStaffDelegate;
import com.cattsoft.sm.util.SMReqUtil;
import com.cattsoft.sm.vo.AreaSVO;
import com.cattsoft.sm.vo.ExchSVO;
import com.cattsoft.sm.vo.LocalNetSVO;
import com.cattsoft.sm.vo.SysUserExtendedMVO;
import com.cattsoft.sp.component.dao.ICollabRuleBusiMDAO;
import com.cattsoft.sp.component.dao.IFailReasonSDAO;
import com.cattsoft.sp.component.dao.ISoTemplateMDAO;
import com.cattsoft.sp.component.dao.IStepSDAO;
import com.cattsoft.sp.component.dao.IWorkAreaSDAO;
import com.cattsoft.sp.vo.CollabRuleBusiMVO;
import com.cattsoft.sp.vo.FailReasonSVO;
import com.cattsoft.sp.vo.StepSVO;
import com.cattsoft.sp.vo.WorkAreaSVO;
import com.cattsoft.tm.component.dao.IMaintAreaMDAO;
import com.cattsoft.tm.component.dao.ITabColumnSDAO;
import com.cattsoft.tm.component.dao.IWoHandleCustomMDAO;
import com.cattsoft.tm.vo.MaintAreaSVO;
import com.cattsoft.tm.vo.TabColumnSVO;
import com.cattsoft.tm.vo.WoHandleCustomSVO;

*//**
 * Title: CRM系统<br>
 * Description:所有下拉列表初始化的方法 <br>
 * Date: 2007-6-6 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 *//*
public class OptionUtil {
	private static final Logger log = Logger.getLogger(OptionUtil.class);

	*//**
	 * 得到用户可访问的本地网列表
	 * 
	 * @param req
	 * @return
	 * @throws SysException
	 * @throws NumberFormatException
	 * @throws AppException
	 
	public static List getLocalNets(HttpServletRequest req) throws SysException,
			NumberFormatException, AppException {
		SysUserExtendedMVO suve = (SysUserExtendedMVO) req.getSession().getAttribute(
				SysUserExtendedMVO.SESSION_NAME);
		String systemName = suve.getUserSubSystems();
		List staffLns = SMStaffDelegate.getDelegate().getStaffLocalNetVOs(
				Long.valueOf(suve.getStaffExtendMVO().getStaffSVO().getStaffId()), systemName,
				SMReqUtil.getLocalNetId(req));
		List localNetlvBean = new ArrayList();
		LabelValueBean lvBean = null;
		for (int i = 0; i < staffLns.size(); i++) {
			LocalNetSVO vo = (LocalNetSVO) staffLns.get(i);
			lvBean = new LabelValueBean();
			lvBean.setLabel(vo.getName());
			lvBean.setValue(vo.getLocalNetId());
			localNetlvBean.add(lvBean);
		}
		return localNetlvBean;
	}
*//*
	*//**
	 * 本地网下拉列表初始化方法 List<LabelValueBean>
	 * 
	 * @return
	 * @throws SysException
	 *//*
	public static List getLocalNetlvBean() throws SysException {
		List localNets = new ArrayList();
		// Map LocalNetCache = DataCache.get(DataCache.LOCALNET);

		Map LocalNetCache = new HashMap();
		try {
			LocalNetCache = DataCache.getCache(DataCache.LOCALNET);
			localNets = getlvBean(LocalNetCache);
		} catch (DataCacheException e) {
			LogUtil.debug(log, "获取缓存时报错");
		}
		return localNets;
	}

	*//**
	 * 根据本地网进行服务区下拉列表初始化方法
	 * 
	 * @param
	 * @return
	 * @throws SysException
	 * @throws AppException
	 
	public static List getArealvBean(String localNetId) throws SysException, AppException {
		if (StringUtil.isBlank(localNetId)) {
			throw new AppException("", "获取服务区时，缺少本地网参数！");
		}
		localNetId = localNetId.trim();

		List areas = new ArrayList();
		// Map areaCache = DataCache.get(DataCache.AREA);
		//
		// Object obj = areaCache.get(localNetId);
		// if (obj == null)
		// return new ArrayList();
		Map localNetTree = new HashMap();
		try {
			localNetTree = DataCache.getCache(DataCache.LOCALNET_T);
			// LogUtil.debug(log, localNetTree.size()+"");
		} catch (DataCacheException e) {
			e.printStackTrace();
		}
		if (localNetTree == null)
			localNetTree = new HashMap();
		Object obj = localNetTree.get(localNetId);
		if (obj == null)
			return new ArrayList();
		Map areaMap = (Map) obj;
		areas = getlvBean(areaMap);

		return areas;
	}
*//*
	*//**
	 * 初始化环节下拉列表
	 * 
	 * @author ronghengen
	 *//*
	public static List getStepIdlvBean() throws AppException, SysException {

		List list = new ArrayList();
		// Map stepCache = (Map) DataCache.get(DataCache.STEP);
		Map stepCache = new HashMap();
		try {
			stepCache = DataCache.getCache(DataCache.STEP);
			list = getlvBean(stepCache);
		} catch (DataCacheException e) {
			LogUtil.debug(log, "获取缓存时报错");
		}
		return list;
	}

	*//**
	 * 初始化局向下拉列表
	 * 
	 * @author ronghengen
	 *//*
	public static List getExchlvBean(String localNetId, String areaId) throws AppException,
			SysException {
		if (StringUtil.isBlank(localNetId)) {
			throw new AppException("", "获取局向时，缺少本地网参数！");
		}
		if (StringUtil.isBlank(areaId)) {
			throw new AppException("", "获取局向时，缺少服务区参数！");
		}
		localNetId = localNetId.trim();
		areaId = areaId.trim();

		Map localNetTree = new HashMap();
		Map exchMap = new HashMap();
		try {
			localNetTree = DataCache.getCache(DataCache.LOCALNET_AREA_EXCH);// 获取本地网
			// LogUtil.debug(log, localNetTree.size()+"");
		} catch (DataCacheException e) {
			e.printStackTrace();
		}
		Object obj = localNetTree.get(localNetId);// 获取本地网服务区
		if (obj == null)
			return new ArrayList();
		Map localNetMap = (Map) obj;
		// Iterator it=localNetMap.keySet().iterator();
		// while(it.hasNext())
		// {
		// String arId=(String) it.next();
		// Map e=(Map) localNetMap.get(arId);
		// if(e!=null){
		// Iterator i=e.keySet().iterator();
		// while(i.hasNext()){
		// LogUtil.debug(log, e.get(i.next()).toString());
		// }
		// }
		// }
		if (localNetMap != null)
			exchMap = (Map) localNetMap.get(areaId); // 获取局向
		return getlvBean(exchMap);
	}

	public static List getExchlvBeanByWorkAreaId(String workAreaId) throws AppException,
			SysException {

		ExchSVO vo = null;
		try {
			ConnectionFactory.createConnection();
			IExchSDAO dao = (IExchSDAO) DAOFactory.getDAO(IExchSDAO.class);
			List list = dao.findExchListByWorkArea(workAreaId);
			Map exchMap = new HashMap();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				vo = (ExchSVO) it.next();
				exchMap.put(vo.getExchId(), vo.getName());
			}
			list = getlvBean(exchMap);
			return list;
		} finally {
			ConnectionFactory.closeConnection();
		}
	}

	*//**
	 * 工作区下拉列表(缓存取)
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 * @author ronghengen
	 *//*
	public static List getWorkArealvBean() throws AppException, SysException {

		// String sql = "select wa.work_area_id,wa.name from work_area wa";
		List list = new ArrayList();
		// Map workAreaCache = (Map) DataCache.get(DataCache.WORKAREA);
		Map workAreaCache = new HashMap();
		try {
			workAreaCache = DataCache.getCache(DataCache.WORKAREA);
			list = getlvBean(workAreaCache);
		} catch (DataCacheException e) {
			e.printStackTrace();
		}

		return list;
	}

	*//**
	 * @author ronghengen
	 * @return 得到列名下拉列表（从表取）
	 * @throws AppException
	 * @throws SysException
	 * 
	 *//*
	public static List getColumnNameList(GenericVO gvo) throws AppException, SysException {

		// String sql = "select distinct t.column_id,t.name from tab_column t";

		TabColumnSVO vo = (TabColumnSVO) gvo;
		try {
			ConnectionFactory.createConnection();
			ITabColumnSDAO dao = (ITabColumnSDAO) DAOFactory.getDAO(ITabColumnSDAO.class);
			List list = dao.findByForScene(vo);
			Map columnName = new HashMap();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				vo = (TabColumnSVO) it.next();
				columnName.put(vo.getColumnId(), vo.getName());
			}
			list = getlvBean(columnName);
			return list;
		} finally {
			ConnectionFactory.closeConnection();
		}

	}

	*//**
	 * （从表取）
	 * 
	 * @param args
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getPositionList(String[] args) throws AppException, SysException {

		// Sql sql = new Sql("select w.position,w.position from wo_handle_custom w where w.step_id=
		// :stepId and w.work_area_id= :workAreaId and w.tabpage_code= :WoException order by
		// w.position");
		try {
			ConnectionFactory.createConnection();
			WoHandleCustomSVO vo = new WoHandleCustomSVO();
			vo.setWorkTypeId(args[0]);
			// vo.setWorkAreaId(args[1]);
			vo.setTabpageCode(args[1]);

			IWoHandleCustomMDAO dao = (IWoHandleCustomMDAO) DAOFactory
					.getDAO(IWoHandleCustomMDAO.class);
			List list = new ArrayList();
			list = dao.findPositionList(vo);

			// Map position = new HashMap();
			List positionList = new ArrayList();
			if (list != null) {
				LabelValueBean bean = null;
				for (int i = 0; i < list.size(); i++) {
					vo = (WoHandleCustomSVO) list.get(i);
					bean = new LabelValueBean();
					bean.setLabel(vo.getPosition());
					bean.setValue(vo.getPosition());
					positionList.add(bean);
				}
			}
			LabelValueBean element = new LabelValueBean();
			element.setLabel("0");
			element.setValue("0");
			positionList.add(0, element);
			return positionList;
		} finally {
			ConnectionFactory.closeConnection();
		}

	}

	*//**
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getOrderFlagList() throws SysException, AppException {
		List list = OptionUtil.getStatuslvBean("WO_HANDLE_CUSTOM", "ORDER_FLAG");
		return list;
	}

	*//**
	 * 初始化TAB页下拉列表
	 * 
	 * @author ronghengen
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getTabIdlvBean() throws SysException, AppException {
		List list = getStatuslvBean("WO_HANDLE_CUSTOM", "TABPAGE_CODE");
		return list;
	}

	*//**
	 * 初始化工单类型下拉列表
	 *//*
	public static List getWoTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("WO", "WO_TYPE");
		return list;
	}

	*//**
	 * 初始化适用场景下拉列表（status:CHK_RULE/FOR_SCENE）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getForScenelvBean() throws SysException, AppException {

		List list = getStatuslvBean("CHK_RULE", "FOR_SCENE");
		return list;
	}

	*//**
	 * 初始化规则类型下拉列表（status:CHK_RULE/RULE_TYPE）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getRuleTypelvBean() throws SysException, AppException {

		List list = getStatuslvBean("CHK_RULE", "RULE_TYPE");
		return list;

	}

	*//**
	 * 初始化开关标志下拉列表（status:CHK_RULE/OPEN_FLAG）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getOpenFlaglvBean() throws SysException, AppException {
		List openFlag = getStatuslvBean("CHK_RULE", "OPEN_FLAG");

		return openFlag;
	}

	*//**
	 * 初始化状态下拉列表（status:CHK_RULE/STS）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getStslvBean() throws SysException, AppException {

		List sts = getStatuslvBean("CHK_RULE", "STS");
		return sts;
	}

	*//**
	 * 协同规则管理模块中，协同级别下拉列表（status:COLLAB_RULE/COLLAB_LEVEL）
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getCollabLevellvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("COLLAB_RULE", "COLLAB_LEVEL");
		return collabLevels;
	}

	*//**
	 * 协同规则管理模块中，客户服务列表(从缓存取)
	 * 
	 * @return
	 * @throws SysException
	 *//*
	public static List getChgServSpeclvBean() throws SysException {
		List list = new ArrayList();
		// Map chgServSpec = (Map) DataCache.get(DataCache.CHANGESERVSPEC);
		Map chgServSpec = new HashMap();
		try {
			chgServSpec = DataCache.getCache(DataCache.CHANGESERVSPEC);
			list = getlvBean(chgServSpec);
		} catch (DataCacheException e) {
			e.printStackTrace();
		}
		return list;
	}

	*//**
	 * 通过产品id获取户服务列表(从缓存取)
	 * 
	 * @return
	 * @throws SysException
	 *//*
	public static List getChgServSpeclvBean(String prodId) throws SysException {
		List list = new ArrayList();
		// Map chgServSpec = (Map) DataCache.get(DataCache.CHANGESERVSPEC);
		Map chgServSpec = new HashMap();
		try {
			if (StringUtil.isBlank(prodId))
				chgServSpec = DataCache.getCache(DataCache.CHANGESERVSPEC);
			else {
				Map map = DataCache.getCache(DataCache.PRODUCT_T);
				if (map != null)
					chgServSpec = (Map) map.get(prodId);
			}
			if (chgServSpec == null)
				chgServSpec = new HashMap();
			list = getlvBean(chgServSpec);
		}

		catch (DataCacheException e) {
			e.printStackTrace();
		}
		return list;
	}

	*//**
	 * 协同规则管理模块中,产品大类列表(从缓存取)
	 * 
	 * @return
	 * @throws SysException
	 *//*
	public static List getProdCatslvBean() throws SysException {
		List list = new ArrayList();
		// Map prodCats = (Map) DataCache.get(DataCache.PRODSPECCAT);
		// Map prodCats = (Map) DataCache.get(DataCache.PROD_CAT);
		Map prodCats = new HashMap();
		try {
			prodCats = DataCache.getCache(DataCache.PROD_CAT);
		} catch (DataCacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list = getlvBean(prodCats);
		return list;
	}

	*//**
	 * 产品列表（从缓存取）
	 * 
	 * @return
	 * @throws SysException
	 *//*
	public static List getProdlvBean(String prodCatId) throws SysException {
		List list = new ArrayList();
		// Map product = (Map) DataCache.get(DataCache.PRODUCT);
		Map product = new HashMap();
		try {
			if (StringUtil.isBlank(prodCatId))
				product = DataCache.getCache(DataCache.PRODUCT);
			else {
				Map pMap = DataCache.getCache(DataCache.PROD_CAT_T);
				if (pMap != null)
					product = (Map) pMap.get(prodCatId);
			}
		} catch (DataCacheException e) {
			e.printStackTrace();
		}
		if (product == null)
			product = new HashMap();
		list = getlvBean(product);
		return list;
	}

	*//**
	 * 根据产品(主)查找相应的产品服务
	 * 
	 * @return ronghengen
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getChgServ(String prod) throws AppException, SysException {
		try {
			ConnectionFactory.createConnection();
			ISoTemplateMDAO dao = (ISoTemplateMDAO) DAOFactory.getDAO(ISoTemplateMDAO.class);
			List list = dao.fingServByProd(prod);
			return list;
		} finally {
			ConnectionFactory.closeConnection();
		}
	}

	*//**
	 * 接口名称下拉列表(待定)
	 * 
	 * @return yi
	 *//*
	public static List getInterNamelvBean() {
		List interName = new ArrayList();
		LabelValueBean lvBean = new LabelValueBean();
		lvBean = new LabelValueBean();
		lvBean.setLabel("彩铃接口");
		lvBean.setValue("CaiLingInter");
		interName.add(lvBean);
		lvBean = new LabelValueBean();
		lvBean.setLabel("大唐接口");
		lvBean.setValue("DaTangInter");
		interName.add(lvBean);

		return interName;
	}

	*//**
	 * 初始化实时标志下拉列表（status：INTER_CALL_CONFIG/REAL_TIME_FLAG）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getRealTimeFlaglvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("INTER_CALL_CONFIG", "REAL_TIME_FLAG");
		return collabLevels;
	}

	*//**
	 * 初始化方向下拉列表（status：INTER_CALL_CONFIG/DEAL_FLAG）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getDealFlaglvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("INTER_CALL_CONFIG", "DEAL_FLAG");
		return collabLevels;
	}

	*//**
	 * 初始化所属系统下拉列表（status：FAIL_REASON/SYSTEM_NAME）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getSystemNamelvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("FAIL_REASON", "SYSTEM_NAME");
		return collabLevels;
	}

	*//**
	 * 初始化原因责任下拉列表（status：FAIL_REASON/DUTY_FLAG）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getDutyFlaglvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("FAIL_REASON", "DUTY_FLAG");
		return collabLevels;
	}

	*//**
	 * 初始化原因分类下拉列表（status：FAIL_REASON/REASON_CAT）
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getReasonCatlvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("FAIL_REASON", "REASON_CAT");
		return collabLevels;
	}

	*//**
	 * 
	 * 初始化同退标志 （status：PROCESS_COLLAB_RULE/BACK_FLAG)
	 * 
	 * Y同退 N单退
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getBackFlaglvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("PROCESS_COLLAB_RULE", "BACK_FLAG");
		return collabLevels;
	}

	*//**
	 * 
	 * 初始化调用类型 CALL_TYPE（status：PROCESS_COLLAB_RULE/CALL_TYPE)
	 * 
	 * J Java Class P 存储过程 N 无须调用
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getCallTypelvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("PROCESS_COLLAB_RULE", "CALL_TYPE");
		return collabLevels;
	}

	*//**
	 * 
	 * 初始化协同类型 （status：PROCESS_COLLAB_RULE/COLLAB_TYPE)
	 * 
	 * S->S开始－>开始 C->S 结束－>开始 C->C 结束－>结束 SSCC 同时开始，同时结束
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getCollabTypelvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("PROCESS_COLLAB_RULE", "COLLAB_TYPE");
		return collabLevels;
	}

	*//**
	 * 初始化关联组类型 （从缓存取 GROUP_TYPE表）
	 * 
	 * 0副属产品与主产品关系 1 ADSL与普通电话同装并且共线关系 2 模拟中继产品关联关系 3 DDN关联关系 4 X25关联关系 5 小灵通与固话一号双机关系 6
	 * 小灵通与固话灵通无绳关系 7 师大附中网校与AD绑定关系 8 IPTV与宽带绑定关系 9 电话未竣加装AD 10点对点关联 类似基本数据业务如DDN的两点之间的关联关系 11点对多点关联
	 * 类似基本数据业务如DDN的多点之间的关联关系，一般为中心点主端对多个从端 12电话连选 电话的号码连选或端口连选关系 13ADSL + LAN 局域网内LAN用户之间的关联关系
	 * 14ADSL + VPN 虚拟专用网内用户之间的关联关系 15同客户订单关系，对于一个CO下多个SO，如果不指明SO之间的关联组关系，则默认将其置为同时开始关系 16 撤单 17 改单
	 * 
	 * @return
	 * @throws SysException
	 *//*
	public static List getGroupTypeIdlvBean() throws SysException {

		List list = new ArrayList();
		// Map groupType = (Map) DataCache.get(DataCache.GUOUPTYPE);
		Map groupType = new HashMap();
		try {
			groupType = DataCache.getCache(DataCache.GUOUPTYPE);
		} catch (DataCacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list = getlvBean(groupType);
		return list;
	}

	*//**
	 * 
	 * 初始化主业标志 （status：PROCESS_COLLAB_RULE/MAIN_FLAG)
	 * 
	 * M 主业务 S 从业务
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getMainFlaglvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("PROCESS_COLLAB_RULE", "MAIN_FLAG");
		return collabLevels;
	}

	public static List getrelFlaglvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("PROCESS_COLLAB_RULE", "REL_FLAG");
		return collabLevels;
	}

	*//**
	 * 优先级 PRIORITY（status：PROCESS_COLLAB_RULE/PRIORITY)
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getPrioritylvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("PROCESS_COLLAB_RULE", "PRIORITY");
		return collabLevels;
	}

	*//**
	 * 初始化原因特征下拉列表（status：FAIL_REASON/EXP_CODE)
	 * 
	 * @return yi
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getCharacterlvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("FAIL_REASON", "EXP_CODE");
		return collabLevels;
	}

	*//**
	 * 初始化异常原因名称下拉列表(从表取)
	 * 
	 * @return ronghengen
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getFailReasonNamelvBean(String expCode) throws AppException, SysException {
		FailReasonSVO vo = new FailReasonSVO();
		vo.setExpCode(expCode);
		try {
			ConnectionFactory.createConnection();
			IFailReasonSDAO dao = (IFailReasonSDAO) DAOFactory.getDAO(IFailReasonSDAO.class);
			List list = dao.findByVO(vo);
			Map reasonName = new HashMap();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				vo = (FailReasonSVO) it.next();
				reasonName.put(vo.getFailReasonId(), vo.getName());
			}
			list = getlvBean(reasonName);
			return list;
		} finally {
			ConnectionFactory.closeConnection();
		}
	}

	*//**
	 * 初始化审核标志下拉列表（status：STEP_FAIL_REASON/AUDIT_FLAG）
	 * 
	 * @return ronghengen
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getAuditFlaglvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("STEP_FAIL_REASON", "AUDIT_FLAG");
		return collabLevels;
	}

	*//**
	 * 初始化异常处理标志
	 *//*
	public static List getFailDoFlagLvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("STEP_FAIL_REASON", "FAIL_DO_FLAG");
		return collabLevels;
	}

	*//**
	 * 初始化派发标志 DISP_FLAG(status：STEP_COLLAB_RULE/DISP_FLAG)
	 * 
	 * Y派发 N免派
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getDispFlaglvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("STEP_COLLAB_RULE", "DISP_FLAG");
		return collabLevels;
	}

	*//**
	 * 合单标志 MERG_FLAG C1(status：STEP_COLLAB_RULE/MERG_FLAG)
	 * 
	 * Y 需要合单 N 无需合单
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getMergFlaglvBean() throws SysException, AppException {

		List collabLevels = getStatuslvBean("STEP_COLLAB_RULE", "MERG_FLAG");
		return collabLevels;
	}

	*//**
	 * 执行方式(status：SO_TEMPLATE/EXEC_MODE)
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getExecModeBean() throws SysException, AppException {
		List prodCats = getStatuslvBean("SO_TEMPLATE", "EXEC_MODE");

		return prodCats;
	}

	*//**
	 * 用算符号(status：SO_TEMPLATE/MATCH_OPERATOR)
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getOperator() throws SysException, AppException {
		List list = getStatuslvBean("SO_MATCH", "MATCH_OPERATOR");

		return list;
	}

	*//**
	 * 处理级别
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getPRIORITY() throws SysException, AppException {
		List list = getStatuslvBean("SO", "PRIORITY");

		return list;
	}

	*//**
	 * 过程状态
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getRunSts() throws SysException, AppException {
		List list = getStatuslvBean("WO", "RUN_STS");

		return list;
	}

	*//**
	 * 业务状态
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getBusiSts() throws SysException, AppException {
		List list = getStatuslvBean("WO", "BUSI_STS");

		return list;
	}

	*//**
	 * 操作类型
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getActTpye() throws SysException, AppException {
		List list = getStatuslvBean("WO", "ACT_TYPE");
		return list;
	}

	*//**
	 * 根据指定表明字段名，从status缓存中获取配置信息列表
	 * 
	 * @param tableName
	 * @param columnName
	 * @return List<LabelValueBean<StsWords,StsId>>
	 * @throws SysException
	 * @throws AppException
	 *//*
	private static List getStatuslvBean(String tableName, String columnName) throws SysException,
			AppException {
		// List statusList = new ArrayList();
		// Map statusCache = DataCache.get(DataCache.STATUS);
		// String key = tableName + DataCache.STATUS_SPLIT_WORD + columnName;
		// LogUtil.debug(log, "获取status缓存信息：" + key);
		// Object obj = statusCache.get(key);
		// if (null == obj) {
		// throw new AppException("", "请检查status配置，是否存在" + key + "对应信息!");
		// }
		// Map valueMap = (Map) obj;
		// Iterator itor = valueMap.keySet().iterator();
		// while (itor.hasNext()) {
		// String stsId = (String) itor.next();
		// String stsWord = (String) valueMap.get(stsId);
		// LabelValueBean lvBean = new LabelValueBean();
		// lvBean.setLabel(stsWord);
		// lvBean.setValue(stsId);
		// statusList.add(lvBean);
		// }
		List statusList = new ArrayList();
		try {
			Map statusMap = BizConfig.getStatusHashMap(tableName, columnName);
			statusList = getlvBean(statusMap);
		} catch (DataCacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statusList;
	}

	*//**
	 * 根据map获得LabelValueBean的list
	 * 
	 * @param labelValueMap
	 *            <id,label>
	 * @return
	 *//*
	private static List getlvBean(Map labelValueMap) {
		List lvBeans = new ArrayList();
		if (labelValueMap == null)
			return lvBeans;
		LabelValueBean lvBean = null;
		Iterator itor = labelValueMap.keySet().iterator();
		while (itor.hasNext()) {
			lvBean = new LabelValueBean();
			String id = (String) itor.next();
			String label = (String) labelValueMap.get(id);
			lvBean.setLabel(label);
			lvBean.setValue(id);
			lvBeans.add(lvBean);
		}

		return lvBeans;
	}

	*//**
	 * 初始化收费类型 (status：SO/BILL_TYPE)
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getBillTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("SO", "BILL_TYPE");
		return list;
	}

	*//**
	 * 预约标志 (status：SO/BOOK_FLAG)
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getBookFlaglvBean() throws SysException, AppException {
		List list = getStatuslvBean("SO", "BOOK_FLAG");
		return list;
	}

	*//**
	 * 业务状态 (status：WO/BUSI_STS)
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getBusiStslvBean() throws SysException, AppException {
		List list = getStatuslvBean("WO", "BUSI_STS");
		return list;
	}

	*//**
	 * 订单状态 (status：SO/BUSI_STS) 定单状态 SO_STS C1 A 就绪，指定单已经解析完成 W 等待选择流程，定单模板配置为人工选择流程 M 模版匹配失败 D
	 * 等待启动流程 E 启动流程失败 P 正常处理中，指流程已经启动运行 S 缓装，客户通过CRM发起或施工岗位主动同客户联系，客户要求缓装 U 转客户联系，预留 Y 待装，无资源待装 V
	 * 外勘 G 改单锁定，在CRM询问是否可以改单，服务开通确认可以进行改单时将定单锁定 H 撤单锁定，在CRM询问是否可以撤单，服务开通确认可以进行撤单时将定单锁定 K
	 * 等待撤改单，指失败回单时失败原因对应的回退点是CRM，目前已经通知CRM对该定单进行撤单或改单 g 改单处理中 h 撤单处理中 F 退单处理中，指异常流程的回退点在服务开通内部 I
	 * 割接处理中，预留 C 竣工，指定单已经处理完成 R 作废，预留
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getSoStslvBean() throws SysException, AppException {
		List list = getStatuslvBean("SO", "SO_STS");
		return list;
	}

	*//**
	 * 定单种类 (status：SO/SO_TYPE)
	 * 
	 * 0 正常单 1 注销单 2 修正单 3 缓装单 4 复装单
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getSoTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("SO", "SO_TYPE");
		return list;
	}

	*//**
	 * 受理方式 (status：SO/SO_METH)
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getSoMethlvBean() throws SysException, AppException {
		List list = getStatuslvBean("SO", "SO_METH");
		return list;

	}

	*//**
	 * 初始化异常特征下拉列表(status：FAIL_REASON/EXP_CODE)
	 * 
	 * @return ronghengen
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getExpCodelvBean() throws SysException, AppException {
		List list = getStatuslvBean("FAIL_REASON", "EXP_CODE");
		return list;
	}

	*//**
	 * 初始化工作区类型下拉列表(从缓存取)
	 * 
	 * @return
	 * @throws SysException
	 *//*
	public static List getWorkTypelvBean() throws SysException {

		List list = new ArrayList();
		// Map workTypeCache = (Map) DataCache.get(DataCache.WORKTYPE);
		Map workTypeCache = new HashMap();
		try {
			workTypeCache = DataCache.getCache(DataCache.WORKTYPE);
		} catch (DataCacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list = getlvBean(workTypeCache);
		return list;
	}

	*//**
	 * 工区类型(status：WORK_TYPE/TYPE)
	 * 
	 * 获取工区类型只中的TYPE C 定单类型 W 工单类型
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getTypelvBean() throws SysException, AppException {

		List list = getStatuslvBean("WORK_TYPE", "TYPE");
		return list;
	}

	*//**
	 * 施工环节模块(status：STEP/ACT_TYPE)
	 * 
	 * 动作类型 ACT_TYPE A 装 R 拆
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getActTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "ACT_TYPE");
		return list;
	}

	*//**
	 * 施工环节模块(status：STEP/PLUS_TYPE)
	 * 
	 * 游离类型 PLUS_TYPE E 外勘W 待装
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getPlusTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "PLUS_TYPE");
		return list;
	}

	*//**
	 * 施工环节模块(status：STEP/STEP_TYPE)
	 * 
	 * 环节类型 STEP_TYPE
	 * 
	 * RA 资源配置 SA 服务激活 SC 系统活动 SD 服务设计 SO 受理 SP 服务配置
	 * 
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getStepTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "STEP_TYPE");
		return list;
	}

	*//**
	 * 施工环节模块(status：STEP/WORK_MODE)
	 * 
	 * 施工方式 WORK_MODE A 自动施工 M 人工施工
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getWorkModelvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "WORK_MODE");
		return list;
	}

	*//**
	 * 施工环节模块(status：STEP/WORK_SYSTEM)
	 * 
	 * 作业系统 WORK_SYSTEM SPS 服务开通系统 CRM 综合客服系统 RMS 资源管理系统 NAS 网络激活系统
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getWorkSystemlvBean() throws SysException, AppException {

		List list = getStatuslvBean("STEP", "WORK_SYSTEM");
		return list;
	}

	*//**
	 * 回退标志(status：STEP/BACK_FLAG)
	 * 
	 * Y 必须回退 N无须回退
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getBacklvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "BACK_FLAG");
		return list;
	}

	*//**
	 * 撤改标志 (status：STEP/CANCEL_FLAG)
	 * 
	 * 0 容许 1 拒绝
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getCancelFlaglvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "CANCEL_FLAG");
		return list;
	}

	*//**
	 * 回笼标志 (status：STEP/RETURN_FLAG)
	 * 
	 * Y 必须回单 N无须回单
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getReturnFlaglvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "RETURN_FLAG");
		return list;
	}

	*//**
	 * 游离标志 0 正常环节 1 游离环节(status：STEP/PLUS_FLAG)
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getPlusFlaglvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "PLUS_FLAG");
		return list;
	}

	*//**
	 * 过程类型(status：STEP/PROCESS_TYPE)
	 * 
	 * F-开通类 A-保障类
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getProcessTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "PROCESS_TYPE");
		return list;
	}

	*//**
	 * 事件调用 EVENT_AUTO_CALL C1 Y 有 N 无(status：STEP/PROCESS_TYPE)
	 * 
	 * @return list
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getEventAutoCalllvBean() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "EVENT_AUTO_CALL");
		return list;
	}

	*//**
	 * 根据本地网和服务区获取协同规则业务名称
	 * 
	 * @param localNetId
	 * @param areaId
	 * @return
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static List getCollabRuleBusiName(String localNetId, String areaId) throws AppException,
			SysException {
		if (StringUtil.isBlank(localNetId)) {
			throw new AppException("", "获取协同规则业务名称时，缺少本地网参数！");
		}
		if (StringUtil.isBlank(areaId)) {
			throw new AppException("", "获取协同规则业务名称时，缺少服务区参数！");
		}
		localNetId = localNetId.trim();
		areaId = areaId.trim();

		CollabRuleBusiMVO vo = new CollabRuleBusiMVO();
		vo.setLocalNetId(localNetId);
		vo.setAreaId(areaId);
		vo.setSts(SysConstants.USE_YES_STS);// 在用状态
		Map busiMap = new HashMap();
		try {
			ConnectionFactory.createConnection();
			ICollabRuleBusiMDAO dao = (ICollabRuleBusiMDAO) DAOFactory
					.getDAO(ICollabRuleBusiMDAO.class);
			List list = dao.findByVO(vo);

			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					vo = (CollabRuleBusiMVO) list.get(i);
					busiMap.put(vo.getName(), vo.getName());
				}
			}
		} finally {
			ConnectionFactory.closeConnection();
		}
		return getlvBean(busiMap);
	}

	*//**
	 * 根据协同规则编码初始化产品下拉列表方法
	 * 
	 * @param
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getProdNamelvBean(String collabRuleId) throws SysException, AppException {
		if (StringUtil.isBlank(collabRuleId)) {
			throw new AppException("", "获取服务区时，缺少本地网参数！");
		}
		collabRuleId = collabRuleId.trim();

		CollabRuleBusiMVO vo = new CollabRuleBusiMVO();
		vo.setCollabRuleId(collabRuleId);
		vo.setSts(SysConstants.USE_YES_STS);
		Map busiMap = new HashMap();
		try {
			ConnectionFactory.createConnection();
			ICollabRuleBusiMDAO dao = (ICollabRuleBusiMDAO) DAOFactory
					.getDAO(ICollabRuleBusiMDAO.class);
			List list = dao.find(vo);

			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					vo = (CollabRuleBusiMVO) list.get(i);
					busiMap.put(vo.getProdId(), vo.getProdName());
				}
			}
		} finally {
			ConnectionFactory.closeConnection();
		}
		return getlvBean(busiMap);
	}

	*//**
	 * 根据协同规则编码初始化产品下拉列表方法
	 * 
	 * @param
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getChgServSpecNamelvBean(String collabRuleId) throws SysException,
			AppException {
		if (StringUtil.isBlank(collabRuleId)) {
			throw new AppException("", "获取服务区时，缺少本地网参数！");
		}
		collabRuleId = collabRuleId.trim();

		CollabRuleBusiMVO vo = new CollabRuleBusiMVO();
		vo.setCollabRuleId(collabRuleId);
		vo.setSts(SysConstants.USE_YES_STS);
		Map busiMap = new HashMap();
		try {
			ConnectionFactory.createConnection();
			ICollabRuleBusiMDAO dao = (ICollabRuleBusiMDAO) DAOFactory
					.getDAO(ICollabRuleBusiMDAO.class);
			List list = dao.find(vo);

			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					vo = (CollabRuleBusiMVO) list.get(i);
					busiMap.put(vo.getChgServSpecId(), vo.getChgServSpecName());
				}
			}
		} finally {
			ConnectionFactory.closeConnection();
		}
		return getlvBean(busiMap);
	}

	*//**
	 * 订单预约修改原因
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List changeReasonlvBean() throws SysException, AppException {
		List list = getStatuslvBean("SO_BOOK", "CHANGE_REASON");
		return list;
	}

	*//**
	 * 获取环节类型
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getStepTypeList() throws SysException, AppException {
		List list = getStatuslvBean("STEP", "STEP_TYPE");
		return list;
	}

	*//**
	 * 通过环节类型获取环节
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getStepByStepType(String stepType) throws SysException, AppException {
		if (StringUtil.isBlank(stepType)) {
			throw new AppException("", "获取环节时，缺少环节类型参数！");
		}
		stepType = stepType.trim();

		List steps = new ArrayList();

		Map stepTypeTree = new HashMap();
		try {
			stepTypeTree = DataCache.getCache(DataCache.STEP_TYPE_T);
		} catch (DataCacheException e) {
			e.printStackTrace();
		}
		if (stepTypeTree == null)
			stepTypeTree = new HashMap();
		Object obj = stepTypeTree.get(stepType);
		if (obj == null)
			return new ArrayList();
		Map stepMap = (Map) obj;
		steps = getlvBean(stepMap);
		return steps;
	}

	*//**
	 * 根据环节得到相应的环节类型
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static String getStepTypebyStep(String stepId) throws SysException, AppException {
		if (StringUtil.isBlank(stepId)) {
			throw new AppException("", "获取环节时，缺少环节类型参数！");
		}
		stepId = stepId.trim();
		StepSVO vo = new StepSVO();
		vo.setStepId(stepId);
		try {
			ConnectionFactory.createConnection();
			IStepSDAO dao = (IStepSDAO) DAOFactory.getDAO(IStepSDAO.class);
			StepSVO voRes = (StepSVO) dao.findByPK(vo);
			String stepType = null;
			if (voRes != null) {
				stepType = voRes.getStepType();
			}
			return stepType;
		} finally {
			ConnectionFactory.closeConnection();
		}

	}

	public static List getMaintArealvBean(String workAreaId) throws AppException, SysException {
		if (StringUtil.isBlank(workAreaId))
			throw new AppException("", "缺少工区ID");
		workAreaId = workAreaId.trim();
		Map map = new HashMap();
		try {
			ConnectionFactory.createConnection();
			IMaintAreaMDAO dao = (IMaintAreaMDAO) DAOFactory.getDAO(IMaintAreaMDAO.class);
			List list = dao.findByWorkAreaId(workAreaId);

			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					MaintAreaSVO vo = (MaintAreaSVO) list.get(i);
					map.put(vo.getMaintAreaId(), vo.getName());
				}
			}

		} finally {
			ConnectionFactory.closeConnection();
		}
		return getlvBean(map);
	}

	*//**
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getSoMatchStslvBean() throws SysException, AppException {
		List list = getStatuslvBean("SO_MATCH", "STS");
		return list;
	}

	*//**
	 * 根据本地网查找服务区
	 * 
	 * @param request
	 * @param localNetId
	 * @return
	 * @throws SysException
	 * @throws AppException
	 

	public static List getArealvBean(HttpServletRequest request, String localNetId)
			throws SysException, AppException {
		if (StringUtil.isBlank(localNetId)) {
			throw new AppException("", "获取服务区时，缺少本地网参数！");
		}
		localNetId = localNetId.trim();

		List areas = new ArrayList();
		Map localNetTree = new HashMap();
		try {
			localNetTree = DataCache.getCache(DataCache.LOCALNET_T);
		} catch (DataCacheException e) {
			e.printStackTrace();
		}
		if (localNetTree == null)
			localNetTree = new HashMap();
		Object obj = localNetTree.get(localNetId);
		if (obj == null)
			return new ArrayList();
		Map areaMap = (Map) obj;
		areas = getlvBean(areaMap);

		return areas;
	}
*//*
	public static List getWorkArealvBean(String areaId) throws SysException, AppException {
		if (StringUtil.isBlank(areaId)) {
			throw new AppException("", "获取工作区时，缺少服务区参数！");
		}
		areaId = areaId.trim();
		Map map = new HashMap();
		try {
			ConnectionFactory.createConnection();
			IWorkAreaSDAO dao = (IWorkAreaSDAO) DAOFactory.getDAO(IWorkAreaSDAO.class);
			WorkAreaSVO vo = new WorkAreaSVO();
			vo.setAreaId(areaId);
			vo.setSts(SysConstants.USE_YES_STS);
			List list = dao.findByVO(vo);

			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					vo = (WorkAreaSVO) list.get(i);
					map.put(vo.getWorkAreaId(), vo.getName());
				}
			}

		} finally {
			ConnectionFactory.closeConnection();
		}
		return getlvBean(map);
	}
	//加了数据权限控制的获取本地网下拉框
	public static List getLocalNets(HttpServletRequest req)
			throws SysException,AppException {
		List localNetlvBean = null;
		try{
			SysUserExtendedMVO suve = (SysUserExtendedMVO) req.getSession().getAttribute(
					SysUserExtendedMVO.SESSION_NAME);
			String staffId = suve.getStaffExtendMVO().getStaffSVO().getStaffId();
			ConnectionFactory.createConnection();
			ILocalNetSDAO dao = (ILocalNetSDAO) DAOFactory.getDAO(ILocalNetSDAO.class);
			LocalNetSVO vo1 = new LocalNetSVO();
		    List localnets = dao.findByVO(vo1,staffId);
		    
		    localNetlvBean = new ArrayList();
			LabelValueBean lvBean = null;
			for (int i = 0; i < localnets.size(); i++) {
				LocalNetSVO vo = (LocalNetSVO) localnets.get(i);
				lvBean = new LabelValueBean();
				lvBean.setLabel(vo.getName());
				lvBean.setValue(vo.getLocalNetId());
				localNetlvBean.add(lvBean);
			}
		}finally{
			ConnectionFactory.closeConnection();
		}
		return localNetlvBean;
	}
	//	加了数据权限控制的获取服务区下拉框
	public static List getArealvBean(HttpServletRequest req,String localnetid)
			throws SysException,AppException {
		List arealvBean = null;
		try{
			SysUserExtendedMVO suve = (SysUserExtendedMVO) req.getSession().getAttribute(
					SysUserExtendedMVO.SESSION_NAME);
			String staffId = suve.getStaffExtendMVO().getStaffSVO().getStaffId();
			ConnectionFactory.createConnection();
			IAreaSDAO dao = (IAreaSDAO) DAOFactory.getDAO(IAreaSDAO.class);
			AreaSVO vo1 = new AreaSVO();
		    List areas = dao.findByVO(vo1,staffId,localnetid);
		    
		    arealvBean = new ArrayList();
			LabelValueBean lvBean = null;
			for (int i = 0; i < areas.size(); i++) {
				AreaSVO vo = (AreaSVO) areas.get(i);
				lvBean = new LabelValueBean();
				lvBean.setLabel(vo.getName());
				lvBean.setValue(vo.getAreaId());
				arealvBean.add(lvBean);
			}
		}finally{
			ConnectionFactory.closeConnection();
		}
		return arealvBean;
	}
	
//	加了数据权限控制的获取服务区下拉框
	public static List getArealvBean(String localnetid)
			throws SysException,AppException {
		
		return null;
	}
}
*/