package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TB_Product   implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private String rt_url = "";

	 private String agent_id = "";
	 private int work_key = 0;
	 private String work_name = "";
	 private String work_user_name = "";
	 private int icnt = 0;
	 private int pcnt = 0;
	 private int ccnt = 0;
	 private int mcnt = 0;	
	 private String nickname = "";
	 private String pc_mac = "";
	 private String pc_ip = "";
	 private String install_day = "";
	 private String connect_day = "";
	 private String user_id = "";
	 private String status = "";
	 private String contract_idx_str = "";
	 private String s_day = "";
	 private String e_day = "";
	 private String partition = "";
	
	 private int barcode=0;
	 private String name ="";
	 private int locationX=0;
	 private int locationY=0;
	 private int stock=0;
	 private int salesvolume=0;
	 private String type="";
	 private String brand="";
	 


	public String getPartition() {
		return partition;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getContract_idx_str() {
		return contract_idx_str;
	}

	public void setContract_idx_str(String contract_idx_str) {
		this.contract_idx_str = contract_idx_str;
	}

	public String getRt_url() {
		return rt_url;
	}
	
	public void setRt_url(String rt_url) {
		this.rt_url = rt_url;
	}
	
	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}
	
	public int getWork_key() {
		return work_key;
	}

	public void setWork_key(int work_key) {
		this.work_key = work_key;
	}

	public String getWork_user_name() {
		return work_user_name;
	}

	public void setWork_user_name(String work_user_name) {
		this.work_user_name = work_user_name;
	}

	public int getIcnt() {
		return icnt;
	}

	public void setIcnt(int icnt) {
		this.icnt = icnt;
	}

	public int getPcnt() {
		return pcnt;
	}

	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}

	public int getCcnt() {
		return ccnt;
	}

	public void setCcnt(int ccnt) {
		this.ccnt = ccnt;
	}

	public int getMcnt() {
		return mcnt;
	}

	public void setMcnt(int mcnt) {
		this.mcnt = mcnt;
	}

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPc_mac() {
		return pc_mac;
	}

	public void setPc_mac(String pc_mac) {
		this.pc_mac = pc_mac;
	}

	public String getPc_ip() {
		return pc_ip;
	}

	public void setPc_ip(String pc_ip) {
		this.pc_ip = pc_ip;
	}

	public String getInstall_day() {
		return install_day;
	}

	public void setInstall_day(String install_day) {
		this.install_day = install_day;
	}

	public String getConnect_day() {
		return connect_day;
	}

	public void setConnect_day(String connect_day) {
		this.connect_day = connect_day;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
	public String fnValidation(String type, HttpServletRequest req){
		
		
		String val = "success";
		
		HttpSession session = req.getSession();
		/*Language langu = (Language)session.getAttribute("langu");
		
		try{
			SortedMap<String,String[]> sMap = Collections.synchronizedSortedMap(new TreeMap<String,String[]>(req.getParameterMap()));
			synchronized(sMap){			
				for(String key : sMap.keySet()){
					String[] value = sMap.get(key);
					for(int i=0; i<value.length; i++){
						if(key.equals("name") && value[i].equals("")){
							if(type.equals("D")){
								val = "failure^"+langu.getTb_device_info_1()+"^-";
							}
							else if(type.equals("C")){
								val = "failure^"+langu.getTb_device_info_2()+"^-";
							}
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