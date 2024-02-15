package com.example.demo.repo;
import com.example.demo.entity.BookReserve;
import com.example.demo.entity.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookReserveRepo extends JpaRepository <BookReserve, Long> {
    List<BookReserve> findAllByReturnDateBefore(Date date);



}