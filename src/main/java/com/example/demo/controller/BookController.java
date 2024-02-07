package com.example.demo.controller;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return service.findAll();
    }

    @Transactional
    @PostMapping
    public Long save(@RequestBody BookSaveDto dto) throws Exception {
        return service.save(dto);
    }

    @DeleteMapping
    public String delete (@RequestParam Long id){
        return service.delete(id);
    }

    @PutMapping
    public String update (@RequestParam Long id, @RequestBody BookSaveDto dto){
        return service.update(id, dto);
    }

    @GetMapping("/allByIds")
    public List<BookResponseDto> findByIdList(@RequestParam List<Long> ids){
        return service.findByIdList(ids);
    }
}