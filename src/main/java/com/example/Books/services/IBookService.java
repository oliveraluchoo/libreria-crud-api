package com.example.Books.services;

import com.example.Books.entities.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(Long id);
    public Book updateBook(Long id, Book book);
    public Book findBookById(Long id);
}
