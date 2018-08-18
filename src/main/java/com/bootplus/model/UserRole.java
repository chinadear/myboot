package com.bootplus.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootplus.core.base.BaseModel;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseModel implements java.io.Serializable{
	private static final long serialVersionUID = 3149625435272589437L;
	@ManyToOne()
	@JoinColumn(name = "USER_ID", nullable=true)
    private User user;
	@ManyToOne()
	@JoinColumn(name = "ROLE_ID", nullable=true)
    private Role role;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
