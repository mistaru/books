package com.example.demo.service;

import com.example.demo.entity.CodeConfirm;

import java.util.Optional;

public interface CodeConfirmService {

    Optional<CodeConfirm> findByCode(Long code);


}
