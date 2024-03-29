package com.example.demo.controller;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookSaveDto;
import com.example.demo.dto.ResponseMessageAPI;
import com.example.demo.enums.ResultCode;
import com.example.demo.enums.ResultCodeAPI;
import com.example.demo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book", description = "Тут находятся все роуты связанные для работы с книгами")
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Все записи получены успешно",
                    content = {@Content(mediaType = "application/json")})
    })
    @Operation(summary = "Этот роут возвращает весь список книг")
    @GetMapping("/all")
    public ResponseMessageAPI<List<BookResponseDto>> getAllBooks() {
        try {
            return new ResponseMessageAPI<>(
                    service.findAll(),
                    ResultCodeAPI.SUCCESS,
                    null,
                    "success",
                    ResultCode.OK.getHttpCode()
            );

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.FAIL,
                    exception.getClass().getSimpleName(),
                    exception.getMessage(),
                    ResultCode.NOT_FOUND.getHttpCode()
            );
        } catch (Exception e) {
            System.out.printf("BookController: getAllBooks() %s%n", e);
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.EXCEPTION, e.getClass().getSimpleName(),
                    "Ошибка при получении всех книг книги",
                    ResultCode.FAIL.getHttpCode()
            );
        }
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
    public ResponseMessageAPI<BookResponseDto> findById(@PathVariable Long id) {
        try {
            return new ResponseMessageAPI<>(
                    service.findById(id),
                    ResultCodeAPI.SUCCESS,
                    null,
                    "success",
                    ResultCode.OK.getHttpCode());

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.FAIL,
                    exception.getClass().getSimpleName(),
                    exception.getMessage(),
                    ResultCode.NOT_FOUND.getHttpCode()
            );
        } catch (Exception e) {
            System.out.printf("BookController: findById() %s%n", e);
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.EXCEPTION, e.getClass().getSimpleName(),
                    "Ошибка при получении книги по айди " + id,
                    ResultCode.FAIL.getHttpCode()
            );
        }
    }


    @GetMapping("/allByIds")
    public List<BookResponseDto> findByIdList(@RequestParam List<Long> ids) {
        return service.findByIdList(ids);
    }

}