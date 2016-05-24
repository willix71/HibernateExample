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
@Table(name = "role", schema = "mkyongdb")
public class Role implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	private Integer roleId;
	
	@Column(name = "ROLE_NAME", unique = true, nullable = false, length = 10)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.role", cascade=CascadeType.ALL)
	private List<StockCategoryRole> stockCategoryRoles = new ArrayList<StockCategoryRole>(0);
	
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

	public List<StockCategoryRole> getStockCategoryRoles() {
		return stockCategoryRoles;
	}

	public void setStockCategoryRoles(List<StockCategoryRole> stockCategoryRoles) {
		this.stockCategoryRoles = stockCategoryRoles;
	}

}
