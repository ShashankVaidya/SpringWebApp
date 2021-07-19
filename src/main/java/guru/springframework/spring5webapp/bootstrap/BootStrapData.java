package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Author shashank = new Author("Shashank","Vaidya");
		Book ddd = new Book("Domain Driven Design", "123123");
		
		Publisher selina = new Publisher("Selina", "MG Road, Bengaluru, Karnataka, 560001"); 
		Publisher penguin = new Publisher("Penguin", "Hi Road, Bengaluru, Karnataka, 560091");
		
		publisherRepository.save(selina);
		publisherRepository.save(penguin);
		
		shashank.getBooks().add(ddd);
		ddd.getAuthors().add(shashank);
		
		authorRepository.save(shashank);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE without EJB", "369369");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		System.out.println("Made using bootstrap");
		System.out.println("Number of books: "+bookRepository.count());
		System.out.println("Number of publishers is: "+publisherRepository.count());
		
	}
	
	

}
