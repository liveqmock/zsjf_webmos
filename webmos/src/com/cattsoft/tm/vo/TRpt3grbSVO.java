package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * TRpt3grbSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class TRpt3grbSVO extends GenericVO {private Date createDate = null;private Date openDate = null;private String t3grbByfz = null;private String t3grbBz = null;private String t3grbDq = null;private String t3grbHbt = null;private String t3grbSytq = null;private String t3grbZzs = null;private String t3grbRfz=null; private int flagCreateDate = 0;private int flagOpenDate = 0;private int flagT3grbByfz = 0;private int flagT3grbBz = 0;private int flagT3grbDq = 0;private int flagT3grbHbt = 0;private int flagT3grbSytq = 0;private int flagT3grbZzs = 0;public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public Date getOpenDate(){  return openDate;}public void setOpenDate(Date newValue){   this.openDate = newValue;  flagOpenDate = 1;}public int getFlagOpenDate(){  return flagOpenDate;}public String getT3grbByfz(){ return t3grbByfz;}public void setT3grbByfz(String newValue){  this.t3grbByfz = newValue;  flagT3grbByfz = 1;}public int getFlagT3grbByfz(){  return flagT3grbByfz;}public String getT3grbBz(){ return t3grbBz;}public void setT3grbBz(String newValue){  this.t3grbBz = newValue;  flagT3grbBz = 1;}public int getFlagT3grbBz(){  return flagT3grbBz;}public String getT3grbDq(){ return t3grbDq;}public void setT3grbDq(String newValue){  this.t3grbDq = newValue;  flagT3grbDq = 1;}public int getFlagT3grbDq(){  return flagT3grbDq;}public String getT3grbHbt(){ return t3grbHbt;}public void setT3grbHbt(String newValue){  this.t3grbHbt = newValue;  flagT3grbHbt = 1;}public int getFlagT3grbHbt(){  return flagT3grbHbt;}public String getT3grbSytq(){ return t3grbSytq;}public void setT3grbSytq(String newValue){  this.t3grbSytq = newValue;  flagT3grbSytq = 1;}public int getFlagT3grbSytq(){  return flagT3grbSytq;}public String getT3grbZzs(){ return t3grbZzs;}public void setT3grbZzs(String newValue){  this.t3grbZzs = newValue;  flagT3grbZzs = 1;}public int getFlagT3grbZzs(){  return flagT3grbZzs;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagOpenDate(){ flagOpenDate = 0 ;}public void clearFlagT3grbByfz(){ flagT3grbByfz = 0 ;}public void clearFlagT3grbBz(){ flagT3grbBz = 0 ;}public void clearFlagT3grbDq(){ flagT3grbDq = 0 ;}public void clearFlagT3grbHbt(){ flagT3grbHbt = 0 ;}public void clearFlagT3grbSytq(){ flagT3grbSytq = 0 ;}public void clearFlagT3grbZzs(){ flagT3grbZzs = 0 ;}public String getT3grbRfz() {	return t3grbRfz;}public void setT3grbRfz(String t3grbRfz) {	this.t3grbRfz = t3grbRfz;}public void clearAll(){ flagCreateDate = 0; flagOpenDate = 0; flagT3grbByfz = 0; flagT3grbBz = 0; flagT3grbDq = 0; flagT3grbHbt = 0; flagT3grbSytq = 0; flagT3grbZzs = 0;}}
