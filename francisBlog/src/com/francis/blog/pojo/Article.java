package com.francis.blog.pojo;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class Article {
	private Integer id;
	private String title;
	private User user;
	private Timestamp post_date;
	private ArticleType articleType;
	private String content;
	private Set<TagsType> tagsType;  //int [] translate to string
	private Integer state;  //article show or hide
	private Integer allow_comments;  //0 allowed 1 not 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@ManyToOne(fetch= FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getPost_date() {
		return post_date;
	}
	public void setPost_date(Timestamp post_date) {
		this.post_date = post_date;
	}
	
	@ManyToOne(fetch= FetchType.LAZY)
	public ArticleType getArticleType() {
		return articleType;
	}
	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToMany
	@JoinTable(name="article_tagstype",
			joinColumns={@JoinColumn(name="article_id")},
			inverseJoinColumns={@JoinColumn(name="tagstype_id")}
			)
	public Set<TagsType> getTagsType() {
		return tagsType;
	}
	public void setTagsType(Set<TagsType> tagsType) {
		this.tagsType = tagsType;
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
