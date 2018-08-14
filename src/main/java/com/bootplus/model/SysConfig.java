package com.bootplus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bootplus.core.base.BaseModel;
/**
 * 系统配置
 * @author liulu
 *
 */
@Entity
@Table(name = "sysconfig", catalog = "boot")
public class SysConfig extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3345857255218454984L;

	@Column(name = "CONFIG_KEY")
	private String key;
	@Column(name = "CONFIG_VALUE")
	private String value;
	@Column(name = "COMMENTS")
	private String comments;
	@Column(name = "STATUS")
	private String status;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
