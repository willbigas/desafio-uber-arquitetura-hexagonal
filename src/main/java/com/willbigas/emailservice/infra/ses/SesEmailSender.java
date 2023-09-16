package com.willbigas.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.willbigas.emailservice.adapters.EmailSenderGateway;
import com.willbigas.emailservice.core.exceptions.EmailServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesEmailSender implements EmailSenderGateway {

	private final AmazonSimpleEmailService amazonSimpleEmailService;

	@Override
	public void sendEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest()
				.withSource("will.bigas@gmail.com")
				.withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message()
						.withSubject(new Content(subject))
						.withBody(new Body().withText(new Content(body))));

		try {
			this.amazonSimpleEmailService.sendEmail(request);
		} catch (AmazonServiceException e) {
			throw new EmailServiceException("Failure while send email", e);
		}
	}
}
