package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * TRptZdgzKhjlSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class TRptZdgzKhjlSVO extends GenericVO {private String cpMc = null;private Date createDate = null;private String erpId = null;private String loginId = null;private Date openDate = null;private String zdgzDtz = null;private String zdgzDylj = null;private String zdgzDyljc = null;private int flagCpMc = 0;private int flagCreateDate = 0;private int flagErpId = 0;private int flagLoginId = 0;private int flagOpenDate = 0;private int flagZdgzDtz = 0;private int flagZdgzDylj = 0;private int flagZdgzDyljc = 0;public String getCpMc(){ return cpMc;}public void setCpMc(String newValue){  this.cpMc = newValue;  flagCpMc = 1;}public int getFlagCpMc(){  return flagCpMc;}public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getErpId(){ return erpId;}public void setErpId(String newValue){  this.erpId = newValue;  flagErpId = 1;}public int getFlagErpId(){  return flagErpId;}public String getLoginId(){ return loginId;}public void setLoginId(String newValue){  this.loginId = newValue;  flagLoginId = 1;}public int getFlagLoginId(){  return flagLoginId;}public Date getOpenDate(){  return openDate;}public void setOpenDate(Date newValue){   this.openDate = newValue;  flagOpenDate = 1;}public int getFlagOpenDate(){  return flagOpenDate;}public String getZdgzDtz(){ return zdgzDtz;}public void setZdgzDtz(String newValue){  this.zdgzDtz = newValue;  flagZdgzDtz = 1;}public int getFlagZdgzDtz(){  return flagZdgzDtz;}public String getZdgzDylj(){ return zdgzDylj;}public void setZdgzDylj(String newValue){  this.zdgzDylj = newValue;  flagZdgzDylj = 1;}public int getFlagZdgzDylj(){  return flagZdgzDylj;}public String getZdgzDyljc(){ return zdgzDyljc;}public void setZdgzDyljc(String newValue){  this.zdgzDyljc = newValue;  flagZdgzDyljc = 1;}public int getFlagZdgzDyljc(){  return flagZdgzDyljc;}public void clearFlagCpMc(){ flagCpMc = 0 ;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagErpId(){ flagErpId = 0 ;}public void clearFlagLoginId(){ flagLoginId = 0 ;}public void clearFlagOpenDate(){ flagOpenDate = 0 ;}public void clearFlagZdgzDtz(){ flagZdgzDtz = 0 ;}public void clearFlagZdgzDylj(){ flagZdgzDylj = 0 ;}public void clearFlagZdgzDyljc(){ flagZdgzDyljc = 0 ;}public void clearAll(){ flagCpMc = 0; flagCreateDate = 0; flagErpId = 0; flagLoginId = 0; flagOpenDate = 0; flagZdgzDtz = 0; flagZdgzDylj = 0; flagZdgzDyljc = 0;}}
