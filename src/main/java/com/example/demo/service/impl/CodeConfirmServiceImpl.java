package com.example.demo.service.impl;

import com.example.demo.entity.CodeConfirm;
import com.example.demo.entity.User;
import com.example.demo.enums.CodeStatus;
import com.example.demo.repo.CodeConfirmRepo;
import com.example.demo.service.CodeConfirmService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class CodeConfirmServiceImpl implements CodeConfirmService {

    private final CodeConfirmRepo repo;

    @Override
    public Optional<CodeConfirm> findByCode(Long code) {
        return repo.findByCode(code);
    }

    @Override
    public Long save(CodeConfirm codeConfirm) {
        return repo.save(codeConfirm).getId();
    }

    @Override
    public Long save(Long userId) {
        CodeConfirm code = new CodeConfirm();
        code.setCode(generateFourDigitNumber());
        code.setStatus(CodeStatus.NEW);
        code.setUser(new User(userId));
        code  = repo.save(code);
        return code.getCode();
    }

    @Override
    public Boolean confirm(Long code) {
        var optionalCode  = findByCode(code);

        if (optionalCode.isPresent()) {
            var codeEntity = optionalCode.get();
            if (codeEntity.getStatus() == CodeStatus.NEW) {
                codeEntity.setStatus(CodeStatus.USED);
                return true;
            } return false;
        }
        return false;
    }



    public static long generateFourDigitNumber() {
        Random random = new Random();

        // Генерируем случайное число от 1000 до 9999 (включительно) 0001 0012
        return random.nextLong(9000) + 1000;
    }

}
