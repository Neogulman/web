package com.joheul.data.dto;

import java.io.Serializable;




public class TB_Pwd_Modify_History  implements Serializable {
	
	private static final long serialVersionUID = 1L;

		
	 private int idx = 0;	
	 private String user_id = "";
	 private String user_name = "";
	 private String muser_id = "";
	 private String muser_name = "";
	 private String m_day = "";
	

	
	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
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



	public String getMuser_id() {
		return muser_id;
	}



	public void setMuser_id(String muser_id) {
		this.muser_id = muser_id;
	}



	public String getMuser_name() {
		return muser_name;
	}



	public void setMuser_name(String muser_name) {
		this.muser_name = muser_name;
	}



	public String getM_day() {
		return m_day;
	}



	public void setM_day(String m_day) {
		this.m_day = m_day;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}