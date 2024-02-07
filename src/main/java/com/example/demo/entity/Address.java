package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cityName;
    private String streetName;
    private String buildingNumber;
}
