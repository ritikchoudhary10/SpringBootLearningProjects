package com.ritik.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service("purchase")// SPECIFYING THE BEAN ID FOR PURCHASESERVICE CLASS
@Slf4j
public class PurchaseService {

	@Autowired
	JavaMailSender sender;  // this class implementation object comes through autoconfiguration due to Spring-Boot-starter-mail
	
	@Value("${spring.mail.username}")
	String fromEmail;  // getting the sender mail id from application.properties
	
	
	// b.logic method for calculating the total bill and for generating billing text message that should be sent
	public String purchaseItem(String[] items ,double[] prices ,String[] receivers) {
		log.info("Items-->"+Arrays.toString(items));
		log.info("Prices-->"+Arrays.toString(prices));
		log.info("receivers-->"+Arrays.toString(receivers));
		
		Double totalBill=0.0;
		
		for(Double d:prices) 
			totalBill+=d;
		
		log.info("genereated Bill Ammount-->"+totalBill);
		String msg = Arrays.toString(items)+" items Having prices "+Arrays.toString(prices)+" have total BillAmount of "+totalBill+" RS.";
		return sendMail(msg,receivers);
		 
		
	}
	
	
	// this method is used to send the mail to the by using JavaMailSender class object
	private String sendMail(String msg,String[] toEmails) {
		try {
			MimeMessage mime = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mime,true,"UTF-8");
			helper.setFrom(fromEmail);
			helper.setCc(toEmails);
			helper.setSubject("PURCHASE DETAILS");
			helper.setSentDate(new Date(System.currentTimeMillis()));
			helper.setText(msg);
			helper.addAttachment("img.jpg",new ClassPathResource("img.jpg"));//store in src/maim/resources folder
			sender.send(mime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Problem Occured while sending mail";
		}
		return "Mail Send";
	}
}
