package com.bootplus.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootplus.core.base.BaseModel;

@Entity
@Table(name = "res_role")
public class ResRole extends BaseModel implements java.io.Serializable{
	private static final long serialVersionUID = -3725403805755190750L;
	@ManyToOne()
	@JoinColumn(name = "RESOURCE_ID", nullable=true)
    private Resource resource;
	@ManyToOne()
	@JoinColumn(name = "ROLE_ID", nullable=true)
    private Role role;
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
