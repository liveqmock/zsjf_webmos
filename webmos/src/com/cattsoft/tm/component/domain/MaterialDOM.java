package com.cattsoft.tm.component.domain;

import java.util.List;

import com.cattsoft.pub.MaxId;
import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.tm.component.dao.IChgServSpecMaterialMDAO;
import com.cattsoft.tm.component.dao.IMaterialBackFillSDAO;
import com.cattsoft.tm.component.dao.IMaterialSpecSDAO;
import com.cattsoft.tm.vo.ChgServSpecMaterialMVO;
import com.cattsoft.tm.vo.MaterialBackFillSVO;
import com.cattsoft.tm.vo.MaterialSpecSVO;

public class MaterialDOM {
    
	/**
	 * @param chgServSpecMaterialMVO
	 * @return
	 * @throws SysException
	 * @throws AppException
	 * 查询
	 */
	public List initMaterialTypeData4MOS(ChgServSpecMaterialMVO chgServSpecMaterialMVO) throws SysException, AppException{
		
		IChgServSpecMaterialMDAO chgServSpecMaterialMDAO = (IChgServSpecMaterialMDAO) DAOFactory.getDAO(IChgServSpecMaterialMDAO.class);
		List materialList;
		materialList = chgServSpecMaterialMDAO.findByMaterialVO(chgServSpecMaterialMVO);
		return materialList;
	}
	
	/**
	 * @param materialSpecSVO
	 * @return
	 * @throws SysException
	 * @throws AppException
	 * 查询
	 */
	public List findMaterialTypeData4MOS(MaterialSpecSVO materialSpecSVO) throws SysException, AppException{
		
		IMaterialSpecSDAO materialSpecSDAO = (IMaterialSpecSDAO) DAOFactory.getDAO(IMaterialSpecSDAO.class);
		List materialList;
		materialList = materialSpecSDAO.findByVO(materialSpecSVO);
		return materialList;
	}
	
	/**
	 * @param materialSpecSVO
	 * @return
	 * @throws SysException
	 * @throws AppException
	 * 查询
	 */
	public String queryWoCount4MOS(String workorder) throws SysException, AppException{
		
		IMaterialBackFillSDAO materialBackFillSDAO = (IMaterialBackFillSDAO) DAOFactory.getDAO(IMaterialBackFillSDAO.class);
		MaterialBackFillSVO materialBackFill =new MaterialBackFillSVO();
		if(!"".equals(workorder))
		{
			materialBackFill.setWoNbr(workorder);
		}
		
		List materialBackFillList= materialBackFillSDAO.findByVO(materialBackFill);
		String count = null;
		if(materialBackFillList==null){
			count="0";
		}
		else{
		   count = String.valueOf(materialBackFillList.size());
		}
		return count;
	}
	/**
	 * @param materialSVO
	 * @return
	 * @throws SysException
	 * @throws AppException
	 * 添加
	 */
	public void insertIntoMaterialData4MOS(List materialList,String flag) throws SysException, AppException{
	
		
		
		
		
		
		
		
		  MaterialBackFillSVO materialBackFillSVO;
		//加上主键和日期和类型
		  for(int i=0; i<materialList.size();i++){
			  materialBackFillSVO =(MaterialBackFillSVO)materialList.get(i);
			  materialBackFillSVO.setMaterialId(MaxId.getSequenceNextVal(SysConstants.MATERIAL_ID_SEQ));
			  materialBackFillSVO.setStsDate(DateUtil.getDBDate());
			  materialBackFillSVO.setBackFillType(flag);
			  materialBackFillSVO.setSts("A");
		  }
		IMaterialBackFillSDAO materialBackFillSDAO = (IMaterialBackFillSDAO) DAOFactory.getDAO(IMaterialBackFillSDAO.class);
		materialBackFillSDAO.addBat(materialList);
	}
	/**
	 * @param workorder
	 * @return
	 * @throws SysException
	 * @throws AppException
	 * 删除材料
	 */
	public void deleteAllMaterialByWo4MOS(String workorder) throws SysException, AppException{
	
		IMaterialBackFillSDAO materialBackFillSDAO = (IMaterialBackFillSDAO) DAOFactory.getDAO(IMaterialBackFillSDAO.class);
		//先删除表中该工单的记录，再插入
		 MaterialBackFillSVO materialBackFillSVO1 = new MaterialBackFillSVO();
		 materialBackFillSVO1.setWoNbr(workorder);
		  materialBackFillSDAO.delete(materialBackFillSVO1);
		  
	}
	
}
