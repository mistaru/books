package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    public void sendEmailForRegistration(User user, Long code) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setSubject("Регистрация на BOOK-STORE");

        mail.setText("Код для активации аккаунта ( " +
                code + "). Не показывайте никому. ");

        javaMailSender.send(mail);
        log.error("MailServiceImpl : " +
                "sendEmailForRegistration() " +
                "отправили сообщение на почту {}", user.getEmailAddress()
        );

    }

}