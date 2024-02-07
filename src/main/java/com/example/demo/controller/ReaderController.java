package com.example.demo.controller;

import com.example.demo.entity.Readers;
import com.example.demo.dto.ReaderResponseDto;
import com.example.demo.dto.ReaderSaveDto;
import com.example.demo.service.ReadersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/readers")
public class ReaderController {
    private final ReadersService service;

    @GetMapping()
    public List<Readers> getAll(){
        return service.findAll();
    }

    @PostMapping()
    public Long save(@RequestBody ReaderSaveDto model){
        return service.save(model);
    }

    @PostMapping("/param")
    public Long saveParam(@RequestParam  String firstname,
                              @RequestParam String lastname,
                              @RequestParam String birthday) {

        return service.saveParam(firstname, lastname, birthday);
    }

    @GetMapping("/{firstname}")
    public List<Readers> getAllByName(@PathVariable String firstname) {
        return service.findByFirstname(firstname);
    }

    @GetMapping("/{firstname}/{lastname}")
    public ReaderResponseDto getByFirstNameAndLastName(@PathVariable String firstname,
                                                       @PathVariable String lastname) {
        return service.findByFirstnameAndLastname(firstname, lastname);
    }
}