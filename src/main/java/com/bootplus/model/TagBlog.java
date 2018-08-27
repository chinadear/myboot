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
@Table(name = "tagblog")
public class TagBlog extends BaseModel implements Serializable {
	private static final long serialVersionUID = -8599044396771887894L;
	@ManyToOne()
	@JoinColumn(name = "TAG", nullable=true)
    private Tag tag;
	@ManyToOne()
	@JoinColumn(name = "BLOG", nullable=true)
    private Blog blog;
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
}
