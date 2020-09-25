package com.fetchrewards.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.fetchrewards.model.EmailAddress;

@Service
public class EmailValidator {
	
	public EmailValidator() {
		
	}
	/*
	 * A-Z characters allowed
	 * a-z characters allowed
	 * 0-9 numbers allowed
	 * Additionally email may contain only dot(.), dash(-) and underscore(_)
	 * Rest all characters are not allowed
	 * After @ any character a-z are allowed
	 * dot(.) present after @ will contain charctaer a-z of minimum length 2 and maximum length 3
	 * */
	private String regex = "^[A-Za-z0-9+_.-]+@[a-z]+\\.[a-z]{2,3}$";
	 
	public boolean validateEmailId(EmailAddress emailId) {
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(emailId.getEmailId());
		
		return matcher.matches();		
	}
}
