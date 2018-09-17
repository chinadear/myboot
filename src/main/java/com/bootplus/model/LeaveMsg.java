package com.bootplus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.bootplus.core.base.BaseModel;
/**
 * 留言
 * @author liulu
 *
 */
@Entity
@Table(name = "leavemsg")
public class LeaveMsg extends BaseModel implements Serializable {
	private static final long serialVersionUID = -8258172301850629128L;
	@Column(name = "IP")
	private String ip;
	@Column(name = "MESSAGE")
	private String message;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
