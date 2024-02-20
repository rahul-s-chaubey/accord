package com.idbiintech.smartcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.smartcontract.DTO.SMSRequest;
import com.idbiintech.smartcontract.ServiceImpl.SMSServiceImpl;


@RestController
@RequestMapping("/api")

public class SMSController {

    @Autowired
    private SMSServiceImpl smsService;

    @PostMapping("/sendsms")
    public void sendSMS(@RequestBody SMSRequest request) {
    	
    	System.out.println(request.getTo());
    	
		/*
		 * smsService.sendSMS(request.getTo());
		 */    }
}
