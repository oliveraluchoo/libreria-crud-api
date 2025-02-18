package com.example.Books.services;


import com.example.Books.entities.Book;
import com.example.Books.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    public BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("No book with id: " + id));
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Long id, Book newBook) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No book with id: " + id));
        if (newBook.getTitulo() != null){
            book.setTitulo(newBook.getTitulo());
        }
        if(newBook.getIsbn() != null){
            book.setIsbn(newBook.getIsbn());
        }
        if(newBook.getGenero() != null){
            book.setGenero(newBook.getGenero());
        }
        if(newBook.getAutor() != null){
            book.setAutor(newBook.getAutor());
        }
        if(newBook.getAniopublicacion() != null){
            book.setAniopublicacion(newBook.getAniopublicacion());
        }
        book = bookRepository.save(book);
        return book;
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No book with id: " + id));
    }
}
