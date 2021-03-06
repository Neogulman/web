package com.joheul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class TB_Operation_Info  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private int work_key=0;
	 private String type = "";
	 private String ask_user_id = "";
	 private String ask_user_name = "";	
	 private int ask_user_dept = 0;
	 private String ask_user_dept_name = "";	
	 private String ask_respons = "";
	 private String ask_day = "";
	 private String work_name = "";
	 private String s_day = "";
	 private String e_day = "";
	 private String agent_id = "";	
	 private String agent_ip = "";	
	 private String agent_name = "";	
	 private String work_user_id = "";
	 private String work_user_name = "";
	 private String server_group = "";
	 private String command_group = "";
	 private String program_group = "";
	 private String program_type = "";
	 private String payment_user_id = "";
	 private String payment_user_name = "";	
	 private String payment_request = "";
	 private String payment_status = "";
	 private String payment_day = "";
	 private String policy_usb = "";
	 private String policy_1394 = "";
	 private String policy_pcmcia = "";
	 private String policy_serial = "";
	 private String policy_bluetooth = "";
	 private String policy_parallel = "";
	 private String policy_irda = "";
	 private String policy_wibro = "";
	 private String policy_floppy = "";
	 private String policy_cdrom = "";
	 private String policy_lan = "";
	 private String policy_wireless = "";
	 private String policy_share_folder = "";
	 private String policy_networkdisk_out = "";
	 private String policy_folder_permission = "";
	 private String policy_usb_cable = "";
	 private String policy_local_disk = "";
	 private String manager_id = "";
	 private String report = "";
	 private String status = "";
	 private String contract_idx_str = "";	
	 private int contract_idx = 0;
	 private int sy = 0;
	 private int sm = 0;
	 private int sd = 0;
	 private int sh = 0;
	 private int ss = 0;
	
	 private int ey = 0;
	 private int em = 0;
	 private int ed = 0;
	 private int eh = 0;
	 private int es = 0;	
	 private String url = "";
	 private String day = "";

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getUrl() {
		return url;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWork_key() {
		return work_key;
	}
	
	public String getContract_idx_str() {
		return contract_idx_str;
	}

	public void setContract_idx_str(String contract_idx_str) {
		this.contract_idx_str = contract_idx_str;
	}

	public void setWork_key(int work_key) {
		this.work_key = work_key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAsk_user_id() {
		return ask_user_id;
	}

	public void setAsk_user_id(String ask_user_id) {
		this.ask_user_id = ask_user_id;
	}

	public String getAsk_user_name() {
		return ask_user_name;
	}

	public void setAsk_user_name(String ask_user_name) {
		this.ask_user_name = ask_user_name;
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

	public String getAsk_respons() {
		return ask_respons;
	}

	public void setAsk_respons(String ask_respons) {
		this.ask_respons = ask_respons;
	}

	public String getAsk_day() {
		return ask_day;
	}

	public void setAsk_day(String ask_day) {
		this.ask_day = ask_day;
	}

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
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

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getAgent_ip() {
		return agent_ip;
	}

	public void setAgent_ip(String agent_ip) {
		this.agent_ip = agent_ip;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getWork_user_id() {
		return work_user_id;
	}

	public void setWork_user_id(String work_user_id) {
		this.work_user_id = work_user_id;
	}

	public String getWork_user_name() {
		return work_user_name;
	}

	public void setWork_user_name(String work_user_name) {
		this.work_user_name = work_user_name;
	}

	public String getServer_group() {
		return server_group;
	}

	public void setServer_group(String server_group) {
		this.server_group = server_group;
	}

	public String getCommand_group() {
		return command_group;
	}

	public void setCommand_group(String command_group) {
		this.command_group = command_group;
	}

	public String getProgram_group() {
		return program_group;
	}

	public void setProgram_group(String program_group) {
		this.program_group = program_group;
	}

	public String getProgram_type() {
		return program_type;
	}

	public void setProgram_type(String program_type) {
		this.program_type = program_type;
	}

	public String getPayment_user_id() {
		return payment_user_id;
	}

	public void setPayment_user_id(String payment_user_id) {
		this.payment_user_id = payment_user_id;
	}

	public String getPayment_user_name() {
		return payment_user_name;
	}

	public void setPayment_user_name(String payment_user_name) {
		this.payment_user_name = payment_user_name;
	}

	public String getPayment_request() {
		return payment_request;
	}

	public void setPayment_request(String payment_request) {
		this.payment_request = payment_request;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getPayment_day() {
		return payment_day;
	}

	public void setPayment_day(String payment_day) {
		this.payment_day = payment_day;
	}

	public String getPolicy_usb() {
		return policy_usb;
	}

	public void setPolicy_usb(String policy_usb) {
		this.policy_usb = policy_usb;
	}

	public String getPolicy_1394() {
		return policy_1394;
	}

	public void setPolicy_1394(String policy_1394) {
		this.policy_1394 = policy_1394;
	}

	public String getPolicy_pcmcia() {
		return policy_pcmcia;
	}

	public void setPolicy_pcmcia(String policy_pcmcia) {
		this.policy_pcmcia = policy_pcmcia;
	}

	public String getPolicy_serial() {
		return policy_serial;
	}

	public void setPolicy_serial(String policy_serial) {
		this.policy_serial = policy_serial;
	}

	public String getPolicy_bluetooth() {
		return policy_bluetooth;
	}

	public void setPolicy_bluetooth(String policy_bluetooth) {
		this.policy_bluetooth = policy_bluetooth;
	}

	public String getPolicy_parallel() {
		return policy_parallel;
	}

	public void setPolicy_parallel(String policy_parallel) {
		this.policy_parallel = policy_parallel;
	}

	public String getPolicy_irda() {
		return policy_irda;
	}

	public void setPolicy_irda(String policy_irda) {
		this.policy_irda = policy_irda;
	}

	public String getPolicy_wibro() {
		return policy_wibro;
	}

	public void setPolicy_wibro(String policy_wibro) {
		this.policy_wibro = policy_wibro;
	}

	public String getPolicy_floppy() {
		return policy_floppy;
	}

	public void setPolicy_floppy(String policy_floppy) {
		this.policy_floppy = policy_floppy;
	}

	public String getPolicy_cdrom() {
		return policy_cdrom;
	}

	public void setPolicy_cdrom(String policy_cdrom) {
		this.policy_cdrom = policy_cdrom;
	}

	public String getPolicy_lan() {
		return policy_lan;
	}

	public void setPolicy_lan(String policy_lan) {
		this.policy_lan = policy_lan;
	}

	public String getPolicy_wireless() {
		return policy_wireless;
	}

	public void setPolicy_wireless(String policy_wireless) {
		this.policy_wireless = policy_wireless;
	}

	public String getPolicy_share_folder() {
		return policy_share_folder;
	}

	public void setPolicy_share_folder(String policy_share_folder) {
		this.policy_share_folder = policy_share_folder;
	}

	public String getPolicy_networkdisk_out() {
		return policy_networkdisk_out;
	}

	public void setPolicy_networkdisk_out(String policy_networkdisk_out) {
		this.policy_networkdisk_out = policy_networkdisk_out;
	}

	public String getPolicy_folder_permission() {
		return policy_folder_permission;
	}

	public void setPolicy_folder_permission(String policy_folder_permission) {
		this.policy_folder_permission = policy_folder_permission;
	}

	public String getPolicy_usb_cable() {
		return policy_usb_cable;
	}

	public void setPolicy_usb_cable(String policy_usb_cable) {
		this.policy_usb_cable = policy_usb_cable;
	}

	public String getPolicy_local_disk() {
		return policy_local_disk;
	}

	public void setPolicy_local_disk(String policy_local_disk) {
		this.policy_local_disk = policy_local_disk;
	}
	
	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public int getSm() {
		return sm;
	}

	public void setSm(int sm) {
		this.sm = sm;
	}

	public int getSd() {
		return sd;
	}

	public void setSd(int sd) {
		this.sd = sd;
	}

	public int getSh() {
		return sh;
	}

	public void setSh(int sh) {
		this.sh = sh;
	}

	public int getSs() {
		return ss;
	}

	public void setSs(int ss) {
		this.ss = ss;
	}

	public int getEy() {
		return ey;
	}

	public void setEy(int ey) {
		this.ey = ey;
	}

	public int getEm() {
		return em;
	}

	public void setEm(int em) {
		this.em = em;
	}

	public int getEd() {
		return ed;
	}

	public void setEd(int ed) {
		this.ed = ed;
	}

	public int getEh() {
		return eh;
	}

	public void setEh(int eh) {
		this.eh = eh;
	}

	public int getEs() {
		return es;
	}

	public void setEs(int es) {
		this.es = es;
	}
	
	public int getContract_idx() {
		return contract_idx;
	}

	public void setContract_idx(int contract_idx) {
		this.contract_idx = contract_idx;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String fnValidation(int user_level, String payment_status, HttpServletRequest req){
		String val = "success";
		
		/*HttpSession session = req.getSession();
		Language langu = (Language)session.getAttribute("langu");
	
		
		try{ 
			SortedMap<String,String[]> sMap = Collections.synchronizedSortedMap(new TreeMap<String,String[]>(req.getParameterMap()));
			synchronized(sMap){			
				for(String key : sMap.keySet()){
					String[] value = sMap.get(key);
					for(int i=0; i<value.length; i++){
						if(key.equals("ask_respons") && value[i].equals("")){
							val = "failure^"+langu.getTb_operation_info_1()+"^-";
						}
						else if(key.equals("work_name") && value[i].equals("")){
							val = "failure^"+langu.getTb_operation_info_2()+"^-";
						}
						else if(key.equals("work_user_id") && value[i].equals("")){
							val = "failure^"+langu.getWork_user_select()+"^-";
						}
						else if(key.equals("agent_id") && value[i].equals("0")){
							val = "failure^"+langu.getTb_operation_info_3()+"^-";
						}
						else if(key.equals("contract_idx") && value[i].equals("0")){
							val = "failure^계약 정보을 선택하세요.^-";
						}
						else if(key.equals("s_day") && value[i].equals("")){
							val = "failure^"+langu.getTb_operation_info_4()+"^-";
						}
						else if(key.equals("e_day") && value[i].equals("")){
							val = "failure^"+langu.getTb_operation_info_5()+"^-";
						}
						else if(key.equals("server_group") && value[i].equals("")){
							val = "failure^"+"접속 허용 IP 그룹을 선택하세요"+"^-";
						}
						else if(key.equals("command_group") && value[i].equals("")){
							val = "failure^"+"차단 명령어 그룹을 선택하세요"+"^-";
						}
						else if(key.equals("program_group") && value[i].equals("")){
							val = "failure^"+"차단 프로그램 그룹을 선택하세요"+"^-";
						}
						
						if(user_level == 1 || user_level == 9){
							if(key.equals("payment_status") && value[i].equals("")){
								val = "failure^"+langu.getTb_operation_info_6()+"^-";
							}

						}
						
						if(user_level != 9){
							if(key.equals("payment_user_id") && value[i].equals("")){
								val = "failure^결재자을 선택하세요.^-";
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