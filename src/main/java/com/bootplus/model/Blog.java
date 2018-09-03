package com.bootplus.model;


import com.bootplus.core.base.BaseModel;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "bolg")
public class Blog extends BaseModel implements java.io.Serializable{
	private static final long serialVersionUID = -5364474652996645555L;

	@Column(name="TITLE")
    private String title;

    @Column(name="SUMMARY")
    private String summary;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Column(name="CONTENT") 
    private String content;
    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Column(name="HTML_CONTENT") 
    private String htmlContent; // 将 md 转为 html
    //0草稿，1发布，2未发布，3禁用
    @Column(name="STATUS") 
    private String status;
    @Column(name="VIEW_NUM") 
    private int viewNum;
    @ManyToOne()
	@JoinColumn(name = "USER_ID", nullable=true)
    private User user;
    @ManyToOne()
	@JoinColumn(name = "CATEGORY", nullable=true)
    @NotFound(action=NotFoundAction.IGNORE)
    private Category category;
    @ManyToOne()
	@JoinColumn(name = "POSTER", nullable=true)
    @NotFound(action=NotFoundAction.IGNORE)
	private UFile poster;
    //是否开启评论，0关闭，1开启
    @Column(name="DISCUSS") 
    private String discuss;
    @Transient
    private String tags;
    //总的评论数
    @Transient
    private long commentNum;
    //是否包含未发布的评论，0不包含，1包含
    @Transient
    private String isNnPub;
    /**
     * 分类ID用于前后台传参
     */
    @Transient
    private String cateId;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public UFile getPoster() {
		return poster;
	}

	public void setPoster(UFile poster) {
		this.poster = poster;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getDiscuss() {
		return discuss;
	}

	public void setDiscuss(String discuss) {
		this.discuss = discuss;
	}

	public long getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(long commentNum) {
		this.commentNum = commentNum;
	}

	public String getIsNnPub() {
		return isNnPub;
	}

	public void setIsNnPub(String isNnPub) {
		this.isNnPub = isNnPub;
	}

	public int getViewNum() {
		return viewNum;
	}

	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}

}
