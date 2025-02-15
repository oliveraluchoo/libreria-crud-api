package com.example.Books.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID cannot be null")
    private Long id;
    @NotBlank(message = "ISBN cannot be blank")
    @NotNull(message = "ID cannot be null")
    private String isbn;
    @NotBlank(message = "Title cannot be blank")
    @NotNull(message = "ID cannot be null")
    private String titulo;
    @NotBlank(message = "Author cannot be blank")
    @NotNull(message = "ID cannot be null")
    private String autor;
    @NotNull(message = "Publication year cannot be null")
    private Integer aniopublicacion;
    @NotBlank(message = "Genre cannot be blank")
    @NotNull(message = "ID cannot be null")
    private String genero;


    public Book(String isbn, String titulo, String autor, Integer aniopublicacion, String genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.aniopublicacion = aniopublicacion;
        this.genero = genero;
    }
}
