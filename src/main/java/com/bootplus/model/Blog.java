package com.bootplus.model;


import com.bootplus.core.base.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "bolg")
public class Blog extends BaseModel implements java.io.Serializable{
	private static final long serialVersionUID = -5364474652996645555L;

	@Column(name="title") // 映射为字段，值不能为空
    private String title;

    @Column(name="summary")// 映射为字段，值不能为空
    private String summary;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Column(name="content") // 映射为字段，值不能为空
    private String content;
    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Column(name="html_content") // 映射为字段，值不能为空
    private String htmlContent; // 将 md 转为 html

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


}
