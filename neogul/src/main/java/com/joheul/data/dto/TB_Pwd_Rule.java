package com.joheul.data.dto;

import java.io.Serializable;


public class TB_Pwd_Rule implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private int total = 0;
	 private int rule_1 = 0;
	 private int rule_2 = 0;
	 private int rule_3 = 0;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRule_1() {
		return rule_1;
	}

	public void setRule_1(int rule_1) {
		this.rule_1 = rule_1;
	}

	public int getRule_2() {
		return rule_2;
	}

	public void setRule_2(int rule_2) {
		this.rule_2 = rule_2;
	}

	public int getRule_3() {
		return rule_3;
	}

	public void setRule_3(int rule_3) {
		this.rule_3 = rule_3;
	}
}