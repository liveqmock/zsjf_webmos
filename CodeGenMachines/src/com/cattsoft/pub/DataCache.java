/*package com.cattsoft.pub;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.cattsoft.pm.component.dao.IChgServSpecSDAO;
import com.cattsoft.pm.component.dao.IProdCatalogSDAO;
import com.cattsoft.pm.component.dao.IProdSDAO;
import com.cattsoft.pm.vo.ChgServSpecSVO;
import com.cattsoft.pm.vo.ProdCatalogSVO;
import com.cattsoft.pm.vo.ProdSVO;
import com.cattsoft.pub.dao.ConnectionFactory;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.sm.component.dao.IAreaSDAO;
import com.cattsoft.sm.component.dao.IExchSDAO;
import com.cattsoft.sm.component.dao.ILocalNetSDAO;
import com.cattsoft.sm.component.dao.IStatusSDAO;
import com.cattsoft.sm.component.dao.ISysConfigSDAO;
import com.cattsoft.sm.vo.AreaSVO;
import com.cattsoft.sm.vo.ExchSVO;
import com.cattsoft.sm.vo.LocalNetSVO;
import com.cattsoft.sm.vo.StatusSVO;
import com.cattsoft.sm.vo.SysConfigSVO;
import com.cattsoft.sp.component.dao.IGroupTypeSDAO;
import com.cattsoft.sp.component.dao.IStepSDAO;
import com.cattsoft.sp.component.dao.IWorkAreaSDAO;
import com.cattsoft.sp.component.dao.IWorkTypeSDAO;
import com.cattsoft.sp.vo.GroupTypeSVO;
import com.cattsoft.sp.vo.StepSVO;
import com.cattsoft.sp.vo.WorkAreaSVO;
import com.cattsoft.sp.vo.WorkTypeSVO;
import com.cattsoft.tm.component.dao.ITabColumnSDAO;
import com.cattsoft.tm.component.dao.IWoHandleCustomSDAO;
import com.cattsoft.tm.vo.TabColumnSVO;
import com.cattsoft.tm.vo.WoHandleCustomSVO;

public class DataCache {

	private static final Logger log = Logger.getLogger(DataCache.class);

	private static Class clazz = DataCache.class;

	 用来缓存的HashMap变量名 
	public static final String AREA = "area";

	public static final String SYSCONFIG = "sysConfig";

	public static final String REGION = "region";

	public static final String PRODSPECCAT = "prodSpecCat";

	public static final String PRODUCT = "product";

	public static final String CHANGESERVSPEC = "changeServSpec";

	public static final String LOCALNET = "localNet";

	public static final String WORKAREA = "workArea";

	public static final String EXCH = "exch";

	public static final String STEP = "step";

	public static final String STATUS = "status";
	
	public static final String GUOUPTYPE = "groupType";
	
	public static final String WORKTYPE = "workType";

	public static final String STATUS_SPLIT_WORD = "||";

	public static final String STATUS_SPLIT_WORD_REGEXP = "\\u007C";

	 用来缓存的HashMap变量定义 
	private static HashMap area = new HashMap();

	private static HashMap sysConfig = new HashMap();

	private static HashMap region = new HashMap();

	private static HashMap product = new HashMap();

	private static HashMap changeServSpec = new HashMap();

	private static HashMap localNet = new HashMap();

	private static HashMap workArea = new HashMap();

	private static HashMap exch = new HashMap();

	private static HashMap prodSpecCat = new HashMap();

	private static HashMap step = new HashMap();

	private static HashMap status = new HashMap();
	
	private static HashMap groupType = new HashMap();
	
	private static HashMap workType = new HashMap();
		

	*//**
	 * 取一个cache对象
	 * 
	 * @param cacheObj
	 *            String 目标cache
	 * @throws DataCacheException
	 * @return HashMap
	 * @throws SysException
	 *//*
	public static HashMap get(String cacheObj) throws SysException {

		LogUtil.debug(log, "查找缓存对象(" + cacheObj + ")");
		
		HashMap objHash = null;
		try {
			Field field = clazz.getDeclaredField(cacheObj);
			
			objHash = (HashMap) field.get(null);
		} catch (Exception ex) {
			if (log.isDebugEnabled()) {
				log.debug("The cache Object[" + cacheObj + "] is not exist");
			}
			LogUtil.debug(log, "系统缓存中找不到指定的对象[" + cacheObj + "]");
			throw new SysException("", "", ex);
		}
		if (log.isDebugEnabled()) {
			log.debug("end DataCache.get()");
		}
		
		return hashClone(objHash);
	}

	*//**
	 * Clone一个HashMap
	 * 
	 * @param hash
	 *            HashMap
	 * @throws DataCacheException
	 * @return HashMap
	 * @throws SysException
	 *//*
	private static HashMap hashClone(HashMap hash) throws SysException {
		LogUtil.debug(log, "克隆对象对象[" + hash + "]");
		if (hash == null) {
			return null;
		}
		HashMap ret = new HashMap();
		Iterator ite = hash.keySet().iterator();
		Object key = null, keyObj = null;
		Object value = null, valueObj = null;
		try {
			while (ite.hasNext()) {
				key = ite.next();

				value = hash.get(key);
				if (key.getClass().getName().startsWith("java")) {
					keyObj = key;
				} else {
					try {
						keyObj = key.getClass().newInstance();
						PropertyUtils.copyProperties(keyObj, key);
					} catch (Exception ex) {
						keyObj = key;
					}
				}

				if (value.getClass().getName().startsWith("java")) {
					valueObj = value;
				} else {
					try {
						valueObj = value.getClass().newInstance();
						PropertyUtils.copyProperties(valueObj, value);
					} catch (Exception ex) {
						valueObj = value;
					}
				}
				ret.put(keyObj, valueObj);
			}
		} catch (Exception ex) {
			throw new SysException("", "", ex);
		}
		return ret;
	}

	 initial method 
	public static void initSysConfig() throws AppException, SysException {
		LogUtil.debug(log, "初始化sysConfig缓存..");
		sysConfig.clear();
		SysConfigSVO vo = new SysConfigSVO();
		vo.setConfigType(SysConstants.SYS_CONFIG_TYPE_PROVINCE);// 取全省统一的配置

		ISysConfigSDAO dao = (ISysConfigSDAO) DAOFactory.getDAO(ISysConfigSDAO.class);
		List list = dao.findByVO(vo);

		for (int i = 0; i < list.size(); i++) {
			vo = (SysConfigSVO) list.get(i);
			sysConfig.put(vo.getConfigId(), vo);
		}

	}

	 initial method 
	public static void initProduct() throws AppException, SysException { // throws
		LogUtil.debug(log, "初始化product缓存..");
		product.clear();
		ProdSVO vo = new ProdSVO();
		vo.setSts(SysConstants.USE_YES_STS);// 在用状态

		IProdSDAO dao = (IProdSDAO) DAOFactory.getDAO(IProdSDAO.class);
		List list = dao.findByVO(vo);

		for (int i = 0; i < list.size(); i++) {
			vo = (ProdSVO) list.get(i);
			product.put(vo.getProdId(), vo.getName());
		}

	}

	*//**
	 * 初始化本地网
	 * 
	 * @throws DataCacheException
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static void initLocalNet() throws AppException, SysException {
		LogUtil.debug(log, "初始化localNet缓存..");
		localNet.clear();
		LocalNetSVO vo = new LocalNetSVO();
		vo.setSts(SysConstants.USE_YES_STS);// 在用状态

		ILocalNetSDAO dao = (ILocalNetSDAO) DAOFactory.getDAO(ILocalNetSDAO.class);
		List list = dao.findByVO(vo);

		for (int i = 0; i < list.size(); i++) {
			vo = (LocalNetSVO) list.get(i);
			localNet.put(vo.getLocalNetId(), vo.getName());
		}

	}

	*//**
	 * 初始化服务区
	 * 
	 * Map<localNetId,Map<areaId,areaName>>
	 * 
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static void initArea() throws AppException, SysException {
		LogUtil.debug(log, "初始化area缓存..");
		area.clear();
		AreaSVO vo = new AreaSVO();
		vo.setSts(SysConstants.USE_YES_STS);// 在用状态

		IAreaSDAO dao = (IAreaSDAO) DAOFactory.getDAO(IAreaSDAO.class);
		List list = dao.findByVO(vo);

		Map areaMap = null;
		for (int i = 0; i < list.size(); i++) {
			vo = (AreaSVO) list.get(i);
			Object obj = area.get(vo.getLocalNetId());
			if (obj == null) {
				areaMap = new HashMap();
				area.put(vo.getLocalNetId(), areaMap);
			} else {
				areaMap = (Map) obj;
			}
			areaMap.put(vo.getAreaId(), vo.getName());
		}

	}

	*//**
	 * 初始化局向
	 * 
	 * Map<localNetId+areaId,Map<exchId,exchName>>
	 * 
	 * @throws DataCacheException
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static void initExch() throws AppException, SysException {
		LogUtil.debug(log, "初始化exch缓存..");
		exch.clear();
		ExchSVO vo = new ExchSVO();
		vo.setSts(SysConstants.USE_YES_STS);// 在用状态

		IExchSDAO dao = (IExchSDAO) DAOFactory.getDAO(IExchSDAO.class);
		List list = dao.findByVO(vo);

		Map exchMap = null;
		for (int i = 0; i < list.size(); i++) {
			vo = (ExchSVO) list.get(i);
			Object obj = exch.get(vo.getLocalNetId() + vo.getAreaId());
			if (obj == null) {
				exchMap = new HashMap();
				exch.put(vo.getLocalNetId() + vo.getAreaId(), exchMap);
			} else {
				exchMap = (Map) obj;
			}
			exchMap.put(vo.getExchId(), vo.getName());
		}

	}

	*//**
	 * 初始化环节
	 * 
	 * Map<stepId,stepName>
	 * 
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static void initStep() throws AppException, SysException {
		LogUtil.debug(log, "初始化step缓存..");
		step.clear();
		StepSVO vo = new StepSVO();
		vo.setSts(SysConstants.USE_YES_STS);// 在用状态

		IStepSDAO dao = (IStepSDAO) DAOFactory.getDAO(IStepSDAO.class);
		List list = dao.findByVO(vo);

		for (int i = 0; i < list.size(); i++) {
			vo = (StepSVO) list.get(i);
			step.put(vo.getStepId(), vo.getName());
		}

	}

	 initial all 
	public static void initial() throws AppException, SysException {

		try {
			ConnectionFactory.createConnection();
			initSysConfig();
			initProduct();
			initLocalNet();
			initArea();
			initStep();
			initStatus();
			initExch();
			initWorkArea();
			
			initChangeServSpec();
			initProdSpecCat();
			initGroupType();
			initWorkType();
		} catch (Exception e) {
			throw new SysException("", "缓存初始化异常！", e);
		} finally {
			ConnectionFactory.closeConnection();
		}
	}

	*//**
	 * 初始化status表,组装成Map<tableName||columnName,Map<stsId,stsWord>>
	 * 
	 * @throws DataCacheException
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static void initStatus() throws AppException, SysException {
		LogUtil.debug(log, "初始化status缓存..");
		status.clear();
		StatusSVO vo = new StatusSVO();
		IStatusSDAO dao = (IStatusSDAO) DAOFactory.getDAO(IStatusSDAO.class);
		List list = dao.findByVO(vo);
		for (int i = 0; i < list.size(); i++) {
			vo = (StatusSVO) list.get(i);
			String key = vo.getTableName().trim() + STATUS_SPLIT_WORD + vo.getColumnName().trim();
			Map valueMap = null;
			Object statusValue = status.get(key);
			if (null == status.get(key)) {
				valueMap = new HashMap();
				status.put(key, valueMap);
			} else {
				valueMap = (Map) statusValue;
			}
			valueMap.put(vo.getStsId().trim(), vo.getStsWords().trim());
		}

	}
	
	
	*//**
	 * 初始化workArea下拉列表 
	 * @author ronghengen
	 * @throws AppException
	 * @throws SysException
	 *//*
	public static void initWorkArea() throws AppException,SysException{
		
		LogUtil.debug(log, "初始化workArea缓存..");		
		workArea.clear();
		WorkAreaSVO vo = new WorkAreaSVO();		

		IWorkAreaSDAO dao = (IWorkAreaSDAO) DAOFactory.getDAO(IWorkAreaSDAO.class);
		List list = dao.findByVO(vo);
		
		for (int i = 0; i < list.size(); i++) {
			vo = (WorkAreaSVO) list.get(i);
			workArea.put(vo.getWorkAreaId(), vo.getName());
		}
		
	}
	
	*//**
	 * @throws SysException 
	 * @throws AppException 
	 * 
	 *//*
	public static void initChangeServSpec() throws AppException, SysException{
		
		LogUtil.debug(log, "初始化servSpec缓存..");
		changeServSpec.clear();
		ChgServSpecSVO vo = new ChgServSpecSVO();		

		IChgServSpecSDAO dao = (IChgServSpecSDAO) DAOFactory.getDAO(IChgServSpecSDAO.class);
		List list = dao.findByVO(vo);
		
		for (int i = 0; i < list.size(); i++) {
			vo = (ChgServSpecSVO) list.get(i);
			changeServSpec.put(vo.getChgServSpecId(), vo.getName());
		}
	}
	
	
	public static void initProdSpecCat() throws AppException,SysException{
		LogUtil.debug(log, "初始化prodSpecCat缓存..");
		prodSpecCat.clear();
		ProdCatalogSVO vo = new ProdCatalogSVO();

		IProdCatalogSDAO dao = (IProdCatalogSDAO) DAOFactory.getDAO(IProdCatalogSDAO.class);
		List list = dao.findByVO(vo);
		
		for (int i = 0; i < list.size(); i++) {
			vo = (ProdCatalogSVO) list.get(i);
			prodSpecCat.put(vo.getProdCatalogId(), vo.getName());
		}
	}
	
	public static void initGroupType() throws AppException,SysException{
		
		LogUtil.debug(log, "初始化groupType缓存..");
		groupType.clear();
		GroupTypeSVO vo = new GroupTypeSVO();

		IGroupTypeSDAO dao = (IGroupTypeSDAO) DAOFactory.getDAO(IGroupTypeSDAO.class);
		List list = dao.findByVO(vo);

		for (int i = 0; i < list.size(); i++) {
			vo = (GroupTypeSVO) list.get(i);
			groupType.put(vo.getGroupTypeId(), vo.getName());
		}
	}
	
	public static void initWorkType() throws AppException,SysException{
		
		LogUtil.debug(log, "初始化workType缓存..");
		workType.clear();
		WorkTypeSVO vo = new WorkTypeSVO();

		IWorkTypeSDAO dao = (IWorkTypeSDAO) DAOFactory.getDAO(IWorkTypeSDAO.class);
		List list = dao.findByVO(vo);
		
		for (int i = 0; i < list.size(); i++) {
			vo = (WorkTypeSVO) list.get(i);
			workType.put(vo.getWorkTypeId(), vo.getName());
		}
	}
	

}
*/