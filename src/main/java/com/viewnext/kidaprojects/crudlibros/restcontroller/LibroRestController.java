package com.viewnext.kidaprojects.crudlibros.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.kidaprojects.crudlibros.dto.LibroDTO;
import com.viewnext.kidaprojects.crudlibros.exception.LibroNotFoundException;
import com.viewnext.kidaprojects.crudlibros.service.LibroServiceImpl;

import jakarta.persistence.EntityNotFoundException;

/**
 * Controlador REST para gestionar operaciones CRUD de libros.
 */
@RestController
public class LibroRestController {
	@Autowired
	LibroServiceImpl libroServiceImpl;

	private static final String ISBN_NOT_FOUND = "Isbn Not Found";
	private static final String TITULO_NOT_FOUND = "Título Not Found";

	/**
	 * Obtiene todos los libros.
	 *
	 * @return Una respuesta HTTP con una lista de libros en formato JSON.
	 */
	@GetMapping(value = "libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibroDTO>> getAllLibros() {
		List<LibroDTO> listaLibros = libroServiceImpl.getLibrosDTO();
		
		return ResponseEntity.ok(listaLibros);
	}

	/**
	 * Obtiene un libro por su ISBN.
	 *
	 * @param isbn El ISBN del libro.
	 * @return Una respuesta HTTP con el libro en formato JSON si se encuentra, o un
	 *         mensaje de error si no se encuentra.
	 */
	@GetMapping(value = "libro/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLibroByIsbn(@PathVariable("isbn") String isbn) {
		try {
			LibroDTO libroDTO = libroServiceImpl.getLibroDTOByIsbn(isbn);
			return ResponseEntity.ok(libroDTO);
		} catch (LibroNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * Obtiene un libro por su título.
	 *
	 * @param titulo El título del libro.
	 * @return Una respuesta HTTP con el libro en formato JSON si se encuentra, o un
	 *         mensaje de error si no se encuentra.
	 */
	@GetMapping(value = "libro/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLibroByTitulo(@PathVariable("titulo") String titulo) {
		try {
			LibroDTO libroDTO = libroServiceImpl.getLibroDTOByTitulo(titulo);
			return ResponseEntity.ok(libroDTO);
		} catch (LibroNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * Crea un nuevo libro.
	 *
	 * @param libro El libro que se va a crear en formato JSON.
	 * @return Una respuesta HTTP con el libro creado en formato JSON.
	 */
	@PostMapping(value = "libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createLibro(@RequestBody LibroDTO libroDTO) {
		libroServiceImpl.createLibroDTO(libroDTO);
		return ResponseEntity.ok(libroDTO);
	}

	/**
	 * Actualiza un libro existente.
	 *
	 * @param libro El libro que se va a actualizar en formato JSON.
	 * @return Una respuesta HTTP con el libro actualizado en formato JSON si se
	 *         encuentra, o un mensaje de error si no se encuentra.
	 */
	@PutMapping(value = "libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateLibro(@RequestBody LibroDTO libroDTO) {
		try {
			libroServiceImpl.updateLibroDTO(libroDTO);
			return ResponseEntity.ok(libroDTO);
		} catch (LibroNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	/**
	 * Elimina un libro por su ISBN.
	 *
	 * @param isbn El ISBN del libro que se va a eliminar.
	 * @return Una respuesta HTTP sin contenido si se elimina correctamente, o un
	 *         mensaje de error si el libro no se encuentra.
	 */
	@DeleteMapping(value = "value/{isbn}")
	public ResponseEntity<?> deleteLibroByIsbn(@PathVariable("isbn") String isbn) {
		try {
			libroServiceImpl.deleteLibroByIsbn(isbn);
			return ResponseEntity.noContent().build();
		} catch (LibroNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
