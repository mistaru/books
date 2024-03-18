package com.example.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonComponent
@JsonDeserialize
public class Employee {
    private Long id;
    private String employeeName;
    private Long employeeSalary;
    private Long employeeAge;
    private String profileImage;

    /*employee_age*/
}
