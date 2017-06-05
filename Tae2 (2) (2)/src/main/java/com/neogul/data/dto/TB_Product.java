package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;


public class TB_Product   implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	
	
	 public int getBarcode() {
		return barcode;
	}




	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getLocationX() {
		return locationX;
	}




	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}




	public int getLocationY() {
		return locationY;
	}




	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}




	public int getStock() {
		return stock;
	}




	public void setStock(int stock) {
		this.stock = stock;
	}




	public int getSalesvolume() {
		return salesvolume;
	}




	public void setSalesvolume(int salesvolume) {
		this.salesvolume = salesvolume;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getBrand() {
		return brand;
	}




	public void setBrand(String brand) {
		this.brand = brand;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	private int barcode=0;
	 private String name ="";
	 private int locationX=0;
	 private int locationY=0;
	 private int stock=0;
	 private int salesvolume=0;
	 private String type="";
	 private String brand="";
	 public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	private int price=0;


	
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