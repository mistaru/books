package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.mail.MailException;

public interface MailService {
    void sendEmailForRegistration(User user, Long code) throws MailException;
}