package com.example.demo.service;

import com.example.demo.entity.CodeConfirm;

import java.util.Optional;
import java.util.Random;

public interface CodeConfirmService {

    Optional<CodeConfirm> findByCode(Long code);

    Long save(CodeConfirm codeConfirm);

    Long save(Long userId);

    Boolean confirm(Long code);
}
