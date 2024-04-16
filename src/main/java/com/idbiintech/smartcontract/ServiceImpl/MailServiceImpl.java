package com.idbiintech.smartcontract.ServiceImpl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.idbiintech.smartcontract.DTO.CarloanDTO;
import com.idbiintech.smartcontract.DTO.ResponseDTO;
import com.idbiintech.smartcontract.Service.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;



@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;

	private String sender = "idbitestmail@gmail.com";
	
	private String recep = "ankitamenon113@gmail.com";

	@Override
	public String sendSimpleMail(CarloanDTO details)
    {
		
		String message = "You have sucessfully applied for carloan. Please find the attached document to verify your details";
		
		String subject = "Carloan Application";
 
        // Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getLenderemail());
            mailMessage.setText(message);
            mailMessage.setSubject(subject);
 
            // Sending the mail
            mailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

	@Override
	public ResponseDTO sendMailWithAttachment(CarloanDTO details)
    {
		
		System.out.println(details.getLenderemail());
		
		
		ResponseDTO responseDTO = null;
		
		String message = "You have sucessfully applied for carloan. Please find the attached document to verify your details";
		
		String subject = "Carloan Application";
		
		String attachment = "C:\\test\\test.pdf";
		
        // Creating a mime message
        MimeMessage mimeMessage
            = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getLenderemail());
            mimeMessageHelper.setText(message);
            mimeMessageHelper.setSubject(subject);
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(attachment));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            mailSender.send(mimeMessage);
            
        	responseDTO = new ResponseDTO();
			responseDTO.setMessage("Mail sent successfully");
		  
			responseDTO.setData("ok");
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
        	responseDTO = new ResponseDTO();
			responseDTO.setMessage("Mail not sent");
			responseDTO.setData("failure");
			
        }
		return responseDTO;
    }

}
