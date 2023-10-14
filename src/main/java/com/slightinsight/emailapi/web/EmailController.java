package com.slightinsight.emailapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slightinsight.emailapi.model.EmailRequest;
import com.slightinsight.emailapi.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
		
		log.info("REST API invoked to send email");
        emailService.sendEmail(emailRequest);
        
        return ResponseEntity.ok("Email sent successfully");
    }


}
