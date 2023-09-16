package com.willbigas.emailservice.application;

import com.willbigas.emailservice.adapters.EmailSenderGateway;
import com.willbigas.emailservice.core.EmailSenderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService implements EmailSenderUseCase {

	private final EmailSenderGateway emailSenderGateway;

	@Override
	public void sendEmail(String to, String subject, String body) {
		this.emailSenderGateway.sendEmail(to , subject , body);
	}
}
