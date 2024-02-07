package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private String bookName;
    private Date publishedDate;

}