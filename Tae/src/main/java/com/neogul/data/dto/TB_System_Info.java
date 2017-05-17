package com.neogul.data.dto;

import java.io.Serializable;

public class TB_System_Info  implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private String sip = "";
	 private String disk_free = "";
	 private String disk_use = "";
	 private String disk_age = "";
	 private String cpu = "";
	 private String memory = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSip() {
		return sip;
	}

	public void setSip(String sip) {
		this.sip = sip;
	}

	public String getDisk_free() {
		return disk_free;
	}

	public void setDisk_free(String disk_free) {
		this.disk_free = disk_free;
	}

	public String getDisk_use() {
		return disk_use;
	}

	public void setDisk_use(String disk_use) {
		this.disk_use = disk_use;
	}

	public String getDisk_age() {
		return disk_age;
	}

	public void setDisk_age(String disk_age) {
		this.disk_age = disk_age;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}
}