package com.aluracursos.literaturachallenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idiomas;
    private Double numeroDeDescargas;

    public Libro(){}


    public Libro(DatosLibros datosLibros,Autor autor) {
        this.titulo = datosLibros.titulo();
        this.autor = autor;
        this.idiomas = datosLibros.idiomas().get(0);

        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }


    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                "\n titulo='" + titulo +
                "\nautor=" + autor +
                "\nidiomas='" + idiomas + '\'' +
                "numeroDeDescargas=" + numeroDeDescargas;
    }
}



