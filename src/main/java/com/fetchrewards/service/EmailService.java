package com.fetchrewards.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fetchrewards.model.EmailAddress;
import com.fetchrewards.model.EmailAddressInterface;

@Service
public class EmailService implements EmailAddressInterface{
	
	private List<EmailAddress> emailList = new ArrayList<EmailAddress>();
	
	public EmailService() {}
	
	@Override
	public int getUniqueEmailsSize(List<EmailAddress> list) {
		Set<String>  uniqueEmailsList=new HashSet<>();
		for(EmailAddress email : list) 
        {
            String[] splitEmailAt = email.getEmailId().split("@");
			String localName = splitEmailAt[0];
			String[] splitEmailAtPlus = localName.split("\\+");
			String username = splitEmailAtPlus[0];
			username = username.replaceAll("\\.", "");
			username = username + "@" + splitEmailAt[1];
			uniqueEmailsList.add(username);
        }
		list.clear();
		clearEmailList();
        return uniqueEmailsList.size();
	}

	@Override
	public void addEmail(EmailAddress emailId) {
		this.emailList.add(emailId);
	}

	@Override
	public List<EmailAddress> getList() {
		return this.emailList;
	}
	
	public void clearEmailList() {
		this.emailList.clear();
	}
	
}
