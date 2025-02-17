package com.example.Books.services;


import com.example.Books.DTO.BookDTO;
import com.example.Books.entities.Book;
import com.example.Books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setTitulo(bookDTO.getTitulo());
        book.setAutor(bookDTO.getAutor());
        book.setAniopublicacion(bookDTO.getAniopublicacion());
        book.setGenero(bookDTO.getGenero());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("No hay libro con id: " + id));
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Long id, Book newBook) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No hay libro con id: " + id));
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
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No book with id: " + id));
    }
}
