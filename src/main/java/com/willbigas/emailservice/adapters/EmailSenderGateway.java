package com.willbigas.emailservice.adapters;

import org.springframework.stereotype.Service;

@Service
public interface EmailSenderGateway {

	void sendEmail(String to, String subject, String body);
}
