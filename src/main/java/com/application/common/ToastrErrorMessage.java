package com.application.common;

public enum ToastrErrorMessage {
	
	FAILED_TO_SAVE("F0001","Failed to save"),
	
	FAILED_TO_DELETE("F0002","Failed to Delete"),
	
	FAILED_TO_ASSIGN("F0003","Failed to Delete"),
	
	FAILED_TO_SENT_SMS("F0004","Failed to sent SMS")

	
	;


	private String message;
	private String code;

	ToastrErrorMessage(String code, String message) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
