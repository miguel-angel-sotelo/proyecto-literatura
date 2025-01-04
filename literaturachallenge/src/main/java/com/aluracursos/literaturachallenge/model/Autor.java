package com.aluracursos.literaturachallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaFallecimiento;
    @OneToMany(mappedBy ="autor",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {
    }

    // Constructor modificado
    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento();
        this.fechaFallecimiento = datosAutor.fechaFallecimiento();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l -> l.setAutor(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                "\n nombre='" + nombre +
                "\n fechaDeNacimiento=" + fechaDeNacimiento +
                "\n fechaFallecimiento=" + fechaFallecimiento ;

    }

}

