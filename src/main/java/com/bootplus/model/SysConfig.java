package com.bootplus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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

	@Id//代表主键
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid.hex")
	@Column(name = "ID", unique = true, nullable = false)
	private String id;
	@Column(name = "CONFIG_KEY")
	private String key;
	@Column(name = "CONFIG_VALUE")
	private String value;
	@Column(name = "COMMENTS")
	private String comments;
	@Column(name = "STATUS")
	private String status;
	//创建时间
	@Column(name = "CREATE_TIME")
	private Date createTime;
	//更新时间
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
