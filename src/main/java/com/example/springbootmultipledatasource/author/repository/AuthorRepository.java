package com.example.springbootmultipledatasource.author.repository;

import com.example.springbootmultipledatasource.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}