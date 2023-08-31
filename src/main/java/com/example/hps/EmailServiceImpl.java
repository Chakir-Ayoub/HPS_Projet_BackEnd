package com.example.hps;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.hps.service.EmailService;


@Component
public class EmailServiceImpl implements EmailService {
    @Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;

	@Override
	public String sendSimpleMail(EmailDetails details) {
		// TODO Auto-generated method stub
        	 
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
 
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";

	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		// TODO Auto-generated method stub
        MimeMessage mimeMessage
        = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;

    try {

        // Setting multipart as true for attachments to
        // be send
        mimeMessageHelper
            = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(details.getRecipient());
        mimeMessageHelper.setText(details.getMsgBody());
        mimeMessageHelper.setSubject(
            details.getSubject());

        // Adding the attachment
        FileSystemResource file
            = new FileSystemResource(
                new File(details.getAttachment()));

        mimeMessageHelper.addAttachment(
            file.getFilename(), file);

        // Sending the mail
        javaMailSender.send(mimeMessage);
        return "Mail sent Successfully";
    }

    // Catch block to handle MessagingException
    catch (MessagingException e) {

        // Display message when exception occurred
        return "Error while sending mail!!!";
    }	}
	
	
}
