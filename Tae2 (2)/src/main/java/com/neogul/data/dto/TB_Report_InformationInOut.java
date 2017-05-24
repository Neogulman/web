package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class TB_Report_InformationInOut  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private int idx = 0;
	 private String s_day = "";
	 private String e_day = "";
	 private String equipment = "";
	 private String serial_number = "";
	 private String user = "";
	 private String contents = "";
	 private String input_day = "";
	 private String input_time = "";
	 private String output_day = "";
	 private String output_time = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getInput_day() {
		return input_day;
	}

	public void setInput_day(String input_day) {
		this.input_day = input_day;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}

	public String getOutput_day() {
		return output_day;
	}

	public void setOutput_day(String output_day) {
		this.output_day = output_day;
	}

	public String getOutput_time() {
		return output_time;
	}

	public void setOutput_time(String output_time) {
		this.output_time = output_time;
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
						if(key.equals("equipment") && value[i].equals("")){
							val = "failure^장비명을 입력하세요.^-";
						}
						else if(key.equals("serial_number") && value[i].equals("")){
							val = "failure^시리얼 번호를 입력하세요.^-";
						}
						else if(key.equals("user") && value[i].equals("")){
							val = "failure^사용자 이름을 입력하세요.^-";
						}
						else if(key.equals("input_day") && value[i].equals("") && value[i].length() != 10 ){
							val = "failure^입고 연월일을 입력하세요.^-";
						}
						else if(key.equals("output_day") && value[i].equals("") && value[i].length() != 10 ){
							val = "failure^출고 연월일을 입력하세요.^-";
						}
						else if(key.equals("contents") && value[i].equals("")){
							val = "failure^용도를 입력하세요.^-";
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