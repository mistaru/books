package com.example.demo.service.impl;

import com.example.demo.entity.CodeConfirm;
import com.example.demo.repo.CodeConfirmRepo;
import com.example.demo.service.CodeConfirmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CodeConfirmServiceImpl implements CodeConfirmService {

    private final CodeConfirmRepo repo;

    @Override
    public Optional<CodeConfirm> findByCode(Long code) {
        return repo.findByCode(code);
    }
}
