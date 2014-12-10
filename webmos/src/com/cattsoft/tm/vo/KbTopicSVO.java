package com.cattsoft.tm.vo;

import java.util.Date;

import com.cattsoft.pub.vo.GenericVO;

/**
 * 知识库讨论主题SVO
 * 
 * @author lupan
 *
 */
public class KbTopicSVO extends GenericVO {
	/**
	 * 自动生成
	 */
	private static final long serialVersionUID = 175954753263269811L;
	/**
	 * 讨论主题ID
	 */
	private String topicId = null;
	/**
	 * 讨论区ID
	 */
	private String forumId = null;
	private String forumName = null;
	/**
	 * 讨论主题
	 */
	private String topicTitle = null;
	/**
	 * 讨论主题描述
	 */
	private String topicDesc = null;
	/**
	 * 讨论主题发起用户ID
	 */
	private String userId = null;
	/**
	 * 讨论主题发起用户名
	 */
	private String postUserName = null;
	/**
	 * 讨论主题发起时间
	 */
	private Date topicTime = null;
	/**
	 * 讨论主题浏览次数
	 */
	private int topicViews = 0;
	/**
	 * 讨论主题回复次数
	 */
	private int topicReplies = 0;
	/**
	 * 讨论主题的状态
	 */
	private String topicStatus = null;
	/**
	 * 论坛主题投标ID
	 */
	private String topicVoteId = null;
	/**
	 * 主题类型
	 */
	private String topicType = null;
	/**
	 * 主题第一个回复
	 */
	private String topicFirstPostId = null;
	/**
	 * 主题最近一个回复
	 */
	private String topicLastPostId = null;
	/**
	 * 是否需要审核
	 */
	private String moderated = null;
	/**
	 * 第一次回复时间
	 */
	private String firstPostTime = null;
	
	/**
	 * 无参构造函数
	 */
	public KbTopicSVO() {
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	
	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getTopicDesc() {
		return topicDesc;
	}

	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostUserName() {
		return postUserName;
	}

	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}

	public Date getTopicTime() {
		return topicTime;
	}

	public void setTopicTime(Date topicTime) {
		this.topicTime = topicTime;
	}

	public int getTopicViews() {
		return topicViews;
	}

	public void setTopicViews(int topicViews) {
		this.topicViews = topicViews;
	}

	public int getTopicReplies() {
		return topicReplies;
	}

	public void setTopicReplies(int topicReplies) {
		this.topicReplies = topicReplies;
	}

	public String getTopicStatus() {
		return topicStatus;
	}

	public void setTopicStatus(String topicStatus) {
		this.topicStatus = topicStatus;
	}

	public String getTopicVoteId() {
		return topicVoteId;
	}

	public void setTopicVoteId(String topicVoteId) {
		this.topicVoteId = topicVoteId;
	}

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}

	public String getTopicFirstPostId() {
		return topicFirstPostId;
	}

	public void setTopicFirstPostId(String topicFirstPostId) {
		this.topicFirstPostId = topicFirstPostId;
	}

	public String getTopicLastPostId() {
		return topicLastPostId;
	}

	public void setTopicLastPostId(String topicLastPostId) {
		this.topicLastPostId = topicLastPostId;
	}

	public String getModerated() {
		return moderated;
	}

	public void setModerated(String moderated) {
		this.moderated = moderated;
	}

	public String getFirstPostTime() {
		return firstPostTime;
	}

	public void setFirstPostTime(String firstPostTime) {
		this.firstPostTime = firstPostTime;
	}
	
}
