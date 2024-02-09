package com.example.demo.controller;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @GetMapping("/all")
    public List<BookResponseDto> getAllBooks() {
        return service.findAll();
    }

    @PostMapping
    public Long save(@RequestBody BookSaveDto dto) {
        try {
            return service.save(dto);

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return -1L;
        }
    }

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        return service.delete(id);
    }


    @GetMapping("/{id}")
    public BookResponseDto findById(@PathVariable Long id) {
        try {
        return service.findById(id);
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return new BookResponseDto();
        }
    }

    @GetMapping("/allByIds")
    public List<BookResponseDto> findByIdList(@RequestParam List<Long> ids) {
        return service.findByIdList(ids);
    }

}