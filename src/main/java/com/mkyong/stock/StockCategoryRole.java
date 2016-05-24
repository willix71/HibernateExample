package com.mkyong.stock;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "stock_category_role", schema = "mkyongdb")
@AssociationOverrides({
		@AssociationOverride(name = "pk.stock", 
			joinColumns = @JoinColumn(name = "STOCK_ID")),
		@AssociationOverride(name = "pk.category", 
			joinColumns = @JoinColumn(name = "CATEGORY_ID")),
		@AssociationOverride(name = "pk.role", 
			joinColumns = @JoinColumn(name = "ROLE_ID"))
		})
public class StockCategoryRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private StockCategoryRoleId pk = new StockCategoryRoleId();

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	private Date createdDate;
	
	@Column(name = "CREATED_BY", nullable = false, length = 10)
	private String createdBy;
	
	public StockCategoryRole() {
	}

	public StockCategoryRoleId getPk() {
		return pk;
	}

	public void setPk(StockCategoryRoleId pk) {
		this.pk = pk;
	}

	@Transient
	public Stock getStock() {
		return getPk().getStock();
	}

	public void setStock(Stock stock) {
		getPk().setStock(stock);
	}

	@Transient
	public Category getCategory() {
		return getPk().getCategory();
	}

	public void setCategory(Category category) {
		getPk().setCategory(category);
	}

	@Transient
	public Role getRole() {
		return getPk().getRole();
	}

	public void setRole(Role role) {
		getPk().setRole(role);
	}

	
	public String getCreatedBy() {
		return this.createdBy;
	}	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		StockCategoryRole that = (StockCategoryRole) o;

		if (getPk() != null ? !getPk().equals(that.getPk()): that.getPk() != null) return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}