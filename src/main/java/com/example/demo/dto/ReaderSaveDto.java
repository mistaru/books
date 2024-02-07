package com.example.demo.dto;

import lombok.Data;

@Data
public class ReaderSaveDto {
    private int id;
    private String firstname;
    private String lastname;
    private String birthday;

    public ReaderSaveDto(String firstname, String lastname, String birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }
}