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
@Table(name = "tag")
public class Tag extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 137099514559331613L;
	@Column(name = "NAME")
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
