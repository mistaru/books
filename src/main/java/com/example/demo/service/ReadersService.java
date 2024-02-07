package com.example.demo.service;

import com.example.demo.dto.ReaderResponseDto;
import com.example.demo.dto.ReaderSaveDto;
import com.example.demo.entity.Readers;

import java.util.List;

public interface ReadersService {

    Long save(ReaderSaveDto model);

    Long saveParam(String firstname, String lastname, String birthday);

    List<Readers> findAll();

    List<Readers> findByFirstname(String firstname);

    ReaderResponseDto findByFirstnameAndLastname(String firstname, String lastname);
}