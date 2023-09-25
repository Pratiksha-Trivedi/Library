package com.springproject.Library.controller;


import com.springproject.Library.LibraryService.LibraryService;
import com.springproject.Library.entity.Book;

import com.springproject.Library.entity.Library;
import com.springproject.Library.repository.BookRepository;
import com.springproject.Library.repository.LibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController
{
    @GetMapping("/hello")
    public String get()
    {
        return "hello";
    }

    @Autowired
    @Lazy
    private LibraryService libraryService;

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id);
    }
    @PostMapping
    public ResponseEntity<Library> addLibrary(@RequestBody Library library) {
        Library addedLibrary = libraryService.addLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedLibrary);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        Library updatedLibrary = libraryService.updateLibrary(id, library);
        return ResponseEntity.ok(updatedLibrary);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{libraryId}")
    public ResponseEntity<Book> addBookToLibrary(@PathVariable Long libraryId, @RequestBody Book book) {
        Book addedBook = libraryService.addBookToLibrary(libraryId, book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        Book updatedBook = libraryService.updateBook(bookId, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        libraryService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}