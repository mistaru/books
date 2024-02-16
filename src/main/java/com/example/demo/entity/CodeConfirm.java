package com.example.demo.entity;

import com.example.demo.enums.CodeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Data
public class CodeConfirm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long code;
    @Enumerated(value = EnumType.STRING)
    private CodeStatus status;

}
