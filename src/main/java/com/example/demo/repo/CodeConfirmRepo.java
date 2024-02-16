package com.example.demo.repo;

import com.example.demo.entity.CodeConfirm;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeConfirmRepo extends JpaRepository<CodeConfirm, Long> {

    Optional<CodeConfirm> findByCode(Long code);
}