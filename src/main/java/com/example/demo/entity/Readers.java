package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Readers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String birthday;
}
