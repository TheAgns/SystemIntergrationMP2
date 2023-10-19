package com.bestcompany.complaints.service;

import com.bestcompany.complaints.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final EmailService emailService;
    private final LoggingService loggingService;

    @Autowired
    public NotificationService(EmailService emailService, LoggingService loggingService) {
        this.emailService = emailService;
        this.loggingService = loggingService;
    }

    public void notifyCustomer(String email, String complaintDetails) {
        emailService.sendEmail(email, "Complaint Acknowledgment", "Your complaint has been received.");
        loggingService.log("Email sent to customer: " + email);
    }
}