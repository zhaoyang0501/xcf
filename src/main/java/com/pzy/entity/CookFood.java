package com.pzy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_cookfood")
public class CookFood {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String number;
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name = "cookbook_id")
	private CookBook cookBook;
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
	public CookBook getCookBook() {
		return cookBook;
	}
	public void setCookBook(CookBook cookBook) {
		this.cookBook = cookBook;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
