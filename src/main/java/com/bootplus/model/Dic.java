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
/**
 * 数据字典
 * @author liulu
 *
 */
@Entity
@Table(name = "dic")
public class Dic extends BaseModel implements Serializable {
	private static final long serialVersionUID = -6481659353176251280L;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CODE")
	private String code;
	@Column(name = "COMMENTS")
	private String comments;
	//状态0，删除，1正常
	@Column(name = "STATUS")
	private String status;
	
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
}
