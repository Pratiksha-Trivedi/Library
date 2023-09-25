package com.springproject.Library.repository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.Library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>
{
    @Transactional

    void deleteByLibraryId(long studentId);
}