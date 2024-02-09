package com.example.demo.repo;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM Book ORDER BY id", nativeQuery = true)
    List<Book> findAllAndOrderById();

    Optional<Book> findBookByRemoveDateIsNullAndId(Long id);

    List<Book> findAllAndBOrderByRemoveDateIsNull();
    @Query("SELECT u FROM Book u WHERE u.bookName = ?1")
    Book findByBookName(String name);

    @Query(value = "SELECT * FROM Book b WHERE b.name = :name and b.published_date = :date ", nativeQuery = true)
    Book findByNameNative(@Param("date") Date date, @Param("name") String name);

    @Query(value = "SELECT b FROM Book b WHERE b.id IN :ids")
    List<Book> findByIdList(@Param("ids") List<Long> ids);

    @Modifying
    @Query("update Book b set b.bookName = :name where b.id = :id")
    int updateForNameById(@Param("name") String name, @Param("id") Long id);

    @Modifying
    @Query(value = "update Book b set b.book_name = ? where b.id = ?", nativeQuery = true)
    int updateForNameByIdNative(String name, Long id);

    @Modifying
    @Query(value = "insert into Users (name, age, email, status) values (:name, :age, :email, :status)", nativeQuery = true)
    void insertUser(@Param("name") String name, @Param("age") Integer age,
                    @Param("status") Integer status, @Param("email") String email)
            ;


    Book findBookByBookName(String name);

    List<Book> findByPublishedDateAndBookName(Date date, String name);

}