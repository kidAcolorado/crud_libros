package com.viewnext.kidaprojects.crudlibros.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.viewnext.kidaprojects.crudlibros.dto.LibroDTO;
import com.viewnext.kidaprojects.crudlibros.model.Libro;

@Component
public class LibroMapper {

	public LibroDTO toLibroDTO(Libro libro) {
		LibroDTO libroDTO = new LibroDTO();

		libroDTO.setIsbnDTO(libro.getIsbn());
		libroDTO.setTituloDTO(libro.getTitulo());
		libroDTO.setTematicaDTO(libro.getTematica());

		return libroDTO;
	}

	public Libro toLibro(LibroDTO libroDTO) {
		Libro libro = new Libro();

		libro.setIsbn(libroDTO.getIsbnDTO());
		libro.setTitulo(libroDTO.getTituloDTO());
		libro.setTematica(libroDTO.getTematicaDTO());

		return libro;
	}

	public List<LibroDTO> toListaLibrosDTO(List<Libro> listaLibros) {

		return listaLibros.stream()
				.map(this::toLibroDTO)
				.toList();
	}
	
	public List<Libro> toListaLibros(List<LibroDTO> listaLibrosDTO){
		
		return listaLibrosDTO.stream()
				.map(this::toLibro)
				.toList();
	}
}
