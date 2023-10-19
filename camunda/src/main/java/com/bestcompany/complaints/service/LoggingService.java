package com.yourcompany.complaints.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void log(String message) {
        logger.info(message);
    }
}