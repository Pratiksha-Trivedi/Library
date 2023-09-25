package com.springproject.Library.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="library")
public class Library {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)@Column(name ="id",nullable = false)
    private Long id;
    private String name;
    @NotNull(message = "date is required")
    private LocalDate issue;
    @NotNull(message = "date is required")
    private LocalDate submit;
    @OneToMany(mappedBy = "library")
    @JsonManagedReference
    private List<Book> books;

    public Library() {
    }

    public Library(String name, LocalDate issue, LocalDate submit, List<Book> books) {
        this.name = name;
        this. issue= issue;
        this.submit= submit;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    @NotBlank(message = "name is required")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getIssue() {
        return issue;
    }

    public void setIssue(LocalDate issue) {
        this.issue = issue;
    }

    public LocalDate getSubmit() {
        return submit;
    }
    public void setSubmit(LocalDate submit) {
        this.submit= submit;
    }


    public void setDob(LocalDate submit) {
        this.submit= submit;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}