package com.francis.blog.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TagsType {
	private Integer id;
	private String name;
	private Set<Article> article;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany(mappedBy="tagsType")
	public Set<Article> getArticle() {
		return article;
	}
	public void setArticle(Set<Article> article) {
		this.article = article;
	}
}
