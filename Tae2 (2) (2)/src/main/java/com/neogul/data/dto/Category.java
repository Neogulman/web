package com.neogul.data.dto;

import java.io.Serializable;

public class Category implements Serializable {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private int id = -1;

	    private int version;

	    private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    
	    

}
