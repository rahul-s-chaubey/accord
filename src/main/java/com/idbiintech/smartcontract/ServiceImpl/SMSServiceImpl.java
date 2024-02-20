package com.idbiintech.smartcontract.ServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.DTO.ResponseDTO;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SMSServiceImpl {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    public ResponseDTO sendSMS(CarloanDTO carloandto) {
        Twilio.init(accountSid, authToken);
        
    	ResponseDTO responseDTO = null;
		        
        long epoch = System.currentTimeMillis();
        System.out.println("epoch" +epoch);
        
        String message = " Your Car Loan Has been applied and this is your application number - "+epoch;

		try {

			 Message twilioMessage;
			 
			twilioMessage = Message.creator(
			        new com.twilio.type.PhoneNumber(carloandto.getPhone()),
			        new com.twilio.type.PhoneNumber(twilioPhoneNumber),
			        message
			).create();
			
			responseDTO = new ResponseDTO();
			responseDTO.setMessage("SMS sent successfully");
		  
			responseDTO.setData("ok");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			responseDTO = new ResponseDTO();
			responseDTO.setMessage("SMS not sent");
			responseDTO.setData("failure");
			
		}

        
		return responseDTO;
    }
}
