package com.neogul.data.dto;

import java.io.Serializable;


public class TB_Report_Auth  implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private String user_id = "";
	 private String type = "";
	 private int idx = 0;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}

	
}