package com.joheul.data.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

public class TB_Result_Report  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	


	 private int idx = 0;
	 private int plan_idx = 0;
	 private String plan_type;
	 private String report_writer; //작업분야
	 private String report_name; //작업분야
	 private String write_day = "";
	 private String s_day = "";
	 private String e_day = "";
	 private String req_dept = ""; //작성자
	 private String per_dept = ""; //요청부서
	 private String supervisor_id = ""; //수행부서
	 private String worker_id = ""; //감독자
	 private String supervisor_name = ""; //작업 수행자
	 private String worker_name = ""; //작업내용
	 private String report_contents = ""; //비고
	 private String report_note = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private int app_turn = 0; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_id = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_name = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private int app_total = 0; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_status = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_time = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPlan_type() {
		return plan_type;
	}



	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}

	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public int getPlan_idx() {
		return plan_idx;
	}



	public void setPlan_idx(int plan_idx) {
		this.plan_idx = plan_idx;
	}



	public String getReport_writer() {
		return report_writer;
	}



	public void setReport_writer(String report_writer) {
		this.report_writer = report_writer;
	}



	public String getReport_name() {
		return report_name;
	}



	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}



	public String getWrite_day() {
		return write_day;
	}



	public void setWrite_day(String write_day) {
		this.write_day = write_day;
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



	public String getReq_dept() {
		return req_dept;
	}



	public void setReq_dept(String req_dept) {
		this.req_dept = req_dept;
	}



	public String getPer_dept() {
		return per_dept;
	}



	public void setPer_dept(String per_dept) {
		this.per_dept = per_dept;
	}



	public String getSupervisor_id() {
		return supervisor_id;
	}



	public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}



	public String getWorker_id() {
		return worker_id;
	}



	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}



	public String getSupervisor_name() {
		return supervisor_name;
	}



	public void setSupervisor_name(String supervisor_name) {
		this.supervisor_name = supervisor_name;
	}



	public String getWorker_name() {
		return worker_name;
	}



	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}



	public String getReport_contents() {
		return report_contents;
	}



	public void setReport_contents(String report_contents) {
		this.report_contents = report_contents;
	}



	public String getReport_note() {
		return report_note;
	}



	public void setReport_note(String report_note) {
		this.report_note = report_note;
	}



	public int getApp_turn() {
		return app_turn;
	}



	public void setApp_turn(int app_turn) {
		this.app_turn = app_turn;
	}



	public String getApp_id() {
		return app_id;
	}



	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}



	public String getApp_name() {
		return app_name;
	}



	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}



	public int getApp_total() {
		return app_total;
	}



	public void setApp_total(int app_total) {
		this.app_total = app_total;
	}



	public String getApp_status() {
		return app_status;
	}



	public void setApp_status(String app_status) {
		this.app_status = app_status;
	}



	public String getApp_time() {
		return app_time;
	}



	public void setApp_time(String app_time) {
		this.app_time = app_time;
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
							if(key.equals("plan_idx") && value[i].equals("0")){
								val = "failure^계획서명을 선택하세요.^-";
							}
							else if(key.equals("app_id") && value[i].equals("")){
								val = "failure^결재자를 선택하세요.^-";
							}
							if(key.equals("report_name") && value[i].equals("")){
								val = "failure^제목을 입력하세요.^-";
							}
							else if(key.equals("s_day") && value[i].equals("")){
								val = "failure^작업 시작일을 선택하세요^-";
							}
							else if(key.equals("e_day") && value[i].equals("")){
								val = "failure^작업 종료일을 선택하세요^-";
							}
							else if(key.equals("report_contents") && value[i].equals("")){
								val = "failure^작업내용을  입력하세요^-";
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