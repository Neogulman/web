package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;


public class TB_Reclist   implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	

	private String name ="";
	private int price=0;
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}


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