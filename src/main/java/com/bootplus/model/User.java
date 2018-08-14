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

@Entity
@Table(name = "user", catalog = "boot")
public class User extends BaseModel implements Serializable {

	private static final long serialVersionUID = 3870740272700243791L;

	@Id//代表主键
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid.hex")
	@Column(name = "ID", unique = true, nullable = false)
	private String id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "REALNAME")
	private String realName;
	@Column(name = "IDCARD")
	private String idCard;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "QQ")
	private String qq;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "OPENID")
	private String openid;
	@Column(name = "BIRTHDAY")
	private String birthday;
	@Column(name = "ADDRESS")
	private String address;
	//用户类型0超级管理员,1系统用户，2成员（会员）
	@Column(name = "USERTYPE")
	private String userType;
	@Column(name = "LASTLOGINTIME")
	private Date lastLoginTime;
	//状态0，删除，1正常
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
