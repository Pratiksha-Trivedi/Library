package com.springproject.Library.LibraryService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.springproject.Library.entity.Book;
import com.springproject.Library.entity.Library;
import com.springproject.Library.repository.BookRepository;
import com.springproject.Library.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	public LibraryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	   @Autowired
	    private LibraryRepository libraryRepository;

	    @Autowired
	    private BookRepository bookRepository;

	    @Override
	    public List<Library> getAllLibraries() {
	        return libraryRepository.findAll();
	    }

	    @Override
	    public Library getLibraryById(Long id) {
	        return libraryRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Library addLibrary(Library library) {
	        return libraryRepository.save(library);
	    }

	    @Override
	    public void deleteLibrary(Long id) {
	        libraryRepository.deleteById(id);
	    }

	    @Override
	    public Library updateLibrary(Long id, Library library) {
	        Optional<Library> optional = libraryRepository.findById(id);
	        if (optional.isPresent()) {
	            Library existingLibrary = optional.get();
	            existingLibrary.setName(library.getName());
	            existingLibrary.setIssue(library.getIssue());
	            existingLibrary.setSubmit(library.getSubmit());
	            return libraryRepository.save(existingLibrary);
	        }
	        return null;
	    }

	    @Override
	    public Book addBookToLibrary(Long libraryId, Book book) {
	        Optional<Library> optional = libraryRepository.findById(libraryId);
	        if (optional.isPresent()) {
	            Library library = optional.get();
	            book.setLibrary(library);
	            library.getBooks().add(book);
	            bookRepository.save(book);
	            return book;
	        }
	        return null;
	    }

	    @Override
	    public Book updateBook(Long bookId, Book book) {
	        Optional<Book> optional = bookRepository.findById(bookId);
	        if (optional.isPresent()) {
	            Book existingBook = optional.get();
	            existingBook.setName(book.getName());
	            existingBook.setAuthor(book.getAuthor());
	            return bookRepository.save(existingBook);
	        }
	        return null;
	    }

	    @Override
	    public void deleteBook(Long bookId) {
	        bookRepository.deleteById(bookId);
	    }
	}