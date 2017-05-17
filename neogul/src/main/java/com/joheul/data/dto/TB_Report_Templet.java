package com.joheul.data.dto;

import java.io.Serializable;


public class TB_Report_Templet  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 private int work_key = 0;	
	 private int idx = 0;
	 private String title = "";
	 private String content = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getWork_key() {
		return work_key;
	}

	public void setWork_key(int work_key) {
		this.work_key = work_key;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}