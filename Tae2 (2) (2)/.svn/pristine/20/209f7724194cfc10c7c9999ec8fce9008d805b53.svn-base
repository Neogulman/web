package com.neogul.websocket.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Log messages by implementing a Spring {@link WebSocketHandler} abstraction.
 */
public class LogWebSocketHandler extends TextWebSocketHandler {
	
	private LogService logService;
	
	@Autowired
	public LogWebSocketHandler(DefaultLogService defaultLogService) {
		this.logService = defaultLogService;
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		this.logService.saveLogs(message.getPayload());
		//String reply = this.logService.getMessage(message.getPayload());
		//session.sendMessage(new TextMessage(reply));
		
	}

}
