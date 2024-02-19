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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final AddressService addressService;
    private final RoleService roleService;
    private final MailService mailService;
    private final UserRepo repo;

    @Override
    public Long save(UserRegistrationDto model) {
        log.info("UserServiceImpl: save() - {}", model);
        User newUser = new User();

        if (model.getPassword() == null || model.getPassword().isEmpty()) {
            log.error("UserServiceImpl: save() - {}", "\"Пароль не подходит требованиям безопасности\"");
            throw new NullPointerException("Пароль не подходит требованиям безопасности");
        }

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

        newUser = repo.save(newUser);
        log.info("UserServiceImpl: end() - id new user {}", newUser.getId());

        return  newUser.getId();
    }

    @Override
    public void activeUser(Long id) {
        var optionalUser = repo.findById(id);

        if (optionalUser.isPresent()) {
            var user = optionalUser.get();
            user.setStatus(UserStatus.ACTIVE);
            repo.save(user);

        } else throw new NullPointerException("Пользователь не найден");

    }
}
