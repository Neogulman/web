package com.neogul.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neogul.data.dto.TB_User_Info;

public class Session {
	
	/**
	 * Session Check
	 */
	public static boolean fnSessionCheck(HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		TB_User_Info sinfo = (TB_User_Info)session.getAttribute("sinfo");
		
		if(sinfo != null){
			return true;
		}
		else{
			session.invalidate();
			System.out.println("check Invalidate@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			return false;
		}
	}
	
	/**
	 * Session Info
	 */
	public static TB_User_Info fnSessionInfo(HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		TB_User_Info sinfo = (TB_User_Info)session.getAttribute("sinfo");
		
		return sinfo;
	}
}