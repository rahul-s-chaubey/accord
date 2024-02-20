package com.idbiintech.smartcontract.Service;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.DTO.ResponseDTO;

public interface MailService {
	
	public String sendSimpleMail(CarloanDTO details);

	public ResponseDTO sendMailWithAttachment(CarloanDTO details);
	

}
