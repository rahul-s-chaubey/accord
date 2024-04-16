package com.idbiintech.smartcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.DTO.ResponseDTO;
import com.idbiintech.smartcontract.Service.MailService;
import com.idbiintech.smartcontract.ServiceImpl.CarloanGenerationServiceImpl;
import com.idbiintech.smartcontract.ServiceImpl.CarloanServiceImpl;
import com.idbiintech.smartcontract.ServiceImpl.SMSServiceImpl;

@RestController 
@RequestMapping("/accord")
public class CarloanController
{
	
	@Autowired
	CarloanServiceImpl CarloanServiceImpl;
	
	@Autowired
	MailService MailService;
	
	@Autowired
	SMSServiceImpl SMSService;
	
	
	@Autowired
	CarloanGenerationServiceImpl CarloanGenerationServiceImpl;
	

	@PostMapping("/car-loan-application")
	public String submitapplication(CarloanDTO carloandto)
	{
		String status = "success";
		
		String docxPath = "C:\\test\\carloan.docx";
		String modifiedDocxPath = "C:\\test\\test1.docx";
		String pdfPath = "C:\\test\\test.pdf";
		
		try 
		{
			ResponseDTO responseDTO = CarloanServiceImpl.insertintotable(carloandto);
			
			
			CarloanGenerationServiceImpl.updateDocument(carloandto);
			
			
			ResponseDTO responseDTO2 = MailService.sendMailWithAttachment(carloandto);
			
			ResponseDTO responseDTO3 = SMSService.sendSMS(carloandto);
			
			if(responseDTO.getMessage().equals("ok"))
				status = "success";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			status = "fail";
		}
		
		
		
		
		
		
		return status;
			
	}
}

