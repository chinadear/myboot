package com.bootplus.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.bootplus.Util.IdUtil;
import com.bootplus.core.base.BaseModel;

@Entity
@Table(name = "userlogin", catalog = "boot")
public class UserLogin extends BaseModel implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4761327246428918368L;
	@Id//代表主键
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid.hex")
	@Column(name = "ID", unique = true, nullable = false)
	private String id;
	@Column(name = "USERNAME", length =50)
    private String username;
	@Column(name = "PASSWORD", length =200)
    private String password;
	@ManyToOne()
	@JoinColumn(name = "USER_ID", nullable=true)
    private User userId;
    //创建时间
	@Column(name = "CREATE_TIME")
	private Date createTime;
	//更新时间
	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	public String getId() {
		return this.id;
	}
	
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

	public void setId(String id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
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
