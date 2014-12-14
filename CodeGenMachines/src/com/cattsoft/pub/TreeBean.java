package com.cattsoft.pub;

import java.io.*;

/**
 * ��������Bean
 * <p>
 * Title: �¾���ϵͳ
 * </p>
 * <p>
 * Description: �¾���ϵͳ
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: CATTSoft
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class TreeBean implements Serializable, Comparable {

	public TreeBean() {
	}

	// ��ʶ
	public String id = null;

	// ����
	public String name = null;

	// ���ڵ��ʶ
	public String fa = null;

	// ��ʾ���ȼ�
	public Integer clas = null;

	// ���ӵ�ַ
	public String href = null;

	// �����ύ�Ķ���
	public String target = null;

	// �ǽڵ㻹��Ҷ��
	public String isNode = null;

	private String orderBy = null;

	private String value = null;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getClas() {
		return clas;
	}

	public String getTarget() {
		return target;
	}

	public String getHref() {
		return href;
	}

	public String getIsNode() {
		return isNode;
	}

	public void setFa(String fa) {
		this.fa = fa;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClas(Integer clas) {
		this.clas = clas;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setIsNode(String isNode) {
		this.isNode = isNode;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFa() {
		return fa;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getValue() {
		if (value != null) {
			return value;
		} else {
			return id;
		}
	}

	/**
	 * �ж����ȼ��ķ���
	 * 
	 * @param obj
	 *            Object
	 * @return int
	 */
	public int compareTo(Object obj) {
		TreeBean tb = (TreeBean) obj;
		if ((tb.getIsNode() != null) && (getIsNode() != null)) {
			if ((getIsNode().equalsIgnoreCase("y")) || (getIsNode().equalsIgnoreCase("yes"))) {
				if ((tb.getIsNode().equalsIgnoreCase("n"))
						|| (tb.getIsNode().equalsIgnoreCase("no"))) {
					return -1;
				}
			}

			if ((tb.getIsNode().equalsIgnoreCase("y")) || (tb.getIsNode().equalsIgnoreCase("yes"))) {
				if ((getIsNode().equalsIgnoreCase("n")) || (getIsNode().equalsIgnoreCase("no"))) {
					return -1;
				}
			}

		}

		if ((tb.getClas() != null) && (getClas() != null)) {
			int fir = getClas().intValue();
			int sed = tb.getClas().intValue();
			if (fir != sed) {
				return fir - sed;
			}
		}

		if (getOrderBy() != null && getName() != null && tb.getName() != null) {
			if ("name".equals(getOrderBy())) {
				if (!getName().equals(tb.getName())) {
					return getName().hashCode() - tb.getName().hashCode();
				}
			}
		}

		if (!getId().equals(tb.getId())) {
			// //System.out.println(tb.getId()+"####################"+tb.getName()+"##############"+getId()+"#############"+getName());
			return getId().hashCode() - tb.getId().hashCode();
		}

		return getName().hashCode() - tb.getName().hashCode();
	}

	/**
	 * �ж���ȵķ���
	 * 
	 * @param o
	 *            Object
	 * @return boolean
	 */
	public boolean equals(Object o) {
		TreeBean tb = (TreeBean) o;
		if (!tb.getId().equals(this.getId())) {
			return false;
		}

		boolean b1 = this.getIsNode().equalsIgnoreCase("y")
				|| this.getIsNode().equalsIgnoreCase("yes")
				|| this.getIsNode().equalsIgnoreCase("true");
		boolean b2 = tb.getIsNode().equalsIgnoreCase("y") || tb.getIsNode().equalsIgnoreCase("yes")
				|| tb.getIsNode().equalsIgnoreCase("true");

		if (b1 != b2) {
			return false;
		}

		return true;
	}

}
