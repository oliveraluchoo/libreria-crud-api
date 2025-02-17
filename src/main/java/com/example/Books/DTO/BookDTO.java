package com.example.Books.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private String isbn;
    private String titulo;
    private String autor;
    private Integer aniopublicacion;
    private String genero;
}
