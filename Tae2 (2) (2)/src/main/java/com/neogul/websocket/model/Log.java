package com.neogul.websocket.model;

import java.util.List;

public class Log {
	private String agent_id;
	private int work_key;
	private String 	user_id;
	private List<LogItem> rows;
	
	public String getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}
	public int getWork_key() {
		return work_key;
	}
	public void setWork_key(int work_key) {
		this.work_key = work_key;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<LogItem> getRows() {
		return rows;
	}
	public void setRows(List<LogItem> rows) {
		this.rows = rows;
	}
	
	

}
