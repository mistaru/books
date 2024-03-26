package com.example.demo.service.impl;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepo repo;

    public Long save(BookSaveDto dto) throws NullPointerException {
        if (dto.getId() == null) {
            Book book = new Book();
            book.setBookName(dto.getBookName());
            book.setPublishedDate(dto.getPublishedDate());
            book = repo.save(book);
            return book.getId();
        } else {
            return update(dto);
        }
    }

    private Long update(BookSaveDto dto) throws NullPointerException {
        Optional<Book> optionalBook = repo.findById(dto.getId());

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setPublishedDate(dto.getPublishedDate());
            book.setBookName(dto.getBookName());
            return repo.save(book).getId();

        } else throw new NullPointerException(String.format("Книга с id %s не найдена", dto.getId()));
    }

    public String delete(Long id) {
        Optional<Book> optionalBook = repo.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setRemoveDate(new Date(System.currentTimeMillis()));
            repo.save(book);

        } else throw new NullPointerException(String.format("Книга с id %s не найдена", id));
        return "Deleted";
    }


    public BookResponseDto findById(Long id) {
        Optional<Book> book = repo.findBookByRemoveDateIsNullAndId(id);

        var dto = new BookResponseDto();
        if (book.isPresent()) {
            dto = new BookResponseDto(
                    book.get().getId(),
                    book.get().getBookName(),
                    book.get().getPublishedDate()
            );
        } else throw new NullPointerException(String.format("Книга с id %s не найдена", id));
        return dto;
}

    public List<BookResponseDto> findAll() throws Exception {
        var list = repo.findAllAndBOrderByRemoveDateIsNull();


        List<BookResponseDto> dtoList = new ArrayList<>();

        for (Book book : list) {
            var dto = new BookResponseDto(
                    book.getId(),
                    book.getBookName(),
                    book.getPublishedDate()
            );
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Book> findAllAndOrderById() {
        return repo.findAllAndOrderById();
    }


    @Override
    public List<BookResponseDto> findByIdList(List<Long> idList) {
        List<Book> books = repo.findByIdList(idList);

        List<BookResponseDto> dtoList = new ArrayList<>();

        for (Book book : books) {
            var dto = new BookResponseDto(
                    book.getId(),
                    book.getBookName(),
                    book.getPublishedDate()
            );
            dtoList.add(dto);
        }
        return dtoList;
    }
}
