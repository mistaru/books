package com.example.demo.service.impl;

import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepo;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo repo;

    @Override
    public Address save(Address address) {
        return repo.save(address);
    }
}
