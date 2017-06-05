package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;


public class TB_Saleslist   implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	
	




	public int getBanana() {
		return banana;
	}









	public void setBanana(int banana) {
		this.banana = banana;
	}









	public int getPhone() {
		return phone;
	}









	public void setPhone(int phone) {
		this.phone = phone;
	}









	public int getKnife() {
		return knife;
	}









	public void setKnife(int knife) {
		this.knife = knife;
	}









	public int getCider() {
		return cider;
	}









	public void setCider(int cider) {
		this.cider = cider;
	}









	public int getApple() {
		return apple;
	}









	public void setApple(int apple) {
		this.apple = apple;
	}









	public int getCable() {
		return cable;
	}









	public void setCable(int cable) {
		this.cable = cable;
	}









	public int getHighhill() {
		return highhill;
	}









	public void setHighhill(int highhill) {
		this.highhill = highhill;
	}









	public int getMouse() {
		return mouse;
	}









	public void setMouse(int mouse) {
		this.mouse = mouse;
	}









	public int getDoll() {
		return doll;
	}









	public void setDoll(int doll) {
		doll = doll;
	}









	public int getPencil() {
		return pencil;
	}









	public void setPencil(int pencil) {
		this.pencil = pencil;
	}









	private int banana =0;
	private int phone =0;
	private int knife =0;
	private int cider =0;
	private int apple =0;
	private int cable =0;
	private int highhill =0;
	private int mouse =0;
	private int doll =0;
	private int pencil =0;
	
	




	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	

	
	public String fnValidation(String type, HttpServletRequest req){
		
		
		String val = "success";
		
		//HttpSession session = req.getSession();
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