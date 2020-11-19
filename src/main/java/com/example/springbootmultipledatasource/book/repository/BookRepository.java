package com.example.springbootmultipledatasource.book.repository;

import com.example.springbootmultipledatasource.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}