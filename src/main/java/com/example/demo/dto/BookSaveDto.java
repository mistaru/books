package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class BookSaveDto {
    private Long id;
    private String bookName;
    private String authorName;
    private Date publishedDate;

}