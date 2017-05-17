package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class TB_Report_Information  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private int idx = 0;
	 private String mrg_no = "";
	 private String s_day = "";
	 private String e_day = "";
	 private String type = "";
	 private String user = "";
	 private String host_ip = "";
	 private String security = "";
	 private String reg_day = "";
	 private String rem_day = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMrg_no() {
		return mrg_no;
	}

	public void setMrg_no(String mrg_no) {
		this.mrg_no = mrg_no;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getHost_ip() {
		return host_ip;
	}

	public void setHost_ip(String host_ip) {
		this.host_ip = host_ip;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getReg_day() {
		return reg_day;
	}

	public void setReg_day(String reg_day) {
		this.reg_day = reg_day;
	}

	public String getRem_day() {
		return rem_day;
	}

	public void setRem_day(String rem_day) {
		this.rem_day = rem_day;
	}
	// 2016.11.23 bhahn2013 add : START -----------------------------------
	public String fnValidation(HttpServletRequest req){
		String val = "success";
		
		/*HttpSession session = req.getSession();
		Language langu = (Language)session.getAttribute("langu");
	
		
		try{ 
			SortedMap<String,String[]> sMap = Collections.synchronizedSortedMap(new TreeMap<String,String[]>(req.getParameterMap()));
			synchronized(sMap){			
				for(String key : sMap.keySet()){
					String[] value = sMap.get(key);
					for(int i=0; i<value.length; i++){
						if(key.equals("user") && value[i].equals("")){
							val = "failure^취급자 이름을 입력하세요.^-";
						}
						else if(key.equals("type") && value[i].equals("")){
							val = "failure^종류를 선택하세요.^-";
						}
						else if(key.equals("host_ip") && value[i].equals("")){
							val = "failure^네트워크 IP를 입력하세요.^-";
						}
						else if(key.equals("security") && value[i].equals("")){
							val = "failure^정보보호 SW 이름를 입력하세요.^-";
						}
						else if(key.equals("reg_day") && value[i].equals("") && value[i].length() != 10 ){
							val = "failure^등록 일자를 입력하세요.^-";
						}
 						else if(key.equals("rem_day") && value[i].equals("") && value[i].length() != 10 ){
							val = "failure^해제 일자를 입력하세요.^-";
						}
					}	
				}
			}			
		}catch(Exception e){
			val = "Error : "+e.toString();
		}*/
		
		return val;
	}	
	// 2016.11.23 bhahn2013 add : END   -----------------------------------	
}