package com.example.springbootmultipledatasource.user.repository;

import com.example.springbootmultipledatasource.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
