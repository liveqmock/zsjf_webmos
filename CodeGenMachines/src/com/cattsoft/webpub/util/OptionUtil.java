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
 * Title: CRMϵͳ<br>
 * Description:���������б��ʼ���ķ��� <br>
 * Date: 2007-6-6 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 *//*
public class OptionUtil {
	private static final Logger log = Logger.getLogger(OptionUtil.class);

	*//**
	 * �õ��û��ɷ��ʵı������б�
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
	 * �����������б��ʼ������ List<LabelValueBean>
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
			LogUtil.debug(log, "��ȡ����ʱ����");
		}
		return localNets;
	}

	*//**
	 * ���ݱ��������з����������б��ʼ������
	 * 
	 * @param
	 * @return
	 * @throws SysException
	 * @throws AppException
	 
	public static List getArealvBean(String localNetId) throws SysException, AppException {
		if (StringUtil.isBlank(localNetId)) {
			throw new AppException("", "��ȡ������ʱ��ȱ�ٱ�����������");
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
	 * ��ʼ�����������б�
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
			LogUtil.debug(log, "��ȡ����ʱ����");
		}
		return list;
	}

	*//**
	 * ��ʼ�����������б�
	 * 
	 * @author ronghengen
	 *//*
	public static List getExchlvBean(String localNetId, String areaId) throws AppException,
			SysException {
		if (StringUtil.isBlank(localNetId)) {
			throw new AppException("", "��ȡ����ʱ��ȱ�ٱ�����������");
		}
		if (StringUtil.isBlank(areaId)) {
			throw new AppException("", "��ȡ����ʱ��ȱ�ٷ�����������");
		}
		localNetId = localNetId.trim();
		areaId = areaId.trim();

		Map localNetTree = new HashMap();
		Map exchMap = new HashMap();
		try {
			localNetTree = DataCache.getCache(DataCache.LOCALNET_AREA_EXCH);// ��ȡ������
			// LogUtil.debug(log, localNetTree.size()+"");
		} catch (DataCacheException e) {
			e.printStackTrace();
		}
		Object obj = localNetTree.get(localNetId);// ��ȡ������������
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
			exchMap = (Map) localNetMap.get(areaId); // ��ȡ����
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
	 * �����������б�(����ȡ)
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
	 * @return �õ����������б��ӱ�ȡ��
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
	 * ���ӱ�ȡ��
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
	 * ��ʼ��TABҳ�����б�
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
	 * ��ʼ���������������б�
	 *//*
	public static List getWoTypelvBean() throws SysException, AppException {
		List list = getStatuslvBean("WO", "WO_TYPE");
		return list;
	}

	*//**
	 * ��ʼ�����ó��������б�status:CHK_RULE/FOR_SCENE��
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
	 * ��ʼ���������������б�status:CHK_RULE/RULE_TYPE��
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
	 * ��ʼ�����ر�־�����б�status:CHK_RULE/OPEN_FLAG��
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
	 * ��ʼ��״̬�����б�status:CHK_RULE/STS��
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
	 * Эͬ�������ģ���У�Эͬ���������б�status:COLLAB_RULE/COLLAB_LEVEL��
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
	 * Эͬ�������ģ���У��ͻ������б�(�ӻ���ȡ)
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
	 * ͨ����Ʒid��ȡ�������б�(�ӻ���ȡ)
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
	 * Эͬ�������ģ����,��Ʒ�����б�(�ӻ���ȡ)
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
	 * ��Ʒ�б��ӻ���ȡ��
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
	 * ���ݲ�Ʒ(��)������Ӧ�Ĳ�Ʒ����
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
	 * �ӿ����������б�(����)
	 * 
	 * @return yi
	 *//*
	public static List getInterNamelvBean() {
		List interName = new ArrayList();
		LabelValueBean lvBean = new LabelValueBean();
		lvBean = new LabelValueBean();
		lvBean.setLabel("����ӿ�");
		lvBean.setValue("CaiLingInter");
		interName.add(lvBean);
		lvBean = new LabelValueBean();
		lvBean.setLabel("���ƽӿ�");
		lvBean.setValue("DaTangInter");
		interName.add(lvBean);

		return interName;
	}

	*//**
	 * ��ʼ��ʵʱ��־�����б�status��INTER_CALL_CONFIG/REAL_TIME_FLAG��
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
	 * ��ʼ�����������б�status��INTER_CALL_CONFIG/DEAL_FLAG��
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
	 * ��ʼ������ϵͳ�����б�status��FAIL_REASON/SYSTEM_NAME��
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
	 * ��ʼ��ԭ�����������б�status��FAIL_REASON/DUTY_FLAG��
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
	 * ��ʼ��ԭ����������б�status��FAIL_REASON/REASON_CAT��
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
	 * ��ʼ��ͬ�˱�־ ��status��PROCESS_COLLAB_RULE/BACK_FLAG)
	 * 
	 * Yͬ�� N����
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
	 * ��ʼ���������� CALL_TYPE��status��PROCESS_COLLAB_RULE/CALL_TYPE)
	 * 
	 * J Java Class P �洢���� N �������
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
	 * ��ʼ��Эͬ���� ��status��PROCESS_COLLAB_RULE/COLLAB_TYPE)
	 * 
	 * S->S��ʼ��>��ʼ C->S ������>��ʼ C->C ������>���� SSCC ͬʱ��ʼ��ͬʱ����
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
	 * ��ʼ������������ ���ӻ���ȡ GROUP_TYPE��
	 * 
	 * 0������Ʒ������Ʒ��ϵ 1 ADSL����ͨ�绰ͬװ���ҹ��߹�ϵ 2 ģ���м̲�Ʒ������ϵ 3 DDN������ϵ 4 X25������ϵ 5 С��ͨ��̻�һ��˫����ϵ 6
	 * С��ͨ��̻���ͨ������ϵ 7 ʦ������У��AD�󶨹�ϵ 8 IPTV�����󶨹�ϵ 9 �绰δ����װAD 10��Ե���� ���ƻ�������ҵ����DDN������֮��Ĺ�����ϵ 11��Զ�����
	 * ���ƻ�������ҵ����DDN�Ķ��֮��Ĺ�����ϵ��һ��Ϊ���ĵ����˶Զ���Ӷ� 12�绰��ѡ �绰�ĺ�����ѡ��˿���ѡ��ϵ 13ADSL + LAN ��������LAN�û�֮��Ĺ�����ϵ
	 * 14ADSL + VPN ����ר�������û�֮��Ĺ�����ϵ 15ͬ�ͻ�������ϵ������һ��CO�¶��SO�������ָ��SO֮��Ĺ������ϵ����Ĭ�Ͻ�����Ϊͬʱ��ʼ��ϵ 16 ���� 17 �ĵ�
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
	 * ��ʼ����ҵ��־ ��status��PROCESS_COLLAB_RULE/MAIN_FLAG)
	 * 
	 * M ��ҵ�� S ��ҵ��
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
	 * ���ȼ� PRIORITY��status��PROCESS_COLLAB_RULE/PRIORITY)
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
	 * ��ʼ��ԭ�����������б�status��FAIL_REASON/EXP_CODE)
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
	 * ��ʼ���쳣ԭ�����������б�(�ӱ�ȡ)
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
	 * ��ʼ����˱�־�����б�status��STEP_FAIL_REASON/AUDIT_FLAG��
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
	 * ��ʼ���쳣�����־
	 *//*
	public static List getFailDoFlagLvBean() throws SysException, AppException {
		List collabLevels = getStatuslvBean("STEP_FAIL_REASON", "FAIL_DO_FLAG");
		return collabLevels;
	}

	*//**
	 * ��ʼ���ɷ���־ DISP_FLAG(status��STEP_COLLAB_RULE/DISP_FLAG)
	 * 
	 * Y�ɷ� N����
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
	 * �ϵ���־ MERG_FLAG C1(status��STEP_COLLAB_RULE/MERG_FLAG)
	 * 
	 * Y ��Ҫ�ϵ� N ����ϵ�
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
	 * ִ�з�ʽ(status��SO_TEMPLATE/EXEC_MODE)
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
	 * �������(status��SO_TEMPLATE/MATCH_OPERATOR)
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
	 * ������
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
	 * ����״̬
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
	 * ҵ��״̬
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
	 * ��������
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
	 * ����ָ�������ֶ�������status�����л�ȡ������Ϣ�б�
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
		// LogUtil.debug(log, "��ȡstatus������Ϣ��" + key);
		// Object obj = statusCache.get(key);
		// if (null == obj) {
		// throw new AppException("", "����status���ã��Ƿ����" + key + "��Ӧ��Ϣ!");
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
	 * ����map���LabelValueBean��list
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
	 * ��ʼ���շ����� (status��SO/BILL_TYPE)
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
	 * ԤԼ��־ (status��SO/BOOK_FLAG)
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
	 * ҵ��״̬ (status��WO/BUSI_STS)
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
	 * ����״̬ (status��SO/BUSI_STS) ����״̬ SO_STS C1 A ������ָ�����Ѿ�������� W �ȴ�ѡ�����̣�����ģ������Ϊ�˹�ѡ������ M ģ��ƥ��ʧ�� D
	 * �ȴ��������� E ��������ʧ�� P ���������У�ָ�����Ѿ��������� S ��װ���ͻ�ͨ��CRM�����ʩ����λ����ͬ�ͻ���ϵ���ͻ�Ҫ��װ U ת�ͻ���ϵ��Ԥ�� Y ��װ������Դ��װ V
	 * �⿱ G �ĵ���������CRMѯ���Ƿ���Ըĵ�������ͨȷ�Ͽ��Խ��иĵ�ʱ���������� H ������������CRMѯ���Ƿ���Գ���������ͨȷ�Ͽ��Խ��г���ʱ���������� K
	 * �ȴ����ĵ���ָʧ�ܻص�ʱʧ��ԭ���Ӧ�Ļ��˵���CRM��Ŀǰ�Ѿ�֪ͨCRM�Ըö������г�����ĵ� g �ĵ������� h ���������� F �˵������У�ָ�쳣���̵Ļ��˵��ڷ���ͨ�ڲ� I
	 * ��Ӵ����У�Ԥ�� C ������ָ�����Ѿ�������� R ���ϣ�Ԥ��
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
	 * �������� (status��SO/SO_TYPE)
	 * 
	 * 0 ������ 1 ע���� 2 ������ 3 ��װ�� 4 ��װ��
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
	 * ����ʽ (status��SO/SO_METH)
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
	 * ��ʼ���쳣���������б�(status��FAIL_REASON/EXP_CODE)
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
	 * ��ʼ�����������������б�(�ӻ���ȡ)
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
	 * ��������(status��WORK_TYPE/TYPE)
	 * 
	 * ��ȡ��������ֻ�е�TYPE C �������� W ��������
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
	 * ʩ������ģ��(status��STEP/ACT_TYPE)
	 * 
	 * �������� ACT_TYPE A װ R ��
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
	 * ʩ������ģ��(status��STEP/PLUS_TYPE)
	 * 
	 * �������� PLUS_TYPE E �⿱W ��װ
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
	 * ʩ������ģ��(status��STEP/STEP_TYPE)
	 * 
	 * �������� STEP_TYPE
	 * 
	 * RA ��Դ���� SA ���񼤻� SC ϵͳ� SD ������� SO ���� SP ��������
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
	 * ʩ������ģ��(status��STEP/WORK_MODE)
	 * 
	 * ʩ����ʽ WORK_MODE A �Զ�ʩ�� M �˹�ʩ��
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
	 * ʩ������ģ��(status��STEP/WORK_SYSTEM)
	 * 
	 * ��ҵϵͳ WORK_SYSTEM SPS ����ͨϵͳ CRM �ۺϿͷ�ϵͳ RMS ��Դ����ϵͳ NAS ���缤��ϵͳ
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
	 * ���˱�־(status��STEP/BACK_FLAG)
	 * 
	 * Y ������� N�������
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
	 * ���ı�־ (status��STEP/CANCEL_FLAG)
	 * 
	 * 0 ���� 1 �ܾ�
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
	 * ������־ (status��STEP/RETURN_FLAG)
	 * 
	 * Y ����ص� N����ص�
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
	 * �����־ 0 �������� 1 ���뻷��(status��STEP/PLUS_FLAG)
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
	 * ��������(status��STEP/PROCESS_TYPE)
	 * 
	 * F-��ͨ�� A-������
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
	 * �¼����� EVENT_AUTO_CALL C1 Y �� N ��(status��STEP/PROCESS_TYPE)
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
	 * ���ݱ������ͷ�������ȡЭͬ����ҵ������
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
			throw new AppException("", "��ȡЭͬ����ҵ������ʱ��ȱ�ٱ�����������");
		}
		if (StringUtil.isBlank(areaId)) {
			throw new AppException("", "��ȡЭͬ����ҵ������ʱ��ȱ�ٷ�����������");
		}
		localNetId = localNetId.trim();
		areaId = areaId.trim();

		CollabRuleBusiMVO vo = new CollabRuleBusiMVO();
		vo.setLocalNetId(localNetId);
		vo.setAreaId(areaId);
		vo.setSts(SysConstants.USE_YES_STS);// ����״̬
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
	 * ����Эͬ��������ʼ����Ʒ�����б���
	 * 
	 * @param
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getProdNamelvBean(String collabRuleId) throws SysException, AppException {
		if (StringUtil.isBlank(collabRuleId)) {
			throw new AppException("", "��ȡ������ʱ��ȱ�ٱ�����������");
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
	 * ����Эͬ��������ʼ����Ʒ�����б���
	 * 
	 * @param
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getChgServSpecNamelvBean(String collabRuleId) throws SysException,
			AppException {
		if (StringUtil.isBlank(collabRuleId)) {
			throw new AppException("", "��ȡ������ʱ��ȱ�ٱ�����������");
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
	 * ����ԤԼ�޸�ԭ��
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
	 * ��ȡ��������
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
	 * ͨ���������ͻ�ȡ����
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static List getStepByStepType(String stepType) throws SysException, AppException {
		if (StringUtil.isBlank(stepType)) {
			throw new AppException("", "��ȡ����ʱ��ȱ�ٻ������Ͳ�����");
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
	 * ���ݻ��ڵõ���Ӧ�Ļ�������
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 *//*
	public static String getStepTypebyStep(String stepId) throws SysException, AppException {
		if (StringUtil.isBlank(stepId)) {
			throw new AppException("", "��ȡ����ʱ��ȱ�ٻ������Ͳ�����");
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
			throw new AppException("", "ȱ�ٹ���ID");
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
	 * ���ݱ��������ҷ�����
	 * 
	 * @param request
	 * @param localNetId
	 * @return
	 * @throws SysException
	 * @throws AppException
	 

	public static List getArealvBean(HttpServletRequest request, String localNetId)
			throws SysException, AppException {
		if (StringUtil.isBlank(localNetId)) {
			throw new AppException("", "��ȡ������ʱ��ȱ�ٱ�����������");
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
			throw new AppException("", "��ȡ������ʱ��ȱ�ٷ�����������");
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
	//��������Ȩ�޿��ƵĻ�ȡ������������
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
	//	��������Ȩ�޿��ƵĻ�ȡ������������
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
	
//	��������Ȩ�޿��ƵĻ�ȡ������������
	public static List getArealvBean(String localnetid)
			throws SysException,AppException {
		
		return null;
	}
}
*/