package com.viewnext.kidaprojects.crudlibros.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.viewnext.kidaprojects.crudlibros.dto.LibroDTO;
import com.viewnext.kidaprojects.crudlibros.mapper.LibroMapper;
import com.viewnext.kidaprojects.crudlibros.model.Libro;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LibroServiceImpl implements LibroService {

	private LibroMapper libroMapper;
	private List<Libro> listaLibros;

	public LibroServiceImpl(LibroMapper libroMapper) {
		this.libroMapper = libroMapper;

		listaLibros = new ArrayList<>();

		// Agregar 20 libros ficticios a la lista
		listaLibros.add(new Libro("978-0451169518", "1984", "Ciencia ficción"));
		listaLibros.add(new Libro("978-0141036144", "Rebelión en la granja", "Sátira política"));
		listaLibros.add(new Libro("978-0061120084", "Matar a un ruiseñor", "Novela clásica"));
		listaLibros.add(new Libro("978-0307473653", "Cien años de soledad", "Realismo mágico"));
		listaLibros.add(new Libro("978-1400034770", "El gran Gatsby", "Ficción literaria"));
		listaLibros.add(new Libro("978-0143135473", "Los hombres me explican cosas", "Ensayo feminista"));
		listaLibros.add(new Libro("978-0451526342", "Moby-Dick", "Aventura"));
		listaLibros.add(new Libro("978-0061120084", "Matar a un ruiseñor", "Novela clásica"));
		listaLibros.add(new Libro("978-0671027343", "Juego de tronos", "Fantasía épica"));
		listaLibros.add(new Libro("978-0143039959", "El código Da Vinci", "Misterio"));
		listaLibros.add(new Libro("978-0451191151", "Crimen y castigo", "Novela psicológica"));
		listaLibros.add(new Libro("978-0743273565", "El Gran Diseño", "Divulgación científica"));
		listaLibros.add(new Libro("978-0307277671", "Las ventajas de ser invisible", "Novela juvenil"));
		listaLibros.add(new Libro("978-8408043649", "El alquimista", "Novela espiritual"));
		listaLibros.add(new Libro("978-0312427344", "Las correcciones", "Ficción contemporánea"));
		listaLibros.add(new Libro("978-0062457790", "La chica del tren", "Thriller psicológico"));
		listaLibros.add(new Libro("978-1984801258", "Educated: A Memoir", "Memorias"));
		listaLibros.add(new Libro("978-8417780200", "La sombra del viento", "Novela histórica"));
		listaLibros.add(new Libro("978-0451457998", "Neuromante", "Ciencia ficción"));
		listaLibros.add(new Libro("978-0060512806", "El amor en los tiempos del cólera", "Novela romántica"));
	}

	@Override
	public List<Libro> getAllLibros() {

		return listaLibros;
	}

	public List<LibroDTO> getLibrosDTO() {

		List<LibroDTO> listaLibrosDTO = libroMapper.toListaLibrosDTO(getAllLibros());
		return listaLibrosDTO;
	}

	@Override
	public Optional<Libro> getLibroByIsbn(String isbn) {

		for (Libro libro : listaLibros) {
			if (libro.getIsbn().equals(isbn)) {
				return Optional.of(libro);
			}
		}

		return Optional.empty();

	}

	public LibroDTO getLibroDTOByIsbn(String isbn) throws EntityNotFoundException {
		Optional<Libro> optionalLibro = getLibroByIsbn(isbn);

		if (optionalLibro.isPresent()) {
			return libroMapper.toLibroDTO(optionalLibro.get());
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public Optional<Libro> getLibroByTitulo(String titulo) {

		for (Libro libro : listaLibros) {
			if (libro.getTitulo().equals(titulo)) {
				return Optional.of(libro);
			}
		}
		return Optional.empty();
	}

	public LibroDTO getLibroDTOByTitulo(String titulo) throws EntityNotFoundException {
		Optional<Libro> optionalLibro = getLibroByTitulo(titulo);

		if (optionalLibro.isPresent()) {
			return libroMapper.toLibroDTO(optionalLibro.get());
		} else {
			throw new EntityNotFoundException();
		}

	}

	@Override
	public Libro createLibro(Libro libro) {
		listaLibros.add(libro);
		return libro;
	}

	public LibroDTO createLibroDTO(LibroDTO libroDTO) {
		Libro libro = libroMapper.toLibro(libroDTO);

		return libroMapper.toLibroDTO(createLibro(libro));
	}

	@Override
	public boolean existByIsbn(String isbn) {

		for (Libro libro : listaLibros) {
			if (libro.getIsbn().equals(isbn)) {
				return true; // Si se encuentra el libro, retornamos true
			}
		}
		return false; // Si no se encuentra el libro, retornamos false
	}

	@Override
	public void deleteLibroByIsbn(String isbn) throws EntityNotFoundException{
		if(!existByIsbn(isbn)) {
			throw new EntityNotFoundException();
		}
		
		Iterator<Libro> iterator = listaLibros.iterator();
		while (iterator.hasNext()) {
			Libro libro = iterator.next();
			if (libro.getIsbn().equals(isbn)) {

				iterator.remove();

			}
		}

	}
	

	@Override
	public Libro updateLibro(Libro libroForUpdate) throws EntityNotFoundException{
		Optional<Libro> optionalLibro = getLibroByIsbn(libroForUpdate.getIsbn());
		
		if (optionalLibro.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		Libro libro = optionalLibro.get();
		
		libro.setIsbn(libroForUpdate.getIsbn());		
		libro.setTitulo(libroForUpdate.getTitulo());
		libro.setTematica(libroForUpdate.getTematica());
		
		return libro;
		
	}
	
	public LibroDTO updateLibroDTO(LibroDTO libroDTO){
		
		Libro libroForUpdate = libroMapper.toLibro(libroDTO);
		
		libroDTO = libroMapper.toLibroDTO(updateLibro(libroForUpdate)); 
		
		return libroDTO;
	}

}