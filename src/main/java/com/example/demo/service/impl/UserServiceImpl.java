package com.example.demo.service.impl;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.enums.UserStatus;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.AddressService;
import com.example.demo.service.MailService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final AddressService addressService;
    private final RoleService roleService;
    private final MailService mailService;
    private final UserRepo repo;

    @Override
    public Long save(UserRegistrationDto model) {
        User newUser = new User();

        if (model.getPassword() == null || model.getPassword().isEmpty())
            throw new NullPointerException("Пароль не подходит требованиям безопасности");

        if (repo.findByEmailAddress(model.getEmailAddress()).isPresent())
            throw new RuntimeException(model.getEmailAddress() + " -  электронная почта уже используется другим пользователем");

        newUser.setUsername(model.getUsername());
        newUser.setFullname(model.getFullname());
        newUser.setEmailAddress(model.getEmailAddress());
        newUser.setPassword(model.getPassword());

        List<Role> roles  = new ArrayList<>();

        roles.add(roleService.findByName("reader"));
        newUser.setRoles(roles);

        Address address = new Address(null,
                model.getCityName(),
                model.getStreetName(),
                model.getBuildingNumber()
        );

        address = addressService.save(address);

        newUser.setAddress(address);
        newUser.setStatus(UserStatus.NEW);

        mailService.sendEmailForRegistration(newUser);

        return  repo.save(newUser).getId();
    }
}
