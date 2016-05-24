package com.mkyong.stock;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", schema = "mkyongdb")
public class Role implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	private Integer roleId;
	
	@Column(name = "ROLE_NAME", unique = true, nullable = false, length = 10)
	private String name;

	@ManyToMany
	@JoinTable(name = "stock_category_role", schema = "mkyongdb", 
		joinColumns={@JoinColumn(name="ROLE_ID")}, 
		inverseJoinColumns={@JoinColumn(name="STOCK_CATEGORY_ID")})
	private List<StockCategory> stockCatgeory;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StockCategory> getStockCatgeory() {
		return stockCatgeory;
	}

	public void setStockCatgeory(List<StockCategory> stockCatgeory) {
		this.stockCatgeory = stockCatgeory;
	}
}
