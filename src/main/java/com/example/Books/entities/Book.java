package com.example.Books.entities;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Book's isbn",example = "100")
    private String isbn;
    @NotBlank(message = "Title cannot be blank")
    @NotNull(message = "ID cannot be null")
    @Schema(description = "Book's title",example = "Don Quijote")
    private String titulo;
    @NotBlank(message = "Author cannot be blank")
    @NotNull(message = "ID cannot be null")
    @Schema(description = "Book's author",example = "Miguel de Cervantes")
    private String autor;
    @NotNull(message = "Publication year cannot be null")
    @Schema(description = "Book's release year",example = "2024")
    private Integer aniopublicacion;
    @NotBlank(message = "Genre cannot be blank")
    @NotNull(message = "ID cannot be null")
    @Schema(description = "Book's genre",example = "drama")
    private String genero;


    public Book(String isbn, String titulo, String autor, Integer aniopublicacion, String genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.aniopublicacion = aniopublicacion;
        this.genero = genero;
    }
}
