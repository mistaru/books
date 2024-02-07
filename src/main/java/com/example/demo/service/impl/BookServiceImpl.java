package com.example.demo.service.impl;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepo repo;


    public Long save(BookSaveDto dto) throws Exception {
        Book book = new Book();
        book.setBookName(dto.getBookName());
        book.setPublishedDate(dto.getPublishedDate());
        book = repo.save(book);
        if (book.getBookName() == null) throw new Exception("Проверка транзакции");
        return book.getId();
    }


    public String delete(Long id) {
        repo.deleteById(id);
        return "Deleted";
    }

    public List<Book> findAll() {
        return repo.findAll();
    }

    public List<Book> findAllAndOrderById() {
        return repo.findAllAndOrderById();
    }

    public String update(Long id, BookSaveDto dto) {
        Optional<Book> optionalBook = repo.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setPublishedDate(dto.getPublishedDate());
            book.setBookName(dto.getBookName());
            repo.save(book);

            return "Запись с ID " + id + " успешно обновлена";
        } else return "Запись с ID " + id + " не найдена";
    }

    @Override
    public List<BookResponseDto> findByIdList(List<Long> idList) {
        List<Book> books = repo.findByIdList(idList);

        List<BookResponseDto> dtoList = new ArrayList<>();

        for (Book book: books) {
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
