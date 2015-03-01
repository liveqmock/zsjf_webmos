package com.cattsoft.tm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.tm.component.dao.ITRptQfrbQfrtbSDAO;import com.cattsoft.tm.vo.TRptQfrbQfrtbSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法TRptQfrbQfrtbSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class TRptQfrbQfrtbSDAOImpl implements ITRptQfrbQfrtbSDAO{    private static Logger log = Logger.getLogger(TRptQfrbQfrtbSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TRptQfrbQfrtbSVO tRptQfrbQfrtb=(TRptQfrbQfrtbSVO) vo;      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO T_RPT_QFRB_QFRTB(CREATE_DATE,G2_DYQFCZ,G2_DYQFHSL,G2_DYQFJE,G2_YQQF,G3_DYQFCZ,G3_DYQFHSL,G3_DYQFJE,G3_YQQF,G4_DYQFCZ,G4_DYQFHSL,G4_DYQFJE,G4_YQQF,GW_DYQFCZ,GW_DYQFHSL,GW_DYQFJE,GW_YQQF,OPEN_DATE,WG_CODE,WG_MC)");sql.append(" VALUES (:createDate,:g2Dyqfcz,:g2Dyqfhsl,:g2Dyqfje,:g2Yqqf,:g3Dyqfcz,:g3Dyqfhsl,:g3Dyqfje,:g3Yqqf,:g4Dyqfcz,:g4Dyqfhsl,:g4Dyqfje,:g4Yqqf,:gwDyqfcz,:gwDyqfhsl,:gwDyqfje,:gwYqqf,:openDate,:wgCode,:wgMc)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());   if (tRptQfrbQfrtb.getCreateDate() == null) {      sql.setNullDate("createDate");     } else {    sql.setTimestamp("createDate", tRptQfrbQfrtb.getCreateDate());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfcz())) {      sql.setNullLong("g2Dyqfcz");     } else {    sql.setLong("g2Dyqfcz", tRptQfrbQfrtb.getG2Dyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfhsl())) {      sql.setNullLong("g2Dyqfhsl");     } else {    sql.setLong("g2Dyqfhsl", tRptQfrbQfrtb.getG2Dyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfje())) {      sql.setNullLong("g2Dyqfje");     } else {    sql.setLong("g2Dyqfje", tRptQfrbQfrtb.getG2Dyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Yqqf())) {      sql.setNullLong("g2Yqqf");     } else {    sql.setLong("g2Yqqf", tRptQfrbQfrtb.getG2Yqqf());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfcz())) {      sql.setNullLong("g3Dyqfcz");     } else {    sql.setLong("g3Dyqfcz", tRptQfrbQfrtb.getG3Dyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfhsl())) {      sql.setNullLong("g3Dyqfhsl");     } else {    sql.setLong("g3Dyqfhsl", tRptQfrbQfrtb.getG3Dyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfje())) {      sql.setNullLong("g3Dyqfje");     } else {    sql.setLong("g3Dyqfje", tRptQfrbQfrtb.getG3Dyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Yqqf())) {      sql.setNullLong("g3Yqqf");     } else {    sql.setLong("g3Yqqf", tRptQfrbQfrtb.getG3Yqqf());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfcz())) {      sql.setNullLong("g4Dyqfcz");     } else {    sql.setLong("g4Dyqfcz", tRptQfrbQfrtb.getG4Dyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfhsl())) {      sql.setNullLong("g4Dyqfhsl");     } else {    sql.setLong("g4Dyqfhsl", tRptQfrbQfrtb.getG4Dyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfje())) {      sql.setNullLong("g4Dyqfje");     } else {    sql.setLong("g4Dyqfje", tRptQfrbQfrtb.getG4Dyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Yqqf())) {      sql.setNullLong("g4Yqqf");     } else {    sql.setLong("g4Yqqf", tRptQfrbQfrtb.getG4Yqqf());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfcz())) {      sql.setNullLong("gwDyqfcz");     } else {    sql.setLong("gwDyqfcz", tRptQfrbQfrtb.getGwDyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfhsl())) {      sql.setNullLong("gwDyqfhsl");     } else {    sql.setLong("gwDyqfhsl", tRptQfrbQfrtb.getGwDyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfje())) {      sql.setNullLong("gwDyqfje");     } else {    sql.setLong("gwDyqfje", tRptQfrbQfrtb.getGwDyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwYqqf())) {      sql.setNullLong("gwYqqf");     } else {    sql.setLong("gwYqqf", tRptQfrbQfrtb.getGwYqqf());    }    if (tRptQfrbQfrtb.getOpenDate() == null) {      sql.setNullDate("openDate");     } else {    sql.setTimestamp("openDate", tRptQfrbQfrtb.getOpenDate());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getWgCode())) {      sql.setNullString("wgCode");     } else {    sql.setString("wgCode", tRptQfrbQfrtb.getWgCode());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getWgMc())) {      sql.setNullString("wgMc");     } else {    sql.setString("wgMc", tRptQfrbQfrtb.getWgMc());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TRptQfrbQfrtbSVO tRptQfrbQfrtb=(TRptQfrbQfrtbSVO) vo;       Sql sql = new Sql("SELECT CREATE_DATE,G2_DYQFCZ,G2_DYQFHSL,G2_DYQFJE,G2_YQQF,G3_DYQFCZ,G3_DYQFHSL,G3_DYQFJE,G3_YQQF,G4_DYQFCZ,G4_DYQFHSL,G4_DYQFJE,G4_YQQF,GW_DYQFCZ,GW_DYQFHSL,GW_DYQFJE,GW_YQQF,OPEN_DATE,WG_CODE,WG_MC FROM T_RPT_QFRB_QFRTB WHERE 1=1  ");      Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      tRptQfrbQfrtb =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           tRptQfrbQfrtb = new TRptQfrbQfrtbSVO();           tRptQfrbQfrtb.setCreateDate(rs.getTimestamp("CREATE_DATE"));           tRptQfrbQfrtb.setG2Dyqfcz(rs.getString("G2_DYQFCZ"));           tRptQfrbQfrtb.setG2Dyqfhsl(rs.getString("G2_DYQFHSL"));           tRptQfrbQfrtb.setG2Dyqfje(rs.getString("G2_DYQFJE"));           tRptQfrbQfrtb.setG2Yqqf(rs.getString("G2_YQQF"));           tRptQfrbQfrtb.setG3Dyqfcz(rs.getString("G3_DYQFCZ"));           tRptQfrbQfrtb.setG3Dyqfhsl(rs.getString("G3_DYQFHSL"));           tRptQfrbQfrtb.setG3Dyqfje(rs.getString("G3_DYQFJE"));           tRptQfrbQfrtb.setG3Yqqf(rs.getString("G3_YQQF"));           tRptQfrbQfrtb.setG4Dyqfcz(rs.getString("G4_DYQFCZ"));           tRptQfrbQfrtb.setG4Dyqfhsl(rs.getString("G4_DYQFHSL"));           tRptQfrbQfrtb.setG4Dyqfje(rs.getString("G4_DYQFJE"));           tRptQfrbQfrtb.setG4Yqqf(rs.getString("G4_YQQF"));           tRptQfrbQfrtb.setGwDyqfcz(rs.getString("GW_DYQFCZ"));           tRptQfrbQfrtb.setGwDyqfhsl(rs.getString("GW_DYQFHSL"));           tRptQfrbQfrtb.setGwDyqfje(rs.getString("GW_DYQFJE"));           tRptQfrbQfrtb.setGwYqqf(rs.getString("GW_YQQF"));           tRptQfrbQfrtb.setOpenDate(rs.getTimestamp("OPEN_DATE"));           tRptQfrbQfrtb.setWgCode(rs.getString("WG_CODE"));           tRptQfrbQfrtb.setWgMc(rs.getString("WG_MC"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return tRptQfrbQfrtb;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TRptQfrbQfrtbSVO tRptQfrbQfrtb=(TRptQfrbQfrtbSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT CREATE_DATE,G2_DYQFCZ,G2_DYQFHSL,G2_DYQFJE,G2_YQQF,G3_DYQFCZ,G3_DYQFHSL,G3_DYQFJE,G3_YQQF,G4_DYQFCZ,G4_DYQFHSL,G4_DYQFJE,G4_YQQF,GW_DYQFCZ,GW_DYQFHSL,GW_DYQFJE,GW_YQQF,OPEN_DATE,WG_CODE,WG_MC FROM T_RPT_QFRB_QFRTB WHERE 1=1 ");     try {if (tRptQfrbQfrtb.getFlagCreateDate() == 1) {      if (tRptQfrbQfrtb.getCreateDate() == null) {             sql.append(" and CREATE_DATE is null ");          }      else{             sql.append(" and CREATE_DATE=:createDate");             sql.setTimestamp("createDate", tRptQfrbQfrtb.getCreateDate());          }   } if (tRptQfrbQfrtb.getFlagG2Dyqfcz() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfcz())) {             sql.append(" and G2_DYQFCZ is null ");          }      else{             sql.append(" and G2_DYQFCZ=:g2Dyqfcz");             sql.setLong("g2Dyqfcz", tRptQfrbQfrtb.getG2Dyqfcz());          }   } if (tRptQfrbQfrtb.getFlagG2Dyqfhsl() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfhsl())) {             sql.append(" and G2_DYQFHSL is null ");          }      else{             sql.append(" and G2_DYQFHSL=:g2Dyqfhsl");             sql.setLong("g2Dyqfhsl", tRptQfrbQfrtb.getG2Dyqfhsl());          }   } if (tRptQfrbQfrtb.getFlagG2Dyqfje() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfje())) {             sql.append(" and G2_DYQFJE is null ");          }      else{             sql.append(" and G2_DYQFJE=:g2Dyqfje");             sql.setLong("g2Dyqfje", tRptQfrbQfrtb.getG2Dyqfje());          }   } if (tRptQfrbQfrtb.getFlagG2Yqqf() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Yqqf())) {             sql.append(" and G2_YQQF is null ");          }      else{             sql.append(" and G2_YQQF=:g2Yqqf");             sql.setLong("g2Yqqf", tRptQfrbQfrtb.getG2Yqqf());          }   } if (tRptQfrbQfrtb.getFlagG3Dyqfcz() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfcz())) {             sql.append(" and G3_DYQFCZ is null ");          }      else{             sql.append(" and G3_DYQFCZ=:g3Dyqfcz");             sql.setLong("g3Dyqfcz", tRptQfrbQfrtb.getG3Dyqfcz());          }   } if (tRptQfrbQfrtb.getFlagG3Dyqfhsl() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfhsl())) {             sql.append(" and G3_DYQFHSL is null ");          }      else{             sql.append(" and G3_DYQFHSL=:g3Dyqfhsl");             sql.setLong("g3Dyqfhsl", tRptQfrbQfrtb.getG3Dyqfhsl());          }   } if (tRptQfrbQfrtb.getFlagG3Dyqfje() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfje())) {             sql.append(" and G3_DYQFJE is null ");          }      else{             sql.append(" and G3_DYQFJE=:g3Dyqfje");             sql.setLong("g3Dyqfje", tRptQfrbQfrtb.getG3Dyqfje());          }   } if (tRptQfrbQfrtb.getFlagG3Yqqf() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Yqqf())) {             sql.append(" and G3_YQQF is null ");          }      else{             sql.append(" and G3_YQQF=:g3Yqqf");             sql.setLong("g3Yqqf", tRptQfrbQfrtb.getG3Yqqf());          }   } if (tRptQfrbQfrtb.getFlagG4Dyqfcz() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfcz())) {             sql.append(" and G4_DYQFCZ is null ");          }      else{             sql.append(" and G4_DYQFCZ=:g4Dyqfcz");             sql.setLong("g4Dyqfcz", tRptQfrbQfrtb.getG4Dyqfcz());          }   } if (tRptQfrbQfrtb.getFlagG4Dyqfhsl() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfhsl())) {             sql.append(" and G4_DYQFHSL is null ");          }      else{             sql.append(" and G4_DYQFHSL=:g4Dyqfhsl");             sql.setLong("g4Dyqfhsl", tRptQfrbQfrtb.getG4Dyqfhsl());          }   } if (tRptQfrbQfrtb.getFlagG4Dyqfje() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfje())) {             sql.append(" and G4_DYQFJE is null ");          }      else{             sql.append(" and G4_DYQFJE=:g4Dyqfje");             sql.setLong("g4Dyqfje", tRptQfrbQfrtb.getG4Dyqfje());          }   } if (tRptQfrbQfrtb.getFlagG4Yqqf() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Yqqf())) {             sql.append(" and G4_YQQF is null ");          }      else{             sql.append(" and G4_YQQF=:g4Yqqf");             sql.setLong("g4Yqqf", tRptQfrbQfrtb.getG4Yqqf());          }   } if (tRptQfrbQfrtb.getFlagGwDyqfcz() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfcz())) {             sql.append(" and GW_DYQFCZ is null ");          }      else{             sql.append(" and GW_DYQFCZ=:gwDyqfcz");             sql.setLong("gwDyqfcz", tRptQfrbQfrtb.getGwDyqfcz());          }   } if (tRptQfrbQfrtb.getFlagGwDyqfhsl() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfhsl())) {             sql.append(" and GW_DYQFHSL is null ");          }      else{             sql.append(" and GW_DYQFHSL=:gwDyqfhsl");             sql.setLong("gwDyqfhsl", tRptQfrbQfrtb.getGwDyqfhsl());          }   } if (tRptQfrbQfrtb.getFlagGwDyqfje() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfje())) {             sql.append(" and GW_DYQFJE is null ");          }      else{             sql.append(" and GW_DYQFJE=:gwDyqfje");             sql.setLong("gwDyqfje", tRptQfrbQfrtb.getGwDyqfje());          }   } if (tRptQfrbQfrtb.getFlagGwYqqf() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getGwYqqf())) {             sql.append(" and GW_YQQF is null ");          }      else{             sql.append(" and GW_YQQF=:gwYqqf");             sql.setLong("gwYqqf", tRptQfrbQfrtb.getGwYqqf());          }   } if (tRptQfrbQfrtb.getFlagOpenDate() == 1) {      if (tRptQfrbQfrtb.getOpenDate() == null) {             sql.append(" and OPEN_DATE is null ");          }      else{             sql.append(" and OPEN_DATE=:openDate");             sql.setTimestamp("openDate", tRptQfrbQfrtb.getOpenDate());          }   } if (tRptQfrbQfrtb.getFlagWgCode() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getWgCode())) {             sql.append(" and WG_CODE is null ");          }      else{             sql.append(" and WG_CODE=:wgCode");             sql.setString("wgCode", tRptQfrbQfrtb.getWgCode());          }   } if (tRptQfrbQfrtb.getFlagWgMc() == 1) {      if (StringUtil.isBlank(tRptQfrbQfrtb.getWgMc())) {             sql.append(" and WG_MC is null ");          }      else{             sql.append(" and WG_MC=:wgMc");             sql.setString("wgMc", tRptQfrbQfrtb.getWgMc());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           tRptQfrbQfrtb = new TRptQfrbQfrtbSVO();           tRptQfrbQfrtb.setCreateDate(rs.getTimestamp("CREATE_DATE"));           tRptQfrbQfrtb.setG2Dyqfcz(rs.getString("G2_DYQFCZ"));           tRptQfrbQfrtb.setG2Dyqfhsl(rs.getString("G2_DYQFHSL"));           tRptQfrbQfrtb.setG2Dyqfje(rs.getString("G2_DYQFJE"));           tRptQfrbQfrtb.setG2Yqqf(rs.getString("G2_YQQF"));           tRptQfrbQfrtb.setG3Dyqfcz(rs.getString("G3_DYQFCZ"));           tRptQfrbQfrtb.setG3Dyqfhsl(rs.getString("G3_DYQFHSL"));           tRptQfrbQfrtb.setG3Dyqfje(rs.getString("G3_DYQFJE"));           tRptQfrbQfrtb.setG3Yqqf(rs.getString("G3_YQQF"));           tRptQfrbQfrtb.setG4Dyqfcz(rs.getString("G4_DYQFCZ"));           tRptQfrbQfrtb.setG4Dyqfhsl(rs.getString("G4_DYQFHSL"));           tRptQfrbQfrtb.setG4Dyqfje(rs.getString("G4_DYQFJE"));           tRptQfrbQfrtb.setG4Yqqf(rs.getString("G4_YQQF"));           tRptQfrbQfrtb.setGwDyqfcz(rs.getString("GW_DYQFCZ"));           tRptQfrbQfrtb.setGwDyqfhsl(rs.getString("GW_DYQFHSL"));           tRptQfrbQfrtb.setGwDyqfje(rs.getString("GW_DYQFJE"));           tRptQfrbQfrtb.setGwYqqf(rs.getString("GW_YQQF"));           tRptQfrbQfrtb.setOpenDate(rs.getTimestamp("OPEN_DATE"));           tRptQfrbQfrtb.setWgCode(rs.getString("WG_CODE"));           tRptQfrbQfrtb.setWgMc(rs.getString("WG_MC"));               res.add(tRptQfrbQfrtb);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TRptQfrbQfrtbSVO tRptQfrbQfrtb=(TRptQfrbQfrtbSVO) vo;          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE T_RPT_QFRB_QFRTB SET ");     try {if (tRptQfrbQfrtb.getFlagCreateDate() == 1) {sql.append("CREATE_DATE=:createDate,"); sql.setTimestamp("createDate", tRptQfrbQfrtb.getCreateDate()); } if (tRptQfrbQfrtb.getFlagG2Dyqfcz() == 1) {sql.append("G2_DYQFCZ=:g2Dyqfcz,");sql.setLong("g2Dyqfcz", tRptQfrbQfrtb.getG2Dyqfcz()); } if (tRptQfrbQfrtb.getFlagG2Dyqfhsl() == 1) {sql.append("G2_DYQFHSL=:g2Dyqfhsl,");sql.setLong("g2Dyqfhsl", tRptQfrbQfrtb.getG2Dyqfhsl()); } if (tRptQfrbQfrtb.getFlagG2Dyqfje() == 1) {sql.append("G2_DYQFJE=:g2Dyqfje,");sql.setLong("g2Dyqfje", tRptQfrbQfrtb.getG2Dyqfje()); } if (tRptQfrbQfrtb.getFlagG2Yqqf() == 1) {sql.append("G2_YQQF=:g2Yqqf,");sql.setLong("g2Yqqf", tRptQfrbQfrtb.getG2Yqqf()); } if (tRptQfrbQfrtb.getFlagG3Dyqfcz() == 1) {sql.append("G3_DYQFCZ=:g3Dyqfcz,");sql.setLong("g3Dyqfcz", tRptQfrbQfrtb.getG3Dyqfcz()); } if (tRptQfrbQfrtb.getFlagG3Dyqfhsl() == 1) {sql.append("G3_DYQFHSL=:g3Dyqfhsl,");sql.setLong("g3Dyqfhsl", tRptQfrbQfrtb.getG3Dyqfhsl()); } if (tRptQfrbQfrtb.getFlagG3Dyqfje() == 1) {sql.append("G3_DYQFJE=:g3Dyqfje,");sql.setLong("g3Dyqfje", tRptQfrbQfrtb.getG3Dyqfje()); } if (tRptQfrbQfrtb.getFlagG3Yqqf() == 1) {sql.append("G3_YQQF=:g3Yqqf,");sql.setLong("g3Yqqf", tRptQfrbQfrtb.getG3Yqqf()); } if (tRptQfrbQfrtb.getFlagG4Dyqfcz() == 1) {sql.append("G4_DYQFCZ=:g4Dyqfcz,");sql.setLong("g4Dyqfcz", tRptQfrbQfrtb.getG4Dyqfcz()); } if (tRptQfrbQfrtb.getFlagG4Dyqfhsl() == 1) {sql.append("G4_DYQFHSL=:g4Dyqfhsl,");sql.setLong("g4Dyqfhsl", tRptQfrbQfrtb.getG4Dyqfhsl()); } if (tRptQfrbQfrtb.getFlagG4Dyqfje() == 1) {sql.append("G4_DYQFJE=:g4Dyqfje,");sql.setLong("g4Dyqfje", tRptQfrbQfrtb.getG4Dyqfje()); } if (tRptQfrbQfrtb.getFlagG4Yqqf() == 1) {sql.append("G4_YQQF=:g4Yqqf,");sql.setLong("g4Yqqf", tRptQfrbQfrtb.getG4Yqqf()); } if (tRptQfrbQfrtb.getFlagGwDyqfcz() == 1) {sql.append("GW_DYQFCZ=:gwDyqfcz,");sql.setLong("gwDyqfcz", tRptQfrbQfrtb.getGwDyqfcz()); } if (tRptQfrbQfrtb.getFlagGwDyqfhsl() == 1) {sql.append("GW_DYQFHSL=:gwDyqfhsl,");sql.setLong("gwDyqfhsl", tRptQfrbQfrtb.getGwDyqfhsl()); } if (tRptQfrbQfrtb.getFlagGwDyqfje() == 1) {sql.append("GW_DYQFJE=:gwDyqfje,");sql.setLong("gwDyqfje", tRptQfrbQfrtb.getGwDyqfje()); } if (tRptQfrbQfrtb.getFlagGwYqqf() == 1) {sql.append("GW_YQQF=:gwYqqf,");sql.setLong("gwYqqf", tRptQfrbQfrtb.getGwYqqf()); } if (tRptQfrbQfrtb.getFlagOpenDate() == 1) {sql.append("OPEN_DATE=:openDate,"); sql.setTimestamp("openDate", tRptQfrbQfrtb.getOpenDate()); } if (tRptQfrbQfrtb.getFlagWgCode() == 1) {sql.append("WG_CODE=:wgCode,"); sql.setString("wgCode", tRptQfrbQfrtb.getWgCode()); } if (tRptQfrbQfrtb.getFlagWgMc() == 1) {sql.append("WG_MC=:wgMc,"); sql.setString("wgMc", tRptQfrbQfrtb.getWgMc()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO T_RPT_QFRB_QFRTB(CREATE_DATE,G2_DYQFCZ,G2_DYQFHSL,G2_DYQFJE,G2_YQQF,G3_DYQFCZ,G3_DYQFHSL,G3_DYQFJE,G3_YQQF,G4_DYQFCZ,G4_DYQFHSL,G4_DYQFJE,G4_YQQF,GW_DYQFCZ,GW_DYQFHSL,GW_DYQFJE,GW_YQQF,OPEN_DATE,WG_CODE,WG_MC)");sql.append(" VALUES (:createDate,:g2Dyqfcz,:g2Dyqfhsl,:g2Dyqfje,:g2Yqqf,:g3Dyqfcz,:g3Dyqfhsl,:g3Dyqfje,:g3Yqqf,:g4Dyqfcz,:g4Dyqfhsl,:g4Dyqfje,:g4Yqqf,:gwDyqfcz,:gwDyqfhsl,:gwDyqfje,:gwYqqf,:openDate,:wgCode,:wgMc)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       TRptQfrbQfrtbSVO tRptQfrbQfrtb=(TRptQfrbQfrtbSVO) list.get(i);         if (tRptQfrbQfrtb== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }   if (tRptQfrbQfrtb.getCreateDate() == null) {      sql.setNullDate("createDate");     } else {    sql.setTimestamp("createDate", tRptQfrbQfrtb.getCreateDate());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfcz())) {      sql.setNullLong("g2Dyqfcz");     } else {    sql.setLong("g2Dyqfcz", tRptQfrbQfrtb.getG2Dyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfhsl())) {      sql.setNullLong("g2Dyqfhsl");     } else {    sql.setLong("g2Dyqfhsl", tRptQfrbQfrtb.getG2Dyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Dyqfje())) {      sql.setNullLong("g2Dyqfje");     } else {    sql.setLong("g2Dyqfje", tRptQfrbQfrtb.getG2Dyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG2Yqqf())) {      sql.setNullLong("g2Yqqf");     } else {    sql.setLong("g2Yqqf", tRptQfrbQfrtb.getG2Yqqf());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfcz())) {      sql.setNullLong("g3Dyqfcz");     } else {    sql.setLong("g3Dyqfcz", tRptQfrbQfrtb.getG3Dyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfhsl())) {      sql.setNullLong("g3Dyqfhsl");     } else {    sql.setLong("g3Dyqfhsl", tRptQfrbQfrtb.getG3Dyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Dyqfje())) {      sql.setNullLong("g3Dyqfje");     } else {    sql.setLong("g3Dyqfje", tRptQfrbQfrtb.getG3Dyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG3Yqqf())) {      sql.setNullLong("g3Yqqf");     } else {    sql.setLong("g3Yqqf", tRptQfrbQfrtb.getG3Yqqf());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfcz())) {      sql.setNullLong("g4Dyqfcz");     } else {    sql.setLong("g4Dyqfcz", tRptQfrbQfrtb.getG4Dyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfhsl())) {      sql.setNullLong("g4Dyqfhsl");     } else {    sql.setLong("g4Dyqfhsl", tRptQfrbQfrtb.getG4Dyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Dyqfje())) {      sql.setNullLong("g4Dyqfje");     } else {    sql.setLong("g4Dyqfje", tRptQfrbQfrtb.getG4Dyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getG4Yqqf())) {      sql.setNullLong("g4Yqqf");     } else {    sql.setLong("g4Yqqf", tRptQfrbQfrtb.getG4Yqqf());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfcz())) {      sql.setNullLong("gwDyqfcz");     } else {    sql.setLong("gwDyqfcz", tRptQfrbQfrtb.getGwDyqfcz());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfhsl())) {      sql.setNullLong("gwDyqfhsl");     } else {    sql.setLong("gwDyqfhsl", tRptQfrbQfrtb.getGwDyqfhsl());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwDyqfje())) {      sql.setNullLong("gwDyqfje");     } else {    sql.setLong("gwDyqfje", tRptQfrbQfrtb.getGwDyqfje());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getGwYqqf())) {      sql.setNullLong("gwYqqf");     } else {    sql.setLong("gwYqqf", tRptQfrbQfrtb.getGwYqqf());    }    if (tRptQfrbQfrtb.getOpenDate() == null) {      sql.setNullDate("openDate");     } else {    sql.setTimestamp("openDate", tRptQfrbQfrtb.getOpenDate());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getWgCode())) {      sql.setNullString("wgCode");     } else {    sql.setString("wgCode", tRptQfrbQfrtb.getWgCode());    }       if (StringUtil.isBlank(tRptQfrbQfrtb.getWgMc())) {      sql.setNullString("wgMc");     } else {    sql.setString("wgMc", tRptQfrbQfrtb.getWgMc());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TRptQfrbQfrtbSVO tRptQfrbQfrtb=(TRptQfrbQfrtbSVO) vo;          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM T_RPT_QFRB_QFRTB WHERE 1=1  ");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     TRptQfrbQfrtbSVO tRptQfrbQfrtb=(TRptQfrbQfrtbSVO) vo;       }}
