<h1>Proyecto-literatura</h1>

Estado del proyecto: Concluido.
Descripción del proyecto:
Este proyecto trata sobre una app creada para ofrecer un menú interactivo en consola, desarrollada con el lenguaje de programación Java y consumiendo la API de libros GUTENDEX, que proporciona información básica de libros como: "Título", "Autor", "Idiomas" y "Número de descargas". El menú interactivo ofrecerá opciones como buscar un libro en la web, almacenar los datos del autor y mostrarlos en la consola, almacenar los títulos de los libros y mostrarlos en la consola, y mostrar una lista de autores vivos en un lapso de tiempo. También incluye mostrar una lista de libros por idioma.
- <h1>Herramientas utilizadas</h1>
La app se desarrolló utilizando herramientas como:

1- Spring initializer.

2- Maven repository 3.8.1.

3- Intellij IDEA.

4- lenguaje de programacion java 17.

5- Base de datos PosgreSQL.

6- API de libreria Gutendex.

<h1>Uso de la app</h1>

Al iniciar la app, mostrará un menú interactivo, el cual desplegará un título, una instrucción y un menú con 6 opciones. 
Aquí tienes un ejemplo gráfico:

![image](https://github.com/user-attachments/assets/eff5644a-5f64-4b70-8e19-8135b7f96115)

<h1Funcionalidades de cada opción:</h1>

Al escoger la opción uno "Buscar libro por título", se le pedirá al usuario que ingrese el nombre del libro deseado. Esto hará una requisición a la app de Gutendex, la cual devolverá una respuesta en formato JSON que traerá información esencial, como: título del libro, datos del autor ("nombre del autor", "fecha de nacimiento", "idioma del libro", "número de descargas del libro"). Esta informacion se guardara automaticamente en la base de datos posgreSQL utilizando pgAdmin 4 .

La opcion dos "Ver lista de libros registrados:" se mostrara cada libro con su respectiva informacion que se ha guardado en pgAdmin4 en el trancurso de cada busqueda.

Por otro lado la opcion 3 "Lista de autores registrado" nos imprimira en consola la informacion de todos los autores guardados en la base de datos ,esta informacion incluye:
Nombre,fecha de nacimiento y fecha de fallecimiento.

la opcion cuatro "Lista de autores vivos en un lapso de tiempo",imprimira en pantalla dos requerimientos ,"Ingresa el año de inicio" y "Ingresa el año fin" este metodo trae todas las listas de autores de la base de datos y la filtrara para encontrara y mostrar solo las coicidencias entre dichas fechas declaradas por el usuario.

Siguiente a eso la opcion cinco "Lista de libros por idioma" imprimira en consola un requerimiento al usuario pidiendo que indique las siglas del idioma deseado,porterior a esto el metodo filtrara la coincidencia de idiomas de los libros guardados en la base de datos, para luego imprimir en consola los resultados deseados.

Por ultimo la opcion cero "salir..." finalizara el proceso cerrando la aplicacion 
