package com.example.demo.controller.util;

import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI configure() {
		return new OpenAPI()
				.info(new Info()
						.title("BookStore")
						.description("Мы тут якобы продаем книги")
						.version("1.0.0")
						.contact(new Contact().name("argen")
								.email("argen@gmail.com"))
						);
	}

}
