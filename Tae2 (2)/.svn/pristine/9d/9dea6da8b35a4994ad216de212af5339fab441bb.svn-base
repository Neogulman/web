package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;


public class TB_Policy_Item  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private int item_no = 0;
	 private String grp_key_str = "";
	 private String gubun = "";
	 private String gubun_name = "";
	 private String item_name = "";
	 private String item_command = "";
	 private String selected = "";
	 private String url_yn = "";
	 private String rdate = "";
	 private String mdate = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public String getGrp_key_str() {
		return grp_key_str;
	}

	public void setGrp_key_str(String grp_key_str) {
		this.grp_key_str = grp_key_str;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getGubun_name() {
		return gubun_name;
	}

	public void setGubun_name(String gubun_name) {
		this.gubun_name = gubun_name;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_command() {
		return item_command;
	}

	public void setItem_command(String item_command) {
		this.item_command = item_command;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getUrl_yn() {
		return url_yn;
	}

	public void setUrl_yn(String url_yn) {
		this.url_yn = url_yn;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String fnValidation(String type, HttpServletRequest req){
		
		String val = "success";
		/*
		HttpSession session = req.getSession();
		Language langu = (Language)session.getAttribute("langu");
		
		
		try{
			SortedMap<String,String[]> sMap = Collections.synchronizedSortedMap(new TreeMap<String,String[]>(req.getParameterMap()));
			synchronized(sMap){			
				for(String key : sMap.keySet()){
					String[] value = sMap.get(key);
					for(int i=0; i<value.length; i++){
						if(key.equals("item_name") && value[i].equals("")){
							langu.setTb_policy_item_1(type);
							val = "failure^"+langu.getTb_policy_item_1()+"^-";
						}
						else if(key.equals("item_command") && value[i].equals("")){
							langu.setTb_policy_item_2(type);
							val = "failure^"+langu.getTb_policy_item_2()+"^-";
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