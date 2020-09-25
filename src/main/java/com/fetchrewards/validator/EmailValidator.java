package com.fetchrewards.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.fetchrewards.model.EmailAddress;

@Service
public class EmailValidator {
	
	public EmailValidator() {
		
	}
	
	private String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	 
	public boolean validateEmailId(EmailAddress emailId) {
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(emailId.getEmailId());
		
		return matcher.matches();		
	}
}
