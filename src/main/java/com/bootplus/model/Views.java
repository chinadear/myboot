package com.bootplus.model;


import com.bootplus.core.base.BaseModel;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/**
 * 统计网站访问量
 * @author angle
 *
 */
@Entity
@Table(name = "views")
public class Views extends BaseModel implements java.io.Serializable{

	private static final long serialVersionUID = 5903392009265170374L;

	@Column(name="VIEWNUM")
    private int viewnum;
	@Column(name="DATETAG")
    private String datetag;

	public int getViewnum() {
		return viewnum;
	}

	public void setViewnum(int viewnum) {
		this.viewnum = viewnum;
	}

	public String getDatetag() {
		return datetag;
	}

	public void setDatetag(String datetag) {
		this.datetag = datetag;
	}
}
