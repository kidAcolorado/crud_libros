package com.viewnext.kidaprojects.crudlibros.exception;

import java.io.Serializable;



/**
 * Excepción personalizada para indicar que un libro no ha sido encontrado por su isbn.
 * Esta excepción se lanza cuando se busca un curso y no se encuentra en la lista de cursos.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 26 de Septiembre de 2023
 */
public class LibroNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Crea una nueva instancia de la excepción con el mensaje especificado.
     *
     * @param codigo El código del curso que no se ha encontrado.
     */
    public LibroNotFoundException(String isbn) {
        super("El libro con isbn " + isbn + " no ha sido encontrado.");
    }
}
