package com.mkyong.stock;

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
	
	@Column(name = "NAME", nullable = false, length = 10)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String desc;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.category", cascade=CascadeType.ALL)
	private List<StockCategoryRole> stockCategoryRoles = new ArrayList<StockCategoryRole>(0);

	public Category() {
	}

	public Category(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public Category(String name, String desc, List<StockCategoryRole> stockCategoryRoles) {
		this.name = name;
		this.desc = desc;
		this.stockCategoryRoles = stockCategoryRoles;
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

	public List<StockCategoryRole> getStockCategoryRoles() {
		return stockCategoryRoles;
	}

	public void setStockCategoryRoles(List<StockCategoryRole> stockCategoryRoles) {
		this.stockCategoryRoles = stockCategoryRoles;
	}	
}