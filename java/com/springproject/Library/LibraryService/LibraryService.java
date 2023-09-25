package com.springproject.Library.LibraryService;

import java.util.List;

import com.springproject.Library.entity.Book;
import com.springproject.Library.entity.Library;

public interface LibraryService {
    List<Library> getAllLibraries();

    Library getLibraryById(Long id);

    Library addLibrary(Library library);

    void deleteLibrary(Long id);

    Library updateLibrary(Long id, Library library);

    Book addBookToLibrary(Long libraryId, Book book);

    Book updateBook(Long bookId, Book book);

    void deleteBook(Long bookId);
}