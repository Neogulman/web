package com.neogul.data.dto;

import java.io.Serializable;

public class TB_Version_Info implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String version;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}