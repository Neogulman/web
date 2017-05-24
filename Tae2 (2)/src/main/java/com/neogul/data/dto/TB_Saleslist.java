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









	public int getApple() {
		return apple;
	}









	public void setApple(int apple) {
		this.apple = apple;
	}









	public int getPencil() {
		return pencil;
	}









	public void setPencil(int pencil) {
		this.pencil = pencil;
	}









	public int getEraser() {
		return eraser;
	}









	public void setEraser(int eraser) {
		this.eraser = eraser;
	}









	public int getCoke() {
		return coke;
	}









	public void setCoke(int coke) {
		this.coke = coke;
	}









	public int getCider() {
		return cider;
	}









	public void setCider(int cider) {
		this.cider = cider;
	}









	public int getWallet() {
		return wallet;
	}









	public void setWallet(int wallet) {
		this.wallet = wallet;
	}









	public int getHighhill() {
		return highhill;
	}









	public void setHighhill(int highhill) {
		this.highhill = highhill;
	}









	public int getArduino() {
		return arduino;
	}









	public void setArduino(int arduino) {
		this.arduino = arduino;
	}









	public int getMouse() {
		return mouse;
	}









	public void setMouse(int mouse) {
		this.mouse = mouse;
	}








	private int banana =0;
	private int apple =0;
	private int pencil =0;
	private int eraser =0;
	private int coke =0;
	private int cider =0;
	private int wallet =0;
	private int highhill =0;
	private int arduino =0;
	private int mouse =0;
	
	




	


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