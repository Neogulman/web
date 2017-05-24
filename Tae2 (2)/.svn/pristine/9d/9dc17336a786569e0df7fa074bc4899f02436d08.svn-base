package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class TB_Policy_Group  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private String grp_gubun = "";
	 private String grp_gubun_name = "";
	 private int grp_key = 0;
	 private int item_no = 0;
	 private String grp_key_str = "";
	 private String arr_item_no[] = null;
	 private String grp_name = "";
	 private String selected = "";
	 private String rdate = "";
	 private String mdate = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGrp_key_str() {
		return grp_key_str;
	}

	public void setGrp_key_str(String grp_key_str) {
		this.grp_key_str = grp_key_str;
	}

	public String getGrp_gubun() {
		return grp_gubun;
	}

	public void setGrp_gubun(String grp_gubun) {
		this.grp_gubun = grp_gubun;
	}

	public String getGrp_gubun_name() {
		return grp_gubun_name;
	}

	public void setGrp_gubun_name(String grp_gubun_name) {
		this.grp_gubun_name = grp_gubun_name;
	}

	public int getGrp_key() {
		return grp_key;
	}

	public void setGrp_key(int grp_key) {
		this.grp_key = grp_key;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public String[] getArr_item_no() {
		return arr_item_no;
	}

	public void setArr_item_no(String[] arr_item_no) {
		this.arr_item_no = arr_item_no;
	}

	public String getGrp_name() {
		return grp_name;
	}

	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
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

	public String fnValidation(HttpServletRequest req){
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
						if(key.equals("grp_name") && value[i].equals("")){
							val = "failure^"+langu.getTb_policy_group_1()+"^-";
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