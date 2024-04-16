package com.idbiintech.smartcontract;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class SmartcontractApplication {

	private static final int GMAIL_SMTP_PORT = 587;

	private String host = "smtp.gmail.com";

	private String user = "idbitestmail@gmail.com";

	private String password = "otqhambgvbdwenmy";


	private Boolean debug = true;

	public static void main(String[] args) {
		SpringApplication.run(SmartcontractApplication.class, args);
		System.out.println("Hello");
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(GMAIL_SMTP_PORT);

		mailSender.setUsername(user);
		mailSender.setPassword(password);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", debug);
		return mailSender;
	}

}
