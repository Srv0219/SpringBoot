package com.api.book.springbootrestapi.Dao;

import com.api.book.springbootrestapi.Entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}
