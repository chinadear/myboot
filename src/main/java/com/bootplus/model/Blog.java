package com.bootplus.model;


import com.bootplus.core.base.BaseModel;

import javax.persistence.*;

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
    //0草稿，1发布，2封禁
    @Column(name="STATUS") 
    private String status;
    @ManyToOne()
	@JoinColumn(name = "USER_ID", nullable=true)
    public User user;
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
}
