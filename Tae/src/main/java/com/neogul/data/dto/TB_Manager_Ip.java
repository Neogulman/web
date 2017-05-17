package com.neogul.data.dto;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class TB_Manager_Ip implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	 private int idx = 0;
	 private String cip = "";
	 private String day = "";
	 private String login_day = "";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLogin_day() {
		return login_day;
	}

	public void setLogin_day(String login_day) {
		this.login_day = login_day;
	}
	
	public String fnValidation(HttpServletRequest req){
		
		String val = "success";
		
		/*HttpSession session = req.getSession();
		Language langu = (Language)session.getAttribute("langu");
	
		
		try{
			SortedMap<String,String[]> sMap = Collections.synchronizedSortedMap(new TreeMap<String,String[]>(req.getParameterMap()));
			synchronized(sMap){			
				for(String key : sMap.keySet()){
					String[] value = sMap.get(key);
					for(int i=0; i<value.length; i++){
						if(key.equals("cip")){
							if(value[i].equals("")){
								val = "failure^"+langu.getTb_manager_ip_1()+"^-";
							}
							else{
								String spt[] = value[i].split("\\.");
								if(spt.length == 4){
									int ip1 = 0;
									int ip2 = 0;
									int ip3 = 0;
									int ip4 = 0;
									
									try{ ip1 = Integer.parseInt(spt[0]); }catch(Exception e){ val = "failure^"+langu.getTb_manager_ip_2()+"^-"; }
									if(val.equals("success")){ try{ ip2 = Integer.parseInt(spt[1]); }catch(Exception e){ val = "failure^"+langu.getTb_manager_ip_2()+"^-"; } }
									if(val.equals("success")){ try{ ip3 = Integer.parseInt(spt[2]); }catch(Exception e){ val = "failure^"+langu.getTb_manager_ip_2()+"^-"; } }
									if(val.equals("success")){ try{ ip4 = Integer.parseInt(spt[3]); }catch(Exception e){ val = "failure^"+langu.getTb_manager_ip_2()+"^-"; } }
									
									if(val.equals("success")){
										if(ip1 > 255){ val = "failure^"+langu.getTb_manager_ip_3()+"^-"; }
										if(ip2 > 255){ val = "failure^"+langu.getTb_manager_ip_3()+"^-"; }
										if(ip3 > 255){ val = "failure^"+langu.getTb_manager_ip_3()+"^-"; }
										if(ip4 > 255){ val = "failure^"+langu.getTb_manager_ip_3()+"^-"; }
									}
								}
								else{
									val = "failure^"+langu.getTb_manager_ip_4()+"^-";
								}
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