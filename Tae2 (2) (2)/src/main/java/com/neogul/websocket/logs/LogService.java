package com.neogul.websocket.logs;

public interface LogService {

	String getMessage(String message);
	void saveLogs(String message);

}
