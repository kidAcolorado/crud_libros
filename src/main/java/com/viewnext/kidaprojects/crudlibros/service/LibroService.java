package com.viewnext.kidaprojects.crudlibros.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.kidaprojects.crudlibros.model.Libro;

/**
 * Esta interfaz define los servicios disponibles para la gestión de libros.
 *
 * <p>
 * El autor de esta interfaz es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 25 de Septiembre de 2023
 */
public interface LibroService {

    /**
     * Obtiene una lista de todos los libros.
     *
     * @return Una lista que contiene todos los libros disponibles.
     */
    public List<Libro> getAllLibros();

    /**
     * Obtiene un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return Un objeto Optional que puede contener el libro encontrado, o estar vacío si no se encuentra.
     */
    public Optional<Libro> getLibroByIsbn(String isbn);

    /**
     * Obtiene un libro por su título.
     *
     * @param titulo El título del libro a buscar.
     * @return Un objeto Optional que puede contener el libro encontrado, o estar vacío si no se encuentra.
     */
    public Optional<Libro> getLibroByTitulo(String titulo);

    /**
     * Crea un nuevo libro.
     *
     * @param libro El libro a crear.
     * @return El libro creado.
     */
    public Libro createLibro(Libro libro);

    /**
     * Verifica si un libro existe en la base de datos por su ISBN.
     *
     * @param isbn El ISBN del libro a verificar.
     * @return true si el libro existe, false en caso contrario.
     */
    public boolean existByIsbn(String isbn);

    /**
     * Elimina un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a eliminar.
     */
    public void deleteLibroByIsbn(String isbn);

    /**
     * Actualiza la información de un libro existente.
     *
     * @param libro El libro con la información actualizada.
     * @return El libro actualizado.
     */
    public Libro updateLibro(Libro libro);
}
