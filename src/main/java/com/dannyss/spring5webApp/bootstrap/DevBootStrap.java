package com.dannyss.spring5webApp.bootstrap;

import com.dannyss.spring5webApp.model.Publisher;
import com.dannyss.spring5webApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.dannyss.spring5webApp.model.Author;
import com.dannyss.spring5webApp.model.Book;
import com.dannyss.spring5webApp.repositories.AuthorRepository;
import com.dannyss.spring5webApp.repositories.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();	
	}

	private void initData() {

		Publisher publisher = new Publisher();
		publisher.setName("Harper Collins");
		publisher.setAddress("London");
		publisherRepository.save(publisher);

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "12345", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Publisher publisher1 = new Publisher();
		publisher1.setName("Worx");
		publisher1.setAddress("New York");
		publisherRepository.save(publisher1);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE development without EJB", "23456", publisher1);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

}
