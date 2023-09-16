package com.willbigas.emailservice.controllers;

import com.willbigas.emailservice.application.EmailSenderService;
import com.willbigas.emailservice.core.EmailRequest;
import com.willbigas.emailservice.core.exceptions.EmailServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailSenderController {

	private final EmailSenderService emailSenderService;

	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
		try {
			this.emailSenderService.sendEmail(request.to() , request.subject(), request.body());
			return ResponseEntity.ok("email sent sucessfully");
		} catch (EmailServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro while sending email");
		}
	}
}
