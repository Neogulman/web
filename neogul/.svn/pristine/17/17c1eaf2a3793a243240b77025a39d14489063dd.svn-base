package com.joheul.common;

public class StringUtil {
	/**
	 * 특정 문자 치환
	 */
	public static String fnReplace(String str){
		
		String tmp = "";
		
		try{
			byte byt[] = str.getBytes();
		
			for(int i = 0; i<byt.length; i++){
				if(byt[i] == 92){	// \
					byt[i] = 47;
				}
			}
			tmp = new String(byt, 0, byt.length);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
		return tmp;
	}
}
