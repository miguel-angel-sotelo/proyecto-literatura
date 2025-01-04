package com.aluracursos.literaturachallenge.repository;

import com.aluracursos.literaturachallenge.model.Autor;
import com.aluracursos.literaturachallenge.model.DatosLibros;
import com.aluracursos.literaturachallenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {

}
