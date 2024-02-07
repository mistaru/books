package com.example.demo.service;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {

    Long save(BookSaveDto dto) throws Exception;

    String delete(Long id);

    List<Book> findAll();

    String update(Long id, BookSaveDto dto);


    List<BookResponseDto> findByIdList(List<Long> idList);
}
