package com.dannyss.spring5webApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dannyss.spring5webApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
