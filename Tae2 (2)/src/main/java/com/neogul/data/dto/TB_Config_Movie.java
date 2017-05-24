package com.neogul.data.dto;

import java.io.Serializable;

public class TB_Config_Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private String send = "";
	 private String time = "";
	 private String screen = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}
}