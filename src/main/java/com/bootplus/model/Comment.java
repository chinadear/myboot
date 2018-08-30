package com.bootplus.model;


import com.bootplus.core.base.BaseModel;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "comment")
public class Comment extends BaseModel implements java.io.Serializable{

	private static final long serialVersionUID = 5443314253076254087L;
	@Column(name="COMMENT")
    private String comment;
    @ManyToOne()
	@JoinColumn(name = "ARTICAL", nullable=true)
    private Blog artical;
    //1发布，0未发布，物理删除
    @Column(name="STATUS") 
    private String status;
    @ManyToOne()
	@JoinColumn(name = "USER", nullable=true)
    @NotFound(action=NotFoundAction.IGNORE)
    private User user;
    @Column(name="SCREENNAME") 
    private String screenname;
    /*@Transient
    private String cateId;*/
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Blog getArtical() {
		return artical;
	}
	public void setArtical(Blog artical) {
		this.artical = artical;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
    
}
