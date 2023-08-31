package com.example.hps.service;

import com.example.hps.EmailDetails;

public interface EmailService {
	    String sendSimpleMail(EmailDetails details);
	    String sendMailWithAttachment(EmailDetails details);
}
