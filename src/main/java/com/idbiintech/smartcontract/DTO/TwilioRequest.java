package com.idbiintech.smartcontract.DTO;

public class TwilioRequest { 
	private  String toPhoneNumber; 
	private  String fromPhoneNumber; 
	private  String message;
	public String getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public String getFromPhoneNumber() {
		return fromPhoneNumber;
	}
	public void setFromPhoneNumber(String fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	

}
