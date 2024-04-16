package com.idbiintech.smartcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.smartcontract.DTO.EmailDetails;
import com.idbiintech.smartcontract.Service.MailService;

@RestController
@RequestMapping("/api")

public class MailController {
	@Autowired
	private MailService mailService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		
		System.out.println(details.getMsgBody());
		
		/*
		 * String status = mailService.sendSimpleMail(details);
		 */
		return "fgj";
	}

	
	 @PostMapping("/sendMailWithAttachment")
	    public String sendMailWithAttachment(
	        @RequestBody EmailDetails details)
	    {
		 
		 System.out.println(details.getSubject());
		 
			/* ResponseDTO status = mailService.sendMailWithAttachment(details); */
	 
	        return "success";
	    }
	
	
	
}