package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class BookReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    private Readers reader;
    @ManyToOne()
    private Book book;

    private Date removeDate;
    private Date startDate;
    private Date returnDate;


}