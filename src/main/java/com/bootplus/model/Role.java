package com.bootplus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bootplus.core.base.BaseModel;

@Entity
@Table(name = "role", catalog = "boot")
public class Role extends BaseModel implements java.io.Serializable{
	private static final long serialVersionUID = -6928725591394366409L;
	@Column(name = "NAME")
    private String name;
	@Column(name = "TYPE")
    private String type;
	@Column(name = "CODE")
    private String code;
	//状态0，删除，1正常
	@Column(name = "STATUS")
	private String status;
	//备注
	@Column(name = "COMMENTS", length =1500)
	private String comments;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
