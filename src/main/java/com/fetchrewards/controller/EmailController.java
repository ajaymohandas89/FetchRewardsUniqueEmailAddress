package com.fetchrewards.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fetchrewards.dto.request.EmailObjDto;
import com.fetchrewards.model.EmailAddress;
import com.fetchrewards.service.EmailService;
import com.fetchrewards.validator.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EmailController {

	@Autowired
	EmailValidator validate;
	
	@Autowired
	EmailService service;
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@PostMapping("/uniqueEmailList")
    public ResponseEntity<?> getUniqueEmailListSize(@Valid @RequestBody EmailObjDto list)
    {
		
		for(String emailId: list.getEmailList()) {
			service.addEmail(new EmailAddress(emailId));
		}
		
		List<EmailAddress> emailList = service.getList();
		
		//validating email address
		for(EmailAddress emailId:emailList) {
			if(!validate.validateEmailId(emailId)) {
				service.clearEmailList();
				logger.error("invalid input message and ended wth response code 400");
				return new ResponseEntity("Please provide valid input parameters", HttpStatus.BAD_REQUEST);
			}
		}
		 //calculating unique email address
		 return new ResponseEntity("The number of unique email address are "+service.getUniqueEmailsSize(emailList), HttpStatus.OK);  
    }
	
}
