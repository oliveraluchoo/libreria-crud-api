package com.example.Books.entities;

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
    private Long id;
    @NotBlank(message = "ISBN cannot be blank")
    private String isbn;
    @NotBlank(message = "Title cannot be blank")
    private String titulo;
    @NotBlank(message = "Author cannot be blank")
    private String autor;
    @NotNull(message = "Publication year cannot be null")
    private Integer aniopublicacion;
    @NotBlank(message = "Genre cannot be blank")
    private String genero;


}
