package com.example.demo.service.impl;

import com.example.demo.entity.BookReserve;
import com.example.demo.repo.BookReserveRepo;
import com.example.demo.service.BookReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookReservServiceImpl implements BookReserveService {

    private final BookReserveRepo repo;

    @Override
    public List<BookReserve> findByAfterReturnDate() {
        Date date = new Date(System.currentTimeMillis());
        return repo.findAllByReturnDateBefore(date);
    }
}
