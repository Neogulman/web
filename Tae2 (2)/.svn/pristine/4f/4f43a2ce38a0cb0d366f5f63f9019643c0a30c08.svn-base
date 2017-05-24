package com.neogul.data.dto;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class TB_Security_Board  {
	private CommonsMultipartFile file = null;
	 private int idx = 0;
	 private String title = "";
	 private String contents = "";
	 private String report_month = "";
	 private String org_file = "";
	 private String save_file = "";
	 private String rdate = "";
	 private String ask_user_id="";
	 private int ask_user_dept=0;
	 private String ask_user_dept_name="";
	 private String ask_user_name="";
	 private String app_id="";
	 private String app_name="";
	 private int app_dept=0;
	 private int user_level=0;
	 private int manager_dept=0;

	 private String app_dept_name="";
	 private String app_status="";
	 private String app_date="";
	 private String path="";
	 private String status="";
	 private String s_day="";
	 private String e_day="";

	 private String user_id="";

	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getAsk_user_id() {
		return ask_user_id;
	}


	public void setAsk_user_id(String ask_user_id) {
		this.ask_user_id = ask_user_id;
	}


	public int getAsk_user_dept() {
		return ask_user_dept;
	}


	public void setAsk_user_dept(int ask_user_dept) {
		this.ask_user_dept = ask_user_dept;
	}


	public String getAsk_user_dept_name() {
		return ask_user_dept_name;
	}


	public void setAsk_user_dept_name(String ask_user_dept_name) {
		this.ask_user_dept_name = ask_user_dept_name;
	}


	public String getAsk_user_name() {
		return ask_user_name;
	}


	public void setAsk_user_name(String ask_user_name) {
		this.ask_user_name = ask_user_name;
	}


	public void setApp_dept_name(String app_dept_name) {
		this.app_dept_name = app_dept_name;
	}


	public int getApp_dept() {
		return app_dept;
	}



	public void setApp_dept(int app_dept) {
		this.app_dept = app_dept;
	}

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



	public String getReport_month() {
		return report_month;
	}



	public void setReport_month(String report_month) {
		this.report_month = report_month;
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






	public String getApp_id() {
		return app_id;
	}



	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}



	public String getApp_status() {
		return app_status;
	}



	public void setApp_status(String app_status) {
		this.app_status = app_status;
	}



	public String getApp_date() {
		return app_date;
	}



	public void setApp_date(String app_date) {
		this.app_date = app_date;
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




	public String getApp_name() {
		return app_name;
	}



	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	



	public String getApp_dept_name() {
		return app_dept_name;
	}
	
	
	public int getUser_level() {
		return user_level;
	}



	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
	
	



	


	
	public CommonsMultipartFile getFile() {
		return file;
	}



	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	
	public int getManager_dept() {
		return manager_dept;
	}


	public void setManager_dept(int manager_dept) {
		this.manager_dept = manager_dept;
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
						else if(key.equals("app_status") && value[i].equals("0")){
							val = "failure^결재 상태를 선택하세요^-";
						}
						else if(key.equals("report_month") && value[i].equals("")){
							val = "failure^보고 연월을 입력하세요^-";
						}
						else if(key.equals("status") && value[i].equals("0")){
							val = "failure^공개범위를 선택하세요.^-";
						}
						else if(key.equals("app_id") && value[i].equals("")){
							val = "failure^결재자를 선택하세요.^-";
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