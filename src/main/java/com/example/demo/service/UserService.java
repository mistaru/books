package com.example.demo.service;

import com.example.demo.dto.UserRegistrationDto;

public interface UserService {
    Long save(UserRegistrationDto model);

    void activeUser(Long code);
}
