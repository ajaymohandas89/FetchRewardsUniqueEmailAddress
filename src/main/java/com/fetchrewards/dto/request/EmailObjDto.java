package com.fetchrewards.dto.request;

import java.util.List;

import javax.validation.constraints.NotNull;

public class EmailObjDto {

	@NotNull(message = "Input list is mandatory")
	private List<String> emailList;
	
	public EmailObjDto() {}
	
	public EmailObjDto(List<String> emailList) {
		this.emailList = emailList;
	}

	public List<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}
	
	
}
