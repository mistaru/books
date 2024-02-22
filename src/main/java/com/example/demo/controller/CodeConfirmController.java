package com.example.demo.controller;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.User;
import com.example.demo.service.CodeConfirmService;
import com.example.demo.service.MailService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/codeConfirm")
public class CodeConfirmController {

	private final CodeConfirmService service;

	@PostMapping()
	public Long confirm(@RequestParam Long code){
//		return service.confirm(code);
		return 1L;
	}

}