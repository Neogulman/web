package com.neogul.data.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

public class TB_Contract_Manage   implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	 private int idx = 0;
	 private String contract_no = "";
	 private String contract_name = "";
	 private String contract_writer = "";
	 private String s_day = "";
	 private String e_day = "";
	 private String contract_admin = "";
	 private String contract_user = "";
	 private String contract_admin_name = "";
	 private String contract_user_name = "";
	 private String contract_contents = "";
	 private String status = "";
	 private String selected = "";
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getContract_writer() {
		return contract_writer;
	}

	public void setContract_writer(String contract_writer) {
		this.contract_writer = contract_writer;
	}

	public String getS_day() {
		return s_day;
	}

	public void setS_day(String s_day) {
		this.s_day = s_day;
	}

	public String getE_day() {
		return e_day;
	}

	public void setE_day(String e_day) {
		this.e_day = e_day;
	}

	public String getContract_admin() {
		return contract_admin;
	}

	public void setContract_admin(String contract_admin) {
		this.contract_admin = contract_admin;
	}

	public String getContract_user() {
		return contract_user;
	}

	public void setContract_user(String contract_user) {
		this.contract_user = contract_user;
	}
	public String getContract_admin_name() {
		return contract_admin_name;
	}

	public void setContract_admin_name(String contract_admin_name) {
		this.contract_admin_name = contract_admin_name;
	}

	public String getContract_user_name() {
		return contract_user_name;
	}

	public void setContract_user_name(String contract_user_name) {
		this.contract_user_name = contract_user_name;
	}
	public String getContract_contents() {
		return contract_contents;
	}

	public void setContract_contents(String contract_contents) {
		this.contract_contents = contract_contents;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String fnValidation(String type, HttpServletRequest req){
		//HttpSession session = req.getSession();
		//Language langu = (Language)session.getAttribute("langu");
		String val = "success";
		
		try{
			SortedMap<String,String[]> sMap = Collections.synchronizedSortedMap(new TreeMap<String,String[]>(req.getParameterMap()));
			synchronized(sMap){			
				for(String key : sMap.keySet()){
					String[] value = sMap.get(key);
					for(int i=0; i<value.length; i++){	
							if(key.equals("contract_name") && value[i].equals("")){
								val = "failure^계약명을 입력하세요.^-";
							}
							else if(key.equals("contract_no") && value[i].equals("")){
								val = "failure^계약번호를 입력하세요.^-";
							}
							else if(key.equals("s_day") && value[i].equals("")){
								val = "failure^계약 시작일을 선택하세요^-";
							}
							else if(key.equals("e_day") && value[i].equals("")){
								val = "failure^계약 종료일을 선택하세요^-";
							}
							else if(key.equals("contract_admin") && value[i].equals("")){
								val = "failure^관리자를 선택하세요^-";
							}
							else if(key.equals("contract_user") && value[i].equals("")){
								val = "failure^계약관계자를 선택하세요^-";
							}
							
					}
				}
			}
		}catch(Exception e){
			val = "Error : "+e.toString();
		}
		
		return val;
	}
	
	
}