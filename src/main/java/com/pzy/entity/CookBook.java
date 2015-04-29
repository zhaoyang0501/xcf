package com.pzy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_cookbook")
public class CookBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String remark;
	private String imgPath;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cookBook")
	private List<CookStep> cookSteps;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	private CategorySub categorySub;
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategorySub getCategorySub() {
		return categorySub;
	}

	public void setCategorySub(CategorySub categorySub) {
		this.categorySub = categorySub;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public List<CookStep> getCookSteps() {
		return cookSteps;
	}

	public void setCookSteps(List<CookStep> cookSteps) {
		this.cookSteps = cookSteps;
	}
}
