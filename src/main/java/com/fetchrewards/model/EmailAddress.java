package com.fetchrewards.model;

import org.springframework.stereotype.Component;

@Component
public class EmailAddress {
	
	private String emailId;
	
	public EmailAddress() {}
	public EmailAddress(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "EmailAddress [emailId=" + emailId + "]";
	}
	
}
