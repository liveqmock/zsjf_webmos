package com.cattsoft.pub.util;

import java.io.Serializable;
/**
 *
 * <p>Title: �¾���ϵͳ</p>
 * <p>Description: �¾���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: CATTSoft</p>
 * @author ʷ��
 * @version 1.0
 */
public class PagInfo implements Serializable{
	
	
  public PagInfo() {
  }
  int count=-1;//�ܼ�¼��
  int pagSize=-1;//ÿҳ��ʾ��¼��
  int pagNo=-1;//ҳ����
  int pagCount=-1;///////////ҳ��
  public int getCount() {
    return count;
  }
  public int getPagNo() {
    return pagNo;
  }
  public void setPagNo(int pagNo) {
    this.pagNo = pagNo;
  }
  public void setPagCount(int pagCount) {
    this.pagCount = pagCount;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public int getPagCount() {
    return pagCount;
  }
  public int getPagSize() {
    return pagSize;
  }
  public void setPagSize(int pagSize) {
    this.pagSize = pagSize;
  }


}
