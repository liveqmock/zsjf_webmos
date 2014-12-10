package com.cattsoft.tm.vo;

import java.util.Date;

import com.cattsoft.pub.vo.GenericVO;

/**
 * 知识库回复信息SVO
 * 
 * @author lupan
 *
 */
public class KbPostSVO extends GenericVO {
	/**
	 * 自动生成
	 */
	private static final long serialVersionUID = -6251762669215740098L;
	/**
	 * 回复信息ID
	 */
	private String postId = null;
	/**
	 * 讨论主题ID
	 */
	private String topicId = null;
	/**
	 * 讨论区ID
	 */
	private String forumId = null;
	/**
	 * 讨论主题发起用户
	 */
	private String userName = null;
	/**
	 * 回复时间
	 */
	private Date postTime = new Date();
	/**
	 * 回复者IP
	 */
	private String posterIp = null;
	/**
	 * 转义码开启标识
	 */
	private String enableBbcode = null;
	/**
	 * HTML开启标识
	 */
	private String enableHtml = null;
	/**
	 * 表情符号开启标识
	 */
	private String enableSmilies = null;
	/**
	 * 签名开启标识
	 */
	private String enableSig = null;
	/**
	 * 回复编辑时间
	 */
	private Date postEditTime = new Date();
	/**
	 * 回复编辑次数
	 */
	private int postEditCount = 0;
	/**
	 * 状态
	 */
	private String status = null;
	/**
	 * 附件标识
	 */
	private String attach = null;
	/**
	 * 是否需要审核
	 */
	private String needModerate = null;
	/**
	 * 回复信息内容
	 */
	private String postText = null;
	/**
	 * 回复主题
	 */
	private String postSubject = null;

	/**
	 * 无参构造函数
	 */
	public KbPostSVO() {
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getPosterIp() {
		return posterIp;
	}

	public void setPosterIp(String posterIp) {
		this.posterIp = posterIp;
	}

	public String getEnableBbcode() {
		return enableBbcode;
	}

	public void setEnableBbcode(String enableBbcode) {
		this.enableBbcode = enableBbcode;
	}

	public String getEnableHtml() {
		return enableHtml;
	}

	public void setEnableHtml(String enableHtml) {
		this.enableHtml = enableHtml;
	}

	public String getEnableSmilies() {
		return enableSmilies;
	}

	public void setEnableSmilies(String enableSmilies) {
		this.enableSmilies = enableSmilies;
	}

	public String getEnableSig() {
		return enableSig;
	}

	public void setEnableSig(String enableSig) {
		this.enableSig = enableSig;
	}

	public Date getPostEditTime() {
		return postEditTime;
	}

	public void setPostEditTime(Date postEditTime) {
		this.postEditTime = postEditTime;
	}

	public int getPostEditCount() {
		return postEditCount;
	}

	public void setPostEditCount(int postEditCount) {
		this.postEditCount = postEditCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getNeedModerate() {
		return needModerate;
	}

	public void setNeedModerate(String needModerate) {
		this.needModerate = needModerate;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostSubject() {
		return postSubject;
	}

	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}

}
