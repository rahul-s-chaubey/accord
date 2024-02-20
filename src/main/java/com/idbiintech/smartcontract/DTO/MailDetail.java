package com.idbiintech.smartcontract.DTO;

public class MailDetail {
	
	private String recipient;
	private String subject;
	private String msgBody;
	private String attachment;
 
	
	private String makerId;
	private String checkerId;
	private String workid;
	
	private String recpient1;
	private String recpient2;
	
	public String getRecpient3Email() {
		return recpient3Email;
	}

	public void setRecpient3Email(String recpient3Email) {
		this.recpient3Email = recpient3Email;
	}

	private String recpient1Email;
	private String recpient2Email;	
	
	private String recpient3Email;
	
	

    public String getRecpient1Email() {
		return recpient1Email;
	}

	public void setRecpient1Email(String recpient1Email) {
		this.recpient1Email = recpient1Email;
	}

	public String getRecpient2Email() {
		return recpient2Email;
	}

	public void setRecpient2Email(String recpient2Email) {
		this.recpient2Email = recpient2Email;
	}

	public String getRecpient1() {
		return recpient1;
	}

	public void setRecpient1(String recpient1) {
		this.recpient1 = recpient1;
	}

	public String getRecpient2() {
		return recpient2;
	}

	public void setRecpient2(String recpient2) {
		this.recpient2 = recpient2;
	}

	public String getMakerId() {
		return makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}

	public String getWorkid() {
		return workid;
	}

	public void setWorkid(String workid) {
		this.workid = workid;
	}

	

	public MailDetail() {
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "MailDetail [recipient=" + recipient + ", subject=" + subject + ", msgBody=" + msgBody + ", attachment="
				+ attachment + ", makerId=" + makerId + ", checkerId=" + checkerId + ", workid=" + workid + "]";
	}

	 
    
    

}
