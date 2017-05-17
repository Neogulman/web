package com.joheul.data.dto;

import java.io.Serializable;

public class TB_User_Info_History implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private int idx = 0;	
	 private String day = "";
	 private String view_level = "";
	 private String user_id = "";
	 private String user_name = "";
	 private String change_user_id = "";
	 private String change_user_name = "";
	 private String event = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getView_level() {
		return view_level;
	}

	public void setView_level(String view_level) {
		this.view_level = view_level;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getChange_user_id() {
		return change_user_id;
	}

	public void setChange_user_id(String change_user_id) {
		this.change_user_id = change_user_id;
	}

	public String getChange_user_name() {
		return change_user_name;
	}

	public void setChange_user_name(String change_user_name) {
		this.change_user_name = change_user_name;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
}