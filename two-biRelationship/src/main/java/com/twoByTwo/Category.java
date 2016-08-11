package com.twoByTwo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", schema = "mkyongdb")
public class Category implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private Integer categoryId;
	
	@Column(name = "NAME", nullable = false, length = 100)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String desc;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="category", cascade=CascadeType.ALL)
	private List<StockCategory> stockCategories = new ArrayList<StockCategory>(0);

	public Category() {
	}

	public Category(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public Category(String name, String desc, List<StockCategory> stockCategories) {
		this.name = name;
		this.desc = desc;
		this.stockCategories = stockCategories;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public List<StockCategory> getStockCategories() {
		return this.stockCategories;
	}

	public void setStockCategories(List<StockCategory> stockCategories) {
		this.stockCategories = stockCategories;
	}
}