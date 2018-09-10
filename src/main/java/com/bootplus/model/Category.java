package com.bootplus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bootplus.core.base.BaseModel;

@Entity
@Table(name = "category")
public class Category extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1156409056462962660L;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CODE")
	private String code;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "COMMENTS")
	private String comments;
	//状态0，删除，1正常
	@Column(name = "STATUS")
	private String status;
	//分类下的文章数
	@Transient
	private String articals;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getArticals() {
		return articals;
	}
	public void setArticals(String articals) {
		this.articals = articals;
	}
}
