package com.example.demo.service;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.entity.BookReserve;

import java.util.List;

public interface BookReserveService {
    List<BookReserve> findByAfterReturnDate();
}
