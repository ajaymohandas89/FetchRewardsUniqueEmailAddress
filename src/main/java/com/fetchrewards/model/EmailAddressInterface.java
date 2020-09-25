package com.fetchrewards.model;

import java.util.List;

public interface EmailAddressInterface {
	
	void addEmail(EmailAddress emailId);
	
	List<EmailAddress> getList();
	
	int getUniqueEmailsSize(List<EmailAddress> list);
}
