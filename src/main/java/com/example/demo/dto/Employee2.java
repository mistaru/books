package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee2 {
    private String id;
    private String employeeName;
    private String employeeSalary;
    private String employeeAge;
    private String profileImage;
}
