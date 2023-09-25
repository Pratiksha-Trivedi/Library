package com.springproject.Library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)@Column(name="id",nullable = false)
    private Long id;
    private String name;
    private String author;
    @ManyToOne
    @JsonBackReference
    private Library library;

    @NotBlank(message = "Libraryname is required")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library=library;
    }

    public Long getId() {
        return id;
    }
}