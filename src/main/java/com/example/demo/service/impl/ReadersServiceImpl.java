package com.example.demo.service.impl;

import com.example.demo.dto.ReaderResponseDto;
import com.example.demo.dto.ReaderSaveDto;
import com.example.demo.entity.Readers;
import com.example.demo.repo.ReaderRepo;
import com.example.demo.service.ReadersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ReadersServiceImpl implements ReadersService {

    private ReaderRepo repo;

    public Long save(ReaderSaveDto model) {
        Readers readers = new Readers();
        readers.setBirthday(model.getBirthday());
        readers.setFirstname(model.getFirstname());
        readers.setLastname(model.getLastname());
        readers = repo.save(readers);
        return readers.getId();
    }

    public Long saveParam(String firstname, String lastname, String birthday) {
        var model = new ReaderSaveDto(
                firstname,
                lastname,
                birthday
        );
        return save(model);
    }

    public List<Readers> findAll() {
        return repo.findAll();
    }

    public List<Readers> findByFirstname(String firstname) {
        return repo.findByFirstname(firstname);
    }

    public ReaderResponseDto findByFirstnameAndLastname(String firstname, String lastname) {

        var reader = repo.findByFirstnameAndLastname(firstname, lastname);
        ReaderResponseDto model = new ReaderResponseDto();
        model.setFirstname(reader.getFirstname());
        model.setLastname(reader.getLastname());
        return model;

    }
}
