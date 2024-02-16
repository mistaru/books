package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.repo.RoleRepo;
import com.example.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo repo;


    @Override
    public Role findByName(String name) {
        return repo.findByName(name);
    }
}
