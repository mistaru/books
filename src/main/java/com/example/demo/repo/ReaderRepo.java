package com.example.demo.repo;
import com.example.demo.entity.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepo extends JpaRepository <Readers, Integer> {
    List<Readers> findByFirstname(String firstname);
    Readers findByFirstnameAndLastname(String firstname, String lastname);

    @Query(value = "update readers r set r.first_name = ?2 where r.id = ?1", nativeQuery = true)
    int setFirstnameFor(Long id, String firstName);

}