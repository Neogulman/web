package com.neogul.data.dto;

import java.io.Serializable;

public class TB_Type_Seq  implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private int idx = 0;
	 private String type = "";
	 private int seq = 0;
	 private String year = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}