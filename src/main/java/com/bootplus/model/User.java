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
@Table(name = "user")
public class User extends BaseModel implements Serializable {

	private static final long serialVersionUID = 3870740272700243791L;
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
	//用户头像
	@ManyToOne()
	@JoinColumn(name = "HEADERIMG", nullable=true)
	private UFile headerImg;
	@Column(name = "LASTLOGINTIME")
	private Date lastLoginTime;
	//状态0，删除，1正常
	@Column(name = "STATUS")
	private String status;
	//临时存储用户分配的角色，不持久化
	@Transient
	private String roleId;
	
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
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public UFile getHeaderImg() {
		return headerImg;
	}
	public void setHeaderImg(UFile headerImg) {
		this.headerImg = headerImg;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
