
package com.joheul.websocket.logs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joheul.data.dao.Operation_Log_Dao;
import com.joheul.data.dto.TB_Operation_Log;
import com.joheul.websocket.model.Log;
import com.joheul.websocket.model.LogItem;


public class DefaultLogService implements LogService {

	private final String echoFormat;
	
	
	@Autowired
	@Lazy
	private Operation_Log_Dao dao=null;

	@Autowired
	public DefaultLogService(String echoFormat) {
		this.echoFormat = (echoFormat != null) ? echoFormat : "%s";
	}

	@Override
	public String getMessage(String message) {
		return String.format(this.echoFormat, message);
	}

	@Override
	public synchronized void  saveLogs(String message) {
		List<TB_Operation_Log> dbLogs = new ArrayList<TB_Operation_Log>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			Log jsonLogs = mapper.readValue(message, Log.class);
			
			String agent_id = jsonLogs.getAgent_id();
			int work_key = jsonLogs.getWork_key();
			String user_id = jsonLogs.getUser_id();
			List<LogItem> logItems = jsonLogs.getRows();
			
			for(LogItem item: logItems){
				TB_Operation_Log dbLog = new TB_Operation_Log();
				dbLog.setAgent_id(agent_id);
				dbLog.setWork_key(work_key);
				dbLog.setUser_id(user_id);
				dbLog.setType(item.getType());
				dbLog.setRemote_ip(item.getRemote_ip());
				dbLog.setEvent_day(item.getEvent_day());
				dbLog.setResult(item.getResult());
				dbLog.setEvent(item.getEvent());
				dbLog.setInout_type(item.getInout_type());
				
				dbLogs.add(dbLog);
			}
			try {
				this.dao.fnInsertLogs(dbLogs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
