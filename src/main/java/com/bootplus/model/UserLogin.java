package com.bootplus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bootplus.core.base.BaseModel;

@Entity
@Table(name = "userlogin")
public class UserLogin extends BaseModel implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4761327246428918368L;
	@Column(name = "USERNAME", length =50)
    private String username;
	@Column(name = "PASSWORD", length =200)
    private String password;
	@ManyToOne()
	@JoinColumn(name = "USER_ID", nullable=true)
    private User userId;
	//状态0，删除，1正常
	@Column(name = "STATUS")
	private String status;
	//确认密码，不持久化
	@Transient
	private String repassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
