package com.bootplus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bootplus.core.base.BaseModel;

/**
 * 
 * 资源
 */
@Entity
@Table(name = "resource", catalog = "boot")
public class Resource extends BaseModel implements java.io.Serializable{
	private static final long serialVersionUID = 4832981854919755967L;
		//上级
		@ManyToOne
		@JoinColumn(name = "PARENT_ID", nullable=true)
		private Resource parent;
		//名称
		@Column(name = "NAME", length =255)
		private String name;
		//类型,菜单，应用，服务
		@Column(name = "TYPE", length =255)
		private String type;
		//编码
		@Column(name = "CODE", length =255)
		private String code;
		//链接
		@Column(name = "LINK", length =255)
		private String link;
		//菜单图标
		@Column(name = "CLASS_CODE", length =255)
		private String classCode;
		//顺序
		@Column(name = "SEQ_NUM", length =11)
		private int seqNum;
		//状态
		@Column(name = "STATUS", length =1)
		private String status;
		//备注
		@Column(name = "COMMENTS", length =1500)
		private String comments;

		//子节点，不映射
		@Transient
		private List<Resource> childList = new ArrayList<Resource>();
		
		public Resource getParent() {
			return parent;
		}
		public void setParent(Resource parent) {
			this.parent = parent;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		
		public String getClassCode() {
			return classCode;
		}
		public void setClassCode(String classCode) {
			this.classCode = classCode;
		}
		
		public int getSeqNum() {
			return seqNum;
		}
		public void setSeqNum(int seqNum) {
			this.seqNum = seqNum;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public List<Resource> getChildList() {
			return childList;
		}

		public void setChildList(List<Resource> childList) {
			this.childList = childList;
		}
}
