package com.zhaoziqian.phoneInfo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ClassName: Reply
* @Description: 回复表实体
* @author zhaoziqian
* @date 2017年9月1日 下午1:05:38
*
 */
public class Reply implements Serializable{

	private static final long serialVersionUID = -498547933033301234L;
	
	private Integer id;
	private String content;
	private Date replyTime;
	private Integer infoId;
	
	public Reply() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	@Override
	public String toString() {
		return "Reply [id=" + id + ", content=" + content + ", replyTime=" + replyTime + ", infoId=" + infoId + "]";
	}
	
	
	
}
