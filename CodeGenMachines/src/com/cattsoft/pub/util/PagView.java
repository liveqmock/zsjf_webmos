package com.cattsoft.pub.util;
import java.util.List;
import java.io.Serializable;
/**
 *
 * <p>Title: ��ҳ��ʾ���ص���</p>
 * <p>Description: �¾���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: CATTSoft</p>
 * @author shijian
 * @version 1.0
 */
public class PagView implements Serializable{

  public PagView() {
  }

  int count;//�ܼ�¼��
  int pagSize;//ÿҳ��ʾ��¼��
  int pagNo;//ҳ����
  int pagCount;//ҳ��
  private List viewList;//��ʾ����

  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public int getPagCount() {
    return pagCount;
  }
  public void setPagCount(int pagCount) {
    this.pagCount = pagCount;
  }
  public int getPagNo() {
    return pagNo;
  }
  public void setPagNo(int pagNo) {
    this.pagNo = pagNo;
  }
  public int getPagSize() {
    return pagSize;
  }
  public void setPagSize(int pagSize) {
    this.pagSize = pagSize;
  }
  public List getViewList() {
    return viewList;
  }
  public void setViewList(List viewList) {
    this.viewList = viewList;
  }

}