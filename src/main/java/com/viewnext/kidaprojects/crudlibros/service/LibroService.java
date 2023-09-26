package com.viewnext.kidaprojects.crudlibros.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.kidaprojects.crudlibros.model.Libro;

public interface LibroService {

	public List<Libro> getAllLibros();
	
	public Optional<Libro> getLibroByIsbn(String isbn);
	
	public Optional<Libro> getLibroByTitulo(String titulo);
	
	public Libro createLibro(Libro libro);
	
	public boolean existByIsbn(String isbn);
	
	public void deleteLibroByIsbn(String isbn);
	
	public Libro updateLibro(Libro libro);
	
}
