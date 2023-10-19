package com.bestcompany.complaints.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

public class LoggingService {

    private final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void log(String message) {
        logger.info(message);
    }
}