package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private Date publishedDate;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Set<Author> authors = new HashSet<>();
}