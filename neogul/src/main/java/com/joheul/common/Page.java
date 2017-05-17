package com.joheul.common;

public class Page {
	
	private int currentPage = 1;
	private int pageSize = 10;
	private int pageBlock = 10;
	private int pageTotal = 0;
	
	private int sRow = 0;
	private int eRow = 0;
	
	private String sort = "";
	
	public void fnPage(int pageNum){ 
		currentPage = pageNum;
		sRow = (currentPage-1)*pageSize;
		eRow = pageSize; 
	}
	 
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageBlock() {
		return pageBlock;
	}
	
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	
	public int getPageTotal() {
		return pageTotal;
	}
	
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	public int getsRow() {
		return sRow;
	}

	public void setsRow(int sRow) {
		this.sRow = sRow;
	}

	public int geteRow() {
		return eRow;
	}

	public void seteRow(int eRow) {
		this.eRow = eRow;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	} 
}