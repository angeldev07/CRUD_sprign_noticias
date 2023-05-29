package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewDTO {
    private int id;
    private String titulo;
    private String desarrollo;
    private String resumen;
    private int categoriaId;
    
    public NewDTO(String titulo, String desarrollo, String resumen, int categoriaId) {
        this.titulo = titulo;
        this.desarrollo = desarrollo;
        this.resumen = resumen;
        this.categoriaId = categoriaId;
    }

    
}
