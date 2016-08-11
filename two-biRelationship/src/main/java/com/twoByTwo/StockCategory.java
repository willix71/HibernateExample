package com.twoByTwo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "stock_category", schema = "mkyongdb")
@AssociationOverrides({
		@AssociationOverride(name = "pk.stock", joinColumns = @JoinColumn(name = "STOCK_ID")),
		@AssociationOverride(name = "pk.category", joinColumns = @JoinColumn(name = "CATEGORY_ID")) })
public class StockCategory implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_CATEGORY_ID", unique = true, nullable = false)
	private Integer stockCategoryId;
	
	@ManyToOne
	@JoinColumn(name="STOCK_ID")
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
    private Category category;
    	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "CREATED_BY", nullable = false, length = 10)
	private String createdBy;
	
	@ManyToMany
	@JoinTable(name = "stock_category_role", schema = "mkyongdb", 
		joinColumns={@JoinColumn(name="STOCK_CATEGORY_ID")}, 
		inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
	private List<Role> roles;
	
	public StockCategory() {
	}

	public Integer getStockCategoryId() {
		return stockCategoryId;
	}

	public void setStockCategoryId(Integer stockCategoryId) {
		this.stockCategoryId = stockCategoryId;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}