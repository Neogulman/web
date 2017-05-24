package com.neogul.websocket.model;

public class DeviceInfo {
	private int m_type;
	private String agent_id;
	private String pc_mac;
	private String pc_ip;
	private String user_id;
	
	public int getM_type() {
		return m_type;
	}
	public void setM_type(int m_type) {
		this.m_type = m_type;
	}
	public String getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}
	public String getPc_mac() {
		return pc_mac;
	}
	public void setPc_mac(String pc_mac) {
		this.pc_mac = pc_mac;
	}
	public String getPc_ip() {
		return pc_ip;
	}
	public void setPc_ip(String pc_ip) {
		this.pc_ip = pc_ip;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
