package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class TB_User_Entrust  implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private int idx = 0;
	 private int user_level = 0;
	 private String day = "";
	 private String user_id = "";
	 private String user_name = "";
	 private String user_id_entrust = "";
	 private String user_name_entrust = "";
	 private String s_day = "";
	 private String e_day = "";
	 private String status = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

	public String getUser_id_entrust() {
		return user_id_entrust;
	}

	public void setUser_id_entrust(String user_id_entrust) {
		this.user_id_entrust = user_id_entrust;
	}

	public String getUser_name_entrust() {
		return user_name_entrust;
	}

	public void setUser_name_entrust(String user_name_entrust) {
		this.user_name_entrust = user_name_entrust;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
						if(key.equals("user_id_entrust") && value[i].equals("")){
							val = "failure^"+langu.getTb_user_entrust_1()+"^-";
						}
						else if(key.equals("s_day") && value[i].equals("")){
							val = "failure^"+langu.getTb_user_entrust_2()+"^-";
						}
						else if(key.equals("e_day") && value[i].equals("")){
							val = "failure^"+langu.getTb_user_entrust_3()+"^-";
						}
					}	
				}
			}
		}catch(Exception e){
			val = "Error : "+e.toString();
		}*/
		
		return val;
	}
}