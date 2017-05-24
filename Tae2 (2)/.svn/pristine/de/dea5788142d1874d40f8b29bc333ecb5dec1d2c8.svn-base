package com.neogul.websocket.video;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neogul.data.dao.Operation_Movie_Dao;
import com.neogul.websocket.model.MovieLog;

public class VideoWebSocketHandler extends AbstractWebSocketHandler
 {
	public static final boolean JMETER_TEST=true; //FIXME: 부하테스트 용(릴리즈시 반드시 false가 되어야 함)
	
	private String path = "C:\\Temp\\video\\server\\"; //TODO : 서버 환경에 맞게 변경해야 함.
    private String filename = "test";
    private int work_key;
    private String s_day;
    private String e_day;
    private String sessionId;

    @Autowired
    @Lazy
	private Operation_Movie_Dao dao=null;


	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
        System.out.println("WebSocket Closed......\n");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("Video WebSocket Opened......\n");
	}
	
	@Override
    protected void handleTextMessage(WebSocketSession session,
            TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
     //   System.out.println("sessionId-1:" + session.getId());        
        MovieLog log = new MovieLog();
        sessionId = session.getId();
        ObjectMapper mapper = new ObjectMapper();
        try{
	        MovieLog jsonLog = mapper.readValue(message.getPayload(), MovieLog.class);
	        work_key = jsonLog.getWork_key();
	        s_day = jsonLog.getS_day();
	        e_day = jsonLog.getE_day();
	        filename = jsonLog.getFile();
	        
	        if(JMETER_TEST){
	        	String fullPath = this.getClass().getClassLoader().getResource("").getPath();
	        	String pathArr[] = fullPath.split("WEB-INF/classes/");
	        	path = pathArr[0];
	        	
	        	System.out.println("path:" + path);
		        System.out.println("wokr_key:" + work_key);
		        System.out.println("s_day:" + s_day);
		        System.out.println("e_day:" + e_day);
		        System.out.println("filename:" + filename);
		        
		        File tFile = new File(path + "test.h264");
		        FileInputStream fis = null;
		        FileOutputStream fos = null;
		        int i = 0;
		        
		        try{
		        	fis = new FileInputStream(tFile);
		        	fos = new FileOutputStream(path + filename+".h264");
		        	
		        	do
		        	{
		        		i = fis.read();
		        		fos.write((char) i);
		        		
		        	} while(i != -1);
		        
		        	
		        	fis.close();
		        	fos.close();
		        
		        }catch (Exception e){
		        	e.printStackTrace();
		        }
	        }
	        
        } catch (JsonParseException e){
        	e.printStackTrace();
        }
        
      
    }


	 /**
     * 파일 업로드
     * 기본 버퍼 사이즈가 8192바이트 인데 초기 설정 때 버퍼사이즈를 정해 줄 수 있다.
     * 버퍼 사이즈를 넘어가게 되면 웹소켓은 close 된다.
     */

    @Override
    protected void handleBinaryMessage(WebSocketSession session,
            BinaryMessage message) {
    	   System.out.println("sessionId-2:" + session.getId()); 
    	if(!sessionId.equals(session.getId())) return;
    	
        ByteBuffer payload = message.getPayload();
        File file = new File(path+filename);
        
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

			while (payload.hasRemaining()) {
				bos.write(payload.get());
			}
			
			//TODO : DB에 메타 정보 insert

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    

    @Override
    protected void handlePongMessage(WebSocketSession session,
            PongMessage message) throws Exception {
        // TODO Auto-generated method stub
        super.handlePongMessage(session, message);
        System.out.println();
        System.out.println("handlePongMessage");        
        System.out.println();
    }





	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
      
	}

	
	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
