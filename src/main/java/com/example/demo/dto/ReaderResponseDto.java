package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReaderResponseDto {
    private String firstname;
    private String lastname;

    public ReaderResponseDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}