
package com.neogul.websocket.policy;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.neogul.data.dao.Device_Info_Dao;
import com.neogul.data.dao.Operation_Info_Dao;
import com.neogul.data.dao.User_Info_Dao;

public class PolicyWebSocketHandler extends TextWebSocketHandler {

	@Autowired
	@Lazy
	Device_Info_Dao dDao;
	
	@Autowired
	@Lazy
	Operation_Info_Dao oDao;
	
	@Autowired
	@Lazy
	User_Info_Dao uDao;
	
	 @Autowired
	 ServletContext context;
	
	
    private static final AtomicInteger agentIds = new AtomicInteger(0);

    private final int id;
    private Agent agent;

    public PolicyWebSocketHandler() {
        this.id = agentIds.getAndIncrement();
    }
    

    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.agent = new Agent(id, session, dDao, oDao, uDao);
        AgentHandler.addAgent(agent);
        AgentHandler.chkLicense(agent, context);
    }


    @Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message)  {
    	String payload = message.getPayload();
    	try {
			agent.update(payload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        agent.updateDeviceStatus(AGENT_UPDATE.UPDATE, "Y");
        agent.updateOperationStatus("Y");
    	AgentHandler.removeAgent(agent);
        System.out.println(String.format("{'type': 'leave', 'id': %d}",
                Integer.valueOf(id)));
    }


	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		agent.updateDeviceStatus(AGENT_UPDATE.UPDATE, "Y");
		agent.updateOperationStatus("Y");
		AgentHandler.removeAgent(agent);
		super.handleTransportError(session, exception);
	}
    
}
