package com.idbiintech.smartcontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.DTO.ResponseDTO;
import com.idbiintech.smartcontract.ServiceImpl.CarloanServiceImpl;

@RestController 
@RequestMapping("/accord")
public class CarloanController
{
	
	@Autowired
	CarloanServiceImpl CarloanServiceImpl;

	@PostMapping("/car-loan-application")
	public String submitapplication(CarloanDTO carloandto)
	{
		String status = null;
		try 
		{
			ResponseDTO responseDTO = CarloanServiceImpl.insertintotable(carloandto);
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

