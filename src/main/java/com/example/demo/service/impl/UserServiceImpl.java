package com.example.demo.service.impl;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.enums.UserStatus;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.*;
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
    private final CodeConfirmService codeConfirmService;
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

        List<Role> roles = new ArrayList<>();

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


        newUser = repo.save(newUser);
        log.info("UserServiceImpl: end() - id new user {}", newUser.getId());

        var code = codeConfirmService.save(newUser.getId());

        mailService.sendEmailForRegistration(newUser, code);

        return newUser.getId();
    }

    @Override
    public void activeUser(Long code) {
        var confirmCodeOptional = codeConfirmService.findByCode(code);


        if (confirmCodeOptional.isPresent()) {
            User user = confirmCodeOptional.get().getUser();
            codeConfirmService.confirm(code);
            user.setStatus(UserStatus.CONFIRM);
            repo.save(user);

        } else throw new NullPointerException("Пользователь не найден");

    }
}
