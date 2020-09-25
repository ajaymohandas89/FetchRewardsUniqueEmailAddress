package com.fetchrewards.model;

import java.util.List;

public interface EmailAddressInterface {
	
	/*
	 *argument type: EmailAddress
	 *return type: void
	 *descrition: add email address
	 * */
	void addEmail(EmailAddress emailId);
	
	/*
	 *argument type: void
	 *return type: List<EmailAddress>
	 *descrition: method to get the list of email addresses
	 * */
	List<EmailAddress> getList();
	
	/*
	 *argument type: List of email address
	 *return type: integer
	 *descrition: method to calculate unique email addresses
	 * */
	int getUniqueEmailsSize(List<EmailAddress> list);
}
