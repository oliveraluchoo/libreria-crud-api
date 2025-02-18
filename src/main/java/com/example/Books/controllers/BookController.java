package com.example.Books.controllers;


import com.example.Books.entities.Book;
import com.example.Books.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    @Operation(summary = "Gets all books", description = "Gets all books.")
    @ApiResponse(responseCode = "200",description = "List of all books", content = @Content(mediaType = "application/json",array = @ArraySchema(schema = @Schema(implementation = Book.class))))
    @ApiResponse(responseCode = "400", description = "Request error")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    @Operation(summary = "Insert book",description = "Insert a new book")
    @ApiResponse(responseCode = "200",description = "Book inserted succesfully", content = @Content(mediaType = "application/json",schema = @Schema(implementation = Book.class)))
    @ApiResponse(responseCode = "400",description = "Request error")
    @ApiResponse(responseCode = "500",description = "Internal server error")
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets book by id",description = "Gets a book by id")
    @ApiResponse(responseCode = "200",description = "Book found",content = @Content(mediaType = "application/json",schema = @Schema(implementation = Book.class)))
    @ApiResponse(responseCode = "400",description = "Request error")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    @Parameter(description = "ID of the book to retrieve", required = true, example = "1")
    public Book findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a book by id",description = "Deletes a book by id.")
    @ApiResponse(responseCode = "200",description = "Book deleted succesfully")
    @ApiResponse(responseCode = "400",description = "Request error")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    @Parameter(description = "ID of the book to delete", required = true, example = "1")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates a book by id",description = "Updates a book by id.")
    @ApiResponse(responseCode = "200",description = "Book updated succesfully",content = @Content(mediaType = "application/json",schema = @Schema(implementation = Book.class)))
    @ApiResponse(responseCode = "400",description = "Request error")
    @ApiResponse(responseCode = "500",description = "Internal server error")
    @Parameter(description = "ID of the book to update", required = true, example = "1")
        return bookService.updateBook(id,book);
    }
}
