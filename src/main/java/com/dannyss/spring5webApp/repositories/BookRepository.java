package com.dannyss.spring5webApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dannyss.spring5webApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
