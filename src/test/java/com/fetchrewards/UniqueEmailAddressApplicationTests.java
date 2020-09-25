package com.fetchrewards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fetchrewards.model.EmailAddress;
import com.fetchrewards.service.EmailService;
import com.fetchrewards.validator.EmailValidator;

@SpringBootTest
@RunWith(SpringRunner.class)
class UniqueEmailAddressApplicationTests {

	@Autowired
	EmailValidator validate;
	
	@Autowired
	EmailService service;
	
	EmailAddress emailId;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void validInputResult() {
		service.addEmail(new EmailAddress("test.email@gmail.com"));
		service.addEmail(new EmailAddress("test.email+spam@gmail.com"));
		service.addEmail(new EmailAddress("testemail@gmail.com"));
		List<EmailAddress> emailList = service.getList();
		assertEquals(service.getUniqueEmailsSize(emailList), 1);
	}
	
	@Test
	void validInputResult1() {
		service.addEmail(new EmailAddress("test.email@gmail.com"));
		service.addEmail(new EmailAddress("test.ema+il+spam@gmail.com"));
		service.addEmail(new EmailAddress("testemail@gmail.com"));
		List<EmailAddress> emailList = service.getList();
		assertEquals(service.getUniqueEmailsSize(emailList), 2);
	}
	
	@Test
	void invalidEmailId() {
		
		assertEquals(validate.validateEmailId(new EmailAddress("testemail@a.")), false);
	}
	
	@Test
	void invalidEmailId1() {
		
		assertEquals(validate.validateEmailId(new EmailAddress("`testemail@gmail.com")), false);
	}

	@Test
	void validEmailId() {
		
		assertEquals(validate.validateEmailId(new EmailAddress("testemail@gmail.com")), true);
	}
}
