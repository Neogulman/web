package com.neogul.ui.util;

public enum Status {
	 Y("정상"), S("접속 중"), B("차단"), O("반출 중");

	    private final String name;

	    private Status(String name) {
	        this.name = name;
	    }

	    @Override
	    public String toString() {
	        return name;
	    }
	}
