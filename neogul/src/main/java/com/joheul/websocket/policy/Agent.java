
package com.joheul.websocket.policy;


import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joheul.data.dao.Device_Info_Dao;
import com.joheul.data.dao.Operation_Info_Dao;
import com.joheul.data.dao.User_Info_Dao;
import com.joheul.data.dto.TB_Config_Movie;
import com.joheul.data.dto.TB_Device_Info;
import com.joheul.data.dto.TB_Operation_Info;
import com.joheul.data.dto.TB_Policy_Item;
import com.joheul.data.dto.TB_User_Info;
import com.joheul.websocket.model.AgentControl;
import com.joheul.websocket.model.AgentID;
import com.joheul.websocket.model.DeviceInfo;
import com.joheul.websocket.model.Echo;
import com.joheul.websocket.model.OperationInfo;
import com.joheul.websocket.model.PolicyItem;
import com.joheul.websocket.model.PolicyMovie;

enum SND_MSG {
	ECHO,
	AGENT_ID,
	POLICY,
	BLOCKING,
	NOT_LIC, 
	OUT_POLICY
}

enum AGENT_UPDATE {
	INSTALL,
	UPDATE,
}


public class Agent {

    private final int id;
    private final WebSocketSession session;
    

	private final Device_Info_Dao dDao;
    private final Operation_Info_Dao oDao;
    private final User_Info_Dao uDao;
    
    private String agent_id;
    private String pc_mac;
    private String pc_ip;
	private String user_id;
	private int work_key = -1;
	private String inOut = "I"; //I:in, O:out
    
    public WebSocketSession getSession() {
		return session;
	}
    
