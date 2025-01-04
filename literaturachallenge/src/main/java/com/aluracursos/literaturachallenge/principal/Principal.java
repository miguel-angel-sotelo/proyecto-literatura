package com.aluracursos.literaturachallenge.principal;

import com.aluracursos.literaturachallenge.model.*;
import com.aluracursos.literaturachallenge.repository.AutorRepository;
import com.aluracursos.literaturachallenge.repository.LibroRepository;
import com.aluracursos.literaturachallenge.service.ConsumoAPI;
import com.aluracursos.literaturachallenge.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;
import java.util.stream.Collectors;
@SpringBootApplication

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<DatosLibros> datosLibros = new ArrayList<>();
    private List<DatosAutor> datosAutores = new ArrayList<>();
    @Autowired
    private LibroRepository repositorio;
    @Autowired
    private AutorRepository repositorioAutor;


//    public Principal(LibroRepository repository) {
//        this.repositorio = repository;
//    }


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """ 
                      ***************************************************
                      *******   Bienvenido a nuestra libreira.    *******
                      ***************************************************
                      
                      Por favor escoge una opcion valida en nuestro menu:
                      
                         1 - Buscar libro por titulo.
                         2 - Ver lista de libros registrados.
                         3 - Lista de autores registrados.
                         4 - Lista de autores vivos en un lapzo de tiempo.
                         5 - Lista de libros por idioma.
                         
                         0 - Salir.... 
                         """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    buscarlibroPorTitulo();
                    break;
                case 2:
                    listarLibrosBuscados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEnRango();
                    break;
                case 5 :
                    listarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }


        }

    }




    private List<DatosLibros> getDatosLibro(){
        System.out.println("Escribe el nombre del libro que deseas buscar.");
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "+") );
        System.out.println(json);
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        List<DatosLibros> datosLibro = datos.resultados();
        return datosLibro;
    }


private void buscarlibroPorTitulo() {

    List<DatosLibros> datos = getDatosLibro();
    for (DatosLibros libro : datos) {
        // Verificar si el autor ya existe en la base de datos
        Autor autor = repositorioAutor.findByNombre(libro.autor().get(0).nombre());
        if (autor == null) {
            // Si el autor no existe, crear uno nuevo y guardarlo
            autor = repositorioAutor.save(new Autor(libro.autor().get(0)));
        }

        // Crear y guardar el libro
        Libro libroEntidad = new Libro(libro,autor);
        System.out.println(libro);
        System.out.println(autor);
        libroEntidad.setAutor(autor);
        repositorio.save(libroEntidad);
        System.out.println(libro);


    }
}

    private void listarLibrosBuscados() {
        List<Libro> libros = repositorio.findAll();
        libros.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = repositorioAutor.findAll();
        System.out.println("Autor:" +  autores);
        autores.forEach(System.out::println);
    }
    private void listarAutoresVivosEnRango() {
        System.out.println("Escribe el año de inicio:");
        int inicio = teclado.nextInt();
        System.out.println("Escribe el año de fin:");
        int fin = teclado.nextInt();

        List<Autor> autores = repositorioAutor.findAll().stream()
                .filter(autor -> (autor.getFechaFallecimiento() == null || autor.getFechaFallecimiento() >= inicio) &&
                        autor.getFechaDeNacimiento() <= fin)
                .collect(Collectors.toList());

        autores.forEach(System.out::println);
    }
    private void listarLibrosPorIdioma() {
        System.out.println("Escribe el idioma que deseas buscar:");
        String idioma = teclado.nextLine();

        List<Libro> libros = repositorio.findAll().stream()
                .filter(libro -> libro.getIdiomas().equalsIgnoreCase(idioma))
                .collect(Collectors.toList());

        libros.forEach(System.out::println);
    }






}



