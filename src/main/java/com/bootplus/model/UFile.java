package com.bootplus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bootplus.core.base.BaseModel;

@Entity
@Table(name = "file")
public class UFile extends BaseModel implements java.io.Serializable{
	private static final long serialVersionUID = 8000269281484407639L;
	@Column(name = "SHOWNAME")
    private String showName;
	@Column(name = "SUFFIX")
    private String suffix;
	@Column(name = "FILENAME")
    private String fileName;
	@Column(name = "TYPE")
    private String type;
	@Column(name = "PATH")
	private String path;
	@Column(name = "STATUS")
	private String status;
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