    public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}


    public Agent(int id, WebSocketSession session, Device_Info_Dao dDao, Operation_Info_Dao oDao, User_Info_Dao uDao ) {
        this.id = id;
        this.session = session;
        this.dDao = dDao;
        this.oDao = oDao;
        this.uDao = uDao;
    }

    public void kill(SND_MSG msg) {
        sendMessage(msg);
        updateOperationStatus("Y");
    }
    
    public void update(String msg) throws Exception {
        
    	ObjectMapper mapper = new ObjectMapper();
    	DeviceInfo jsonDeviceInfo = mapper.readValue(msg, DeviceInfo.class);
    	
    	//parse message
    	if(jsonDeviceInfo.getM_type()==2){ 
    		agent_id = jsonDeviceInfo.getAgent_id();
    		pc_mac = jsonDeviceInfo.getPc_mac();
    		pc_ip = jsonDeviceInfo.getPc_ip();
    		user_id = jsonDeviceInfo.getUser_id();
    		
    		if(agent_id.isEmpty()){
    			agent_id = "JOHEUL-"+DateUtil.fnToDay("yyyyMMddHHmmss")+"-"+pc_ip;
    			
    			if(updateDeviceStatus(AGENT_UPDATE.INSTALL, "S")){
    				sendMessage(SND_MSG.AGENT_ID);
    			}
    		}else { 
    			if(updateDeviceStatus(AGENT_UPDATE.UPDATE, "S")){
    			//	sendMessage(SND_MSG.AGENT_ID);
    				sendMessage(SND_MSG.POLICY);
    				updateOperationStatus("S");
    			}
    		}
    	}
    }

	protected boolean updateOperationStatus(String status) {
		
		if(getWork_key() <= 0) return false;
		
		boolean result = false;
		TB_Operation_Info vo = new TB_Operation_Info();
		
		vo.setStatus(status);
		vo.setWork_key(getWork_key());
		try {
			if(oDao.fnUpdateStatus(vo)==1){
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	protected boolean updateDeviceStatus(AGENT_UPDATE type, String status) {
		boolean result = false;
		
		if(getAgent_id()== null /*|| getStatus().equals("B") */ ) return false;
		
		TB_Device_Info vo = new TB_Device_Info();
		vo.setAgent_id(agent_id);
		vo.setPc_mac(pc_mac);
		vo.setPc_ip(pc_ip);
		vo.setUser_id(user_id);
		vo.setStatus(status);
		
		if(type == AGENT_UPDATE.INSTALL){
			
			try {
				if(dDao.fnInsert(vo)==1){
					result = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(type == AGENT_UPDATE.UPDATE){
			try {
				if(dDao.fnUpdate(vo)==1){
					result = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
    

	private TB_Operation_Info getPolicy() {
    	TB_Operation_Info result=null;
		TB_Operation_Info vo = new TB_Operation_Info();
		
		vo.setAgent_id(agent_id);
		vo.setWork_user_id(user_id);
		//vo.setWork_key(work_key);
		
		try {
			result=oDao.fnSelectOne(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


/*	private  String getStatus(){
    	String result = null;
    	TB_Device_Info vo = new TB_Device_Info();
    	vo.setAgent_id(agent_id);
    	try {
			vo=dDao.fnSelectOne(vo);
			result = vo.getStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }*/


    protected void sendMessage(SND_MSG type)  {
    	String msg="";
    	//1. make message
    	switch(type){
    	case ECHO: //통신상태 체크 전송
    	{
    		Echo echo = new Echo();
    		ObjectMapper mapper = new ObjectMapper();
    		
    		echo.setEcho("OK");
    		
    		//msg = "{"echo": "OK"}";
    		try {
				msg = mapper.writeValueAsString(echo);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    	}
    		break;
    	case AGENT_ID: //agent_id 전송
    	{
    		/*msg = String.format("{'return_result': 'success','return_message':'success','m_type':1,'agent_id':'%s'}",
					agent_id);*/
    		AgentID agentID = new AgentID();
    		ObjectMapper mapper = new ObjectMapper();
    		
    		agentID.setReturn_result("success");
    		agentID.setReturn_message("success");
    		agentID.setM_type(1);
    		agentID.setAgent_id(agent_id);
    		
    		try {
				msg = mapper.writeValueAsString(agentID);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    		break;
    	case POLICY: //정책 전송
    	{
    		TB_Operation_Info po;
    		OperationInfo oi = new OperationInfo();
			po = getPolicy();
			
			if(po != null){
				oi.setReturn_result("success");
				oi.setReturn_message("success");
				oi.setM_type(3);
				oi.setWork_key(po.getWork_key());
				oi.setType(po.getType());
				oi.setUser_id(po.getWork_user_id());
				oi.setS_day(po.getS_day());
				oi.setE_day(po.getE_day());
				oi.setServer_group(getGroupItems(po.getServer_group()));
				oi.setCommand_group(getGroupItems(po.getCommand_group()));
				oi.setProgram_group(getGroupItems(po.getProgram_group()));
				oi.setPolicy_movie(getMovieConfig());
				oi.setProgram_type(po.getProgram_type());
				oi.setPolicy_usb(po.getPolicy_usb());
				oi.setPolicy_1394(po.getPolicy_1394());
				oi.setPolicy_pcmcia(po.getPolicy_pcmcia());
				oi.setPolicy_serial(po.getPolicy_serial());
				oi.setPolicy_bluetooth(po.getPolicy_bluetooth());
				oi.setPolicy_parallel(po.getPolicy_parallel());
				oi.setPolicy_irda(po.getPolicy_irda());
				oi.setPolicy_wibro(po.getPolicy_wibro());
				oi.setPolicy_floppy(po.getPolicy_floppy());
				oi.setPolicy_cdrom(po.getPolicy_cdrom());
				oi.setPolicy_wireless(po.getPolicy_wireless());
				oi.setPolicy_share_folder(po.getPolicy_share_folder());
				oi.setPolicy_networkdisk_out(po.getPolicy_networkdisk_out());
				oi.setPolicy_folder_permission(po.getPolicy_folder_permission());
				oi.setPolicy_usb_cable(po.getPolicy_usb_cable());
				oi.setPolicy_local_disk(po.getPolicy_local_disk());
				
				//반출 정책일 경우 user의 패스워드도 전송해야 함.
				/*if(oi.getType() == "O"){
					oi.setPw(getPassword(oi.getUser_id()));
				}else{
					oi.setPw("");
				}*/
				oi.setPw("");	
				
				ObjectMapper mapper = new ObjectMapper();
	            try {
					msg = mapper.writeValueAsString(oi);
					setWork_key(oi.getWork_key());
					setInOut(oi.getType());
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
    	}
    		break;
    	case OUT_POLICY:
    	{
    		TB_Operation_Info po;
    		OperationInfo oi = new OperationInfo();
			po = getOutPolicy();
			
			if(po != null){
				oi.setReturn_result("success");
				oi.setReturn_message("success");
				oi.setM_type(3);
				oi.setWork_key(po.getWork_key());
				oi.setType(po.getType());
				oi.setUser_id(po.getWork_user_id());
				oi.setS_day(po.getS_day());
				oi.setE_day(po.getE_day());
				oi.setServer_group(getGroupItems(po.getServer_group()));
				oi.setCommand_group(getGroupItems(po.getCommand_group()));
				oi.setProgram_group(getGroupItems(po.getProgram_group()));
				oi.setPolicy_movie(getMovieConfig());
				oi.setProgram_type(po.getProgram_type());
				oi.setPolicy_usb(po.getPolicy_usb());
				oi.setPolicy_1394(po.getPolicy_1394());
				oi.setPolicy_pcmcia(po.getPolicy_pcmcia());
				oi.setPolicy_serial(po.getPolicy_serial());
				oi.setPolicy_bluetooth(po.getPolicy_bluetooth());
				oi.setPolicy_parallel(po.getPolicy_parallel());
				oi.setPolicy_irda(po.getPolicy_irda());
				oi.setPolicy_wibro(po.getPolicy_wibro());
				oi.setPolicy_floppy(po.getPolicy_floppy());
				oi.setPolicy_cdrom(po.getPolicy_cdrom());
				oi.setPolicy_wireless(po.getPolicy_wireless());
				oi.setPolicy_share_folder(po.getPolicy_share_folder());
				oi.setPolicy_networkdisk_out(po.getPolicy_networkdisk_out());
				oi.setPolicy_folder_permission(po.getPolicy_folder_permission());
				oi.setPolicy_usb_cable(po.getPolicy_usb_cable());
				oi.setPolicy_local_disk(po.getPolicy_local_disk());
				
				//반출 정책일 경우 user의 패스워드도 전송해야 함.
				oi.setPw(getPassword(oi.getUser_id()));
				
				ObjectMapper mapper = new ObjectMapper();
	            try {
					msg = mapper.writeValueAsString(oi);
					setWork_key(oi.getWork_key());
					setInOut(oi.getType());
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
    		
    	}
    		break;
    	case BLOCKING: //차단 전송
    	{
    		AgentControl agentCtl = new AgentControl();
    		ObjectMapper mapper = new ObjectMapper();
    		agentCtl.setReturn_result("success");
    		agentCtl.setReturn_message("관리자가 PC 사용 중지 명령을 전달하였습니다. 관리자에게 문의 바랍니다");
    		agentCtl.setM_type(4);
    		agentCtl.setCommand("block");
    		
    		try {
				msg = mapper.writeValueAsString(agentCtl);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		//msg = "{'return_result': 'success','return_message':'관리자가 PC 사용 중지 명령을 전달하였습니다. 관리자에게 문의 바랍니다','m_type':4,'command':'block'}";

    	}
    		break;
    	case NOT_LIC: //라이센스초과
    	{
    		AgentControl agentCtl = new AgentControl();
    		ObjectMapper mapper = new ObjectMapper();
    		agentCtl.setReturn_result("success");
    		agentCtl.setReturn_message("라이센스가 초과되었습니다. 관리자에게 문의 바랍니다");
    		agentCtl.setM_type(4);
    		agentCtl.setCommand("not-lic");
    		
    		try {
				msg = mapper.writeValueAsString(agentCtl);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    		//msg = "{'return_result': 'success','return_message':'라이센스가 초과되었습니다. 관리자에게 문의 바랍니다','m_type':4,'command':'not-lic'}";
    		break;
    	default:
    		System.out.println(String.format("[Error] : %d message type not support",msg ));
    			
    	}
    	//2. send message
    	
    	try {
    		if(!msg.isEmpty()){
    			session.sendMessage(new TextMessage(msg));
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private TB_Operation_Info getOutPolicy() {
	// TODO Auto-generated method stub
    	TB_Operation_Info result=null;
		TB_Operation_Info vo = new TB_Operation_Info();
		
		vo.setAgent_id(agent_id);
		vo.setWork_user_id(user_id);
		//vo.setWork_key(work_key);
		
		try {
			result=oDao.fnSelectOutOne(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
}

	private String getPassword(String user_id) {
		// TODO Auto-generated method stub
    	String ret = "";
    	TB_User_Info tb_user = new TB_User_Info();
    	tb_user.setUser_id(user_id);
    	
    	try {
			tb_user = uDao.fnUserPw(tb_user);
			ret = tb_user.getUser_pwd();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

    private PolicyMovie getMovieConfig() {
		PolicyMovie movie = new PolicyMovie();
		TB_Config_Movie tb_movie = new TB_Config_Movie();
		try {
			tb_movie=oDao.fnMovie(tb_movie);
			movie.setSend(tb_movie.getSend());
			movie.setTime(tb_movie.getTime());
			movie.setScreen(tb_movie.getScreen());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}


	private PolicyItem getGroupItems( String group) {
    	PolicyItem result = new PolicyItem();
    	TB_Policy_Item vo = new TB_Policy_Item();
    	vo.setGrp_key_str(group);
    	
    	try {
			result.setItem_commands(oDao.fnSelectPolicyItem(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public int getId() {
        return id;
    }


	public void sendPolicy() {
		sendMessage(SND_MSG.POLICY);
		if(getInOut().equals("O")){ //반출메세지일 경우
			updateDeviceStatus(AGENT_UPDATE.UPDATE, "O");
		}
		updateOperationStatus("S");
	}

	public int getWork_key() {
		return work_key;
	}

	public void setWork_key(int work_key) {
		this.work_key = work_key;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public void updateDeviceStatusAll() {
		try {
			dDao.fnUpdateStatusAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendOutPolicy() {
		sendMessage(SND_MSG.OUT_POLICY);
		
	}
}
