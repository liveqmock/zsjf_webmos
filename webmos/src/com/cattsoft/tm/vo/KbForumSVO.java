package com.cattsoft.tm.vo;

import com.cattsoft.pub.vo.GenericVO;

/**
 * 知识库讨论区SVO
 * 
 * @author lupan
 *
 */
public class KbForumSVO extends GenericVO {

	/**
	 * 自动生成
	 */
	private static final long serialVersionUID = -778883845172290503L;
	/**
	 * 讨论区ID
	 */
	private String forumId = null;
	
	/**
	 * 分类ID
	 */
	private String categoriesId = null;
	/**
	 * 名称
	 */
	private String forumName = null;
	/**
	 * 描述
	 */
	private String forumDesc = null;
	/**
	 * 显示顺序
	 */
	private int forumOrder = 0;
	/**
	 * 主题数量
	 */
	private int forumTopics = 0;
	/**
	 * 讨论区最近发布主题ID
	 */
	private String forumLastPostId = null;
	/**
	 * 是否需要审核
	 */
	private String moderated = null;
	
	/**
	 * 无参构造函数
	 */
	public KbForumSVO() {
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(String categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getForumDesc() {
		return forumDesc;
	}

	public void setForumDesc(String forumDesc) {
		this.forumDesc = forumDesc;
	}

	public int getForumOrder() {
		return forumOrder;
	}

	public void setForumOrder(int forumOrder) {
		this.forumOrder = forumOrder;
	}

	public int getForumTopics() {
		return forumTopics;
	}

	public void setForumTopics(int forumTopics) {
		this.forumTopics = forumTopics;
	}

	public String getForumLastPostId() {
		return forumLastPostId;
	}

	public void setForumLastPostId(String forumLastPostId) {
		this.forumLastPostId = forumLastPostId;
	}

	public String getModerated() {
		return moderated;
	}

	public void setModerated(String moderated) {
		this.moderated = moderated;
	}

}
