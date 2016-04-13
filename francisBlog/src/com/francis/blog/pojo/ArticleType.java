package com.francis.blog.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="articletype")
public class ArticleType {
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
	@OneToMany(mappedBy="articleType",
			fetch= FetchType.LAZY)
	public Set<Article> getArticle() {
		return article;
	}
	public void setArticle(Set<Article> article) {
		this.article = article;
	}
}
