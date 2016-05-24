package com.mkyong.stock;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class StockCategoryRoleId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Stock stock;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Role role;
    
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockCategoryRoleId that = (StockCategoryRoleId) o;

        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (role != null ? !role.equals(that.category) : that.role != null) return false;
        
        return true;
    }

    public int hashCode() {
        int result;
        result = (stock != null ? stock.hashCode() : 0);
        result = 13 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
    
}
