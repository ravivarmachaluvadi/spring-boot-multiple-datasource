package com.example.springbootmultipledatasource.model.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AUTHOR_TB")
public class Author {

    @Id
    private int id;
    private String name;
}