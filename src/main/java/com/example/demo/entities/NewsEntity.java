package com.example.demo.entities;

import java.util.Date;

import com.example.demo.repository.CategoriaNewsRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
@Entity
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private String desarrollo;

    private Date fecha;

    private String url;

    private String resumen;

    @ManyToOne()
    @JoinColumn(name = "categoria_id", nullable = false)
    private CatergoriaNews categoria;

    public NewsEntity(String titulo, String desarrollo, String resumen, CatergoriaNews categoria, Date fecha){
        this.titulo  = titulo;
        this.desarrollo = desarrollo;
        this.resumen = resumen;
        this.categoria = categoria;
        this.fecha = fecha;
    }
    public NewsEntity(int id, String titulo, String desarrollo, String resumen, CatergoriaNews categoria, Date fecha){
        this.id = id;
        this.titulo  = titulo;
        this.desarrollo = desarrollo;
        this.resumen = resumen;
        this.categoria = categoria;
        this.fecha = fecha;
    }
}
