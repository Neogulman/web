package com.joheul.data.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

public class TB_Fault_Report  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	


	 private int idx = 0;
	 private String contract_name; //계약명번호
	 private int facility_type = 0; //작업분야번호
	 private String fault_key = "";
	 private String writer = "";
	 private String facility_name = "";
	 private String fault_record = "";
	 private String write_day = "";
	 private String s_day = ""; //작업일시 시작
	 private String e_day = ""; //작업일시 끝
	 private String recovery_day = ""; //작성자
	 private String supervisor_id = ""; //수행부서
	 private String worker_id = ""; //감독자
	 private String supervisor_name = ""; //작업 수행자
	 private String worker_name = ""; //작업내용
	 private String fault_cause = ""; //비고
	 private String result = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String after_plan = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private int app_turn = 0; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_id = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_name = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private int app_total = 0; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_status = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	 private String app_time = ""; //결재상태 F:미결재, I:결재중, Y:결재완료
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getContract_name() {
		return contract_name;
	}



	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}



	public int getFacility_type() {
		return facility_type;
	}



	public void setFacility_type(int facility_type) {
		this.facility_type = facility_type;
	}



	public String getFault_key() {
		return fault_key;
	}



	public void setFault_key(String fault_key) {
		this.fault_key = fault_key;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getFacility_name() {
		return facility_name;
	}



	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	

	public String getFault_record() {
		return fault_record;
	}



	public void setFault_record(String fault_record) {
		this.fault_record = fault_record;
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



	public String getRecovery_day() {
		return recovery_day;
	}



	public void setRecovery_day(String recovery_day) {
		this.recovery_day = recovery_day;
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



	public String getFault_cause() {
		return fault_cause;
	}



	public void setFault_cause(String fault_cause) {
		this.fault_cause = fault_cause;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public String getAfter_plan() {
		return after_plan;
	}



	public void setAfter_plan(String after_plan) {
		this.after_plan = after_plan;
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
							if(key.equals("contract_name") && value[i].equals("0")){
								val = "failure^계약명을 선택하세요.^-";
							}
							else if(key.equals("app_id") && value[i].equals("")){
								val = "failure^결재자를 선택하세요.^-";
							}
							else if(key.equals("facility_type") && value[i].equals("0")){
								val = "failure^설비분야를 선택하세요^-";
							}
							else if(key.equals("facility_name") && value[i].equals("")){
								val = "failure^설비명을 입력하세요.^-";
							}
							else if(key.equals("s_day") && value[i].equals("")){
								val = "failure^장애일시(장애발생시간)를 선택하세요^-";
							}
							else if(key.equals("e_day") && value[i].equals("")){
								val = "failure^장애일시(장애종료시간)를 선택하세요^-";
							}
							else if(key.equals("recovery_day") && value[i].equals("")){
								val = "failure^복구일시를 선택하세요^-";
							}
							else if(key.equals("supervisor_id") && value[i].equals("")){
								val = "failure^담당자를 선택하세요^-";
							}
							else if(key.equals("worker_id") && value[i].equals("")){
								val = "failure^장애조치자를 선택하세요^-";
							}
							else if(key.equals("fault_cause") && value[i].equals("")){
								val = "failure^장애원인을  입력하세요^-";
							}
							else if(key.equals("result") && value[i].equals("")){
								val = "failure^조치결과를  입력하세요^-";
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