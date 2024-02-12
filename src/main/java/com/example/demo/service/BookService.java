package com.example.demo.service;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {

    Long save(BookSaveDto dto) throws NullPointerException;

    String delete(Long id);

    List<BookResponseDto> findAll() throws Exception;

    List<BookResponseDto> findByIdList(List<Long> idList);

    BookResponseDto findById(Long id);
}
