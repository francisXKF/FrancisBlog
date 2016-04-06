package com.francis.blog.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	private Integer id;
	private String title;
	private Integer author_id;
	private Timestamp post_date;
	private Integer articletype_id;
	private String content;
	private String tags_id;  //int [] translate to string
	private Integer state;  //article show or hide
	private Integer allow_comments;  //0 allowed 1 not 
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}
	public Timestamp getPost_date() {
		return post_date;
	}
	public void setPost_date(Timestamp post_date) {
		this.post_date = post_date;
	}
	public Integer getArticletype_id() {
		return articletype_id;
	}
	public void setArticletype_id(Integer articletype_id) {
		this.articletype_id = articletype_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTags_id() {
		return tags_id;
	}
	public void setTags_id(String tags_id) {
		this.tags_id = tags_id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getAllow_comments() {
		return allow_comments;
	}
	public void setAllow_comments(Integer allow_comments) {
		this.allow_comments = allow_comments;
	}
}
