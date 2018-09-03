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
/**
 * 字典项
 * @author liulu
 *
 */
@Entity
@Table(name = "dic_item")
public class DicItem extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1179826966625405976L;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CODE")
	private String code;
	@ManyToOne()
	@JoinColumn(name = "DIC", nullable=true)
	private Dic dic;
	@Column(name = "SORT")
	private int sort;
	@Column(name = "COMMENTS")
	private String comments;
	//状态0，删除，1正常
	@Column(name = "STATUS")
	private String status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Dic getDic() {
		return dic;
	}
	public void setDic(Dic dic) {
		this.dic = dic;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}
