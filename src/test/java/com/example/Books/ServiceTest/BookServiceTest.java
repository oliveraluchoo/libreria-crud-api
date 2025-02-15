package com.example.Books.ServiceTest;

import com.example.Books.entities.Book;
import com.example.Books.repositories.BookRepository;
import com.example.Books.services.BookService;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void init(){
        bookService = new BookService(bookRepository);
    }
    @Test
    public void testGetAllBooks(){
        List<Book> list = new ArrayList<>();
        list.add(new Book());
        list.add(new Book());

        when(bookRepository.findAll()).thenReturn(list);
        List<Book> newList = bookRepository.findAll();

        assertNotNull(newList);
        assertFalse(newList.isEmpty());
        verify(bookRepository,times(1)).findAll();
    }

    @Test
    public void testAddBook(){
        Book book = new Book("100","El Aleph","Jorge Luis Borges", 1949,"Ficcion");
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookRepository.save(book);

        assertNotNull(savedBook);
        assertEquals("100",savedBook.getIsbn());
        assertEquals("El Aleph",savedBook.getTitulo());
        assertEquals("Jorge Luis Borges",savedBook.getAutor());
        assertEquals(1949,savedBook.getAniopublicacion());
        assertEquals("Ficcion",savedBook.getGenero());
    }

    @Test
    public void testDeleteBook(){
        Book book = new Book();
        book.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        doNothing().when(bookRepository).deleteById(1L);
        bookService.deleteBook(1L);

        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository,times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateBook(){
        Book book = Book.builder().autor("").id(1L).aniopublicacion(0).isbn("0").genero("").titulo("").build();
        Book update = Book.builder().id(10L).autor("Julio Cortazar").isbn("100").titulo("Casa tomada").genero("Ficcion").aniopublicacion(1946).build();

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(update);

        Book updatedBook = bookService.updateBook(1L,update);

        assertNotNull(updatedBook);
        assertEquals("Julio Cortazar", updatedBook.getAutor());
        assertEquals(10L,updatedBook.getId());
        assertEquals("100",updatedBook.getIsbn());
        assertEquals("Casa tomada",updatedBook.getTitulo());
        assertEquals("Ficcion",updatedBook.getGenero());

        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testFindBookById(){
        Book book = new Book();
        book.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book searchedBook = bookService.findBookById(1L);
        assertNotNull(searchedBook);

        verify(bookRepository,times(1)).findById(1L);
    }
}
