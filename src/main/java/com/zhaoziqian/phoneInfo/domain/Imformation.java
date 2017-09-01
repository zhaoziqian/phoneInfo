package com.zhaoziqian.phoneInfo.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 
* @ClassName: Imformation
* @Description: 主题的实体
* @author zhaoziqian
* @date 2017年9月1日 下午1:08:10
*
 */
public class Imformation implements Serializable{

	
	private static final long serialVersionUID = -152100299876668534L;
	private Integer id;
	private String title;
	private String content;
	private Integer replyCount;
	private Integer viewCount;
	private Date reportTime;
	private Date lastPostTime;
	
	public Imformation() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public Date getLastPostTime() {
		return lastPostTime;
	}

	public void setLastPostTime(Date lastPostTime) {
		this.lastPostTime = lastPostTime;
	}
	
	
}
