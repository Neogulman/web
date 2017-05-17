package com.neogul.data.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class TB_Data_Board  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idx = 0;
	private String title = "";
	private String contents = "";
	private String org_file = "";
	private String save_file = "";
	private String rdate = "";
	private String user_id="";
	private String path="";
	private String status="";
	private String type="";
	private String s_day="";
	private String e_day="";


	

	




	private CommonsMultipartFile file = null;



	


	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public String getOrg_file() {
		return org_file;
	}



	public void setOrg_file(String org_file) {
		this.org_file = org_file;
	}



	public String getSave_file() {
		return save_file;
	}



	public void setSave_file(String save_file) {
		this.save_file = save_file;
	}



	public String getRdate() {
		return rdate;
	}



	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public CommonsMultipartFile getFile() {
		return file;
	}



	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	
	
	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}

	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
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
						if(key.equals("title") && value[i].equals("")){
							val = "failure^제목을 입력하세요^-";
						}
						else if(key.equals("contents") && value[i].equals("")){
							val = "failure^내용을 입력하세요^-";
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