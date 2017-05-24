package com.neogul.data.dto;

import java.io.Serializable;

public class TB_Config_Anony implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private String useYN = "";
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getUseYN() {
		return useYN;
	}


	public void setUseYN(String useYN) {
		this.useYN = useYN;
	}

	
}