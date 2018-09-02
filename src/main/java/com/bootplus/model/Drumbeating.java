package com.bootplus.model;


import com.bootplus.core.base.BaseModel;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "drumbeating")
public class Drumbeating extends BaseModel implements java.io.Serializable{

	private static final long serialVersionUID = -2595234146215877097L;

	@Column(name="TITLE")
    private String title;
    @Column(name="SUMMARY")
    private String summary;
    //0草稿，1发布，2未发布，3禁用
    @Column(name="STATUS") 
    private String status;
    //类型，属于哪个版块
    @Column(name="TYPE") 
    private String type;
    @Column(name="URL") 
    private String url;
    @ManyToOne()
	@JoinColumn(name = "FILE", nullable=true)
    @NotFound(action=NotFoundAction.IGNORE)
	private UFile file;
    //截止日期，下架日期
    @Column(name = "CLOSINGDATE")
	private Date closingDate;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public UFile getFile() {
		return file;
	}
	public void setFile(UFile file) {
		this.file = file;
	}
	public Date getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

}
