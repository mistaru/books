package com.example.demo.service;

import com.example.demo.entity.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@AllArgsConstructor
@Service
public class MailService {

	private  final  JavaMailSender javaMailSender;

	public void sendEmailForRegistration(User user) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Регистрация на BOOK-STORE");
		mail.setText("Код для активации аккаунта ( " +
				generateFourDigitNumber() + "). Не показывайте никому. " );

		javaMailSender.send(mail);
	}

	public static int generateFourDigitNumber() {
		Random random = new Random();
		// Генерируем случайное число от 1000 до 9999 (включительно)
		return random.nextInt(9000) + 1000;
	}


}
