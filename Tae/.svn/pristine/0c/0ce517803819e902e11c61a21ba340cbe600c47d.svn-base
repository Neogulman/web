package com.neogul.data.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.neogul.ui.util.Availability;


public class Product implements Serializable {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private int id = -1;
	    private int version;
	    private String productName = "";
	    private int stockCount = 0;
	    private Availability availability = Availability.COMING;
		private BigDecimal price = BigDecimal.ZERO;
	    private Set<Category> category = new HashSet<>();
	    
	    
	    public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public Set<Category> getCategory() {
			return category;
		}
		public void setCategory(Set<Category> category) {
			this.category = category;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getVersion() {
			return version;
		}
		public void setVersion(int version) {
			this.version = version;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getStockCount() {
			return stockCount;
		}
		public void setStockCount(int stockCount) {
			this.stockCount = stockCount;
		}
		public Availability getAvailability() {
			return availability;
		}
		public void setAvailability(Availability availability) {
			this.availability = availability;
		}

}
