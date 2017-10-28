package com.dannyss.spring5webApp.repositories;

import com.dannyss.spring5webApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
