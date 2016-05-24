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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", schema = "mkyongdb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	private Integer stockId;
	
	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	private String stockCode;
	
	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	private String stockName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade=CascadeType.ALL)
	private List<StockCategory> stockCategories = new ArrayList<StockCategory>(0);

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(String stockCode, String stockName,
			List<StockCategory> stockCategories) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockCategories = stockCategories;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public List<StockCategory> getStockCategories() {
		return this.stockCategories;
	}

	public void setStockCategories(List<StockCategory> stockCategories) {
		this.stockCategories = stockCategories;
	}
}