package com.viewnext.kidaprojects.crudlibros.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.viewnext.kidaprojects.crudlibros.dto.LibroDTO;
import com.viewnext.kidaprojects.crudlibros.exception.LibroNotFoundException;
import com.viewnext.kidaprojects.crudlibros.mapper.LibroMapper;
import com.viewnext.kidaprojects.crudlibros.model.Libro;

import jakarta.persistence.EntityNotFoundException;

/**
 * Esta clase implementa la interfaz LibroService y proporciona los servicios para la gestión de libros.
 * 
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 25 de Septiembre de 2023
 */
@Service
public class LibroServiceImpl implements LibroService {

    
    private List<Libro> listaLibros;
    
    private LibroMapper libroMapper;

    /**
     * Constructor de la clase LibroServiceImpl.
     * 
     * @param libroMapper El objeto LibroMapper utilizado para mapear entre Libro y LibroDTO.
     */
    public LibroServiceImpl(LibroMapper libroMapper) {
    	this.libroMapper = libroMapper;
        
        listaLibros = new ArrayList<>();

        // Agregar 20 libros ficticios a la lista (esto es solo un ejemplo).
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

    /**
     * Obtiene una lista de todos los libros.
     *
     * @return Una lista que contiene todos los libros disponibles.
     */
    @Override
    public List<Libro> getAllLibros() {
        return listaLibros;
    }
    
    public List<LibroDTO> getLibrosDTO(){
    	List<LibroDTO> listaLibrosDTO = libroMapper.toListaLibrosDTO(getAllLibros());    	
		return listaLibrosDTO;
    	
    }

    /**
     * Obtiene un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return Un objeto Optional que puede contener el libro encontrado, o estar vacío si no se encuentra.
     */
    @Override
    public Optional<Libro> getLibroByIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return Optional.of(libro);
            }
        }
        return Optional.empty();
    }
    
    /**
     * Obtiene un LibroDTO por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return El LibroDTO encontrado.
     * @throws LibroNotFoundException Si el libro no se encuentra en la base de datos.
     */
    public LibroDTO getLibroDTOByIsbn(String isbn) {
    	Optional<Libro> optionalLibro = getLibroByIsbn(isbn);
    	
    	if(optionalLibro.isEmpty()) {
    		throw new LibroNotFoundException(isbn);
    	}
    	
    	return libroMapper.toLibroDTO(optionalLibro.get());
    	    	
    }
    
    
    
    

    /**
     * Obtiene un libro por su título.
     *
     * @param titulo El título del libro a buscar.
     * @return Un objeto Optional que puede contener el libro encontrado, o estar vacío si no se encuentra.
     */
    @Override
    public Optional<Libro> getLibroByTitulo(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equals(titulo)) {
                return Optional.of(libro);
            }
        }
        return Optional.empty();
    }
    
    /**
     * Obtiene un LibroDTO por su título.
     *
     * @param titulo El título del libro a buscar.
     * @return El LibroDTO encontrado.
     * @throws LibroNotFoundException Si el libro no se encuentra en la base de datos.
     */
    public LibroDTO getLibroDTOByTitulo(String titulo) {
        Optional<Libro> optionalLibro = getLibroByTitulo(titulo);

        if (optionalLibro.isEmpty()) {
            throw new LibroNotFoundException(titulo);
        }

        return libroMapper.toLibroDTO(optionalLibro.get());
    }

    

    /**
     * Crea un nuevo libro.
     *
     * @param libro El libro a crear.
     * @return El libro creado.
     */
    @Override
    public Libro createLibro(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }
    
    /**
     * Crea y devuelve un LibroDTO a partir de un LibroDTO proporcionado.
     *
     * @param libroDTO El LibroDTO para crear.
     * @return El LibroDTO creado.
     */
    public LibroDTO createLibroDTO(LibroDTO libroDTO) {
        Libro libro = libroMapper.toLibro(libroDTO);
        return libroMapper.toLibroDTO(createLibro(libro));
    }

    /**
     * Verifica si un libro existe en la base de datos por su ISBN.
     *
     * @param isbn El ISBN del libro a verificar.
     * @return true si el libro existe, false en caso contrario.
     */
    @Override
    public boolean existByIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return true; // Si se encuentra el libro, retornamos true
            }
        }
        return false; // Si no se encuentra el libro, retornamos false
    }

    /**
     * Elimina un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a eliminar.
     * @throws EntityNotFoundException Si el libro no se encuentra en la base de datos.
     */
    @Override
    public void deleteLibroByIsbn(String isbn) throws LibroNotFoundException {
        if (!existByIsbn(isbn)) {
            throw new LibroNotFoundException(isbn);
        }

        Iterator<Libro> iterator = listaLibros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getIsbn().equals(isbn)) {
                iterator.remove();
            }
        }
    }
    
   

    /**
     * Actualiza la información de un libro existente utilizando un objeto Libro.
     *
     * @param libroForUpdate El libro con la información actualizada.
     * @return El libro actualizado.
     * @throws LibroNotFoundException Si el libro no se encuentra en la base de datos.
     */
    @Override
    public Libro updateLibro(Libro libroForUpdate) throws LibroNotFoundException {
        Optional<Libro> optionalLibro = getLibroByIsbn(libroForUpdate.getIsbn());

        if (optionalLibro.isEmpty()) {
            throw new LibroNotFoundException(libroForUpdate.getIsbn());
        }

        Libro libro = optionalLibro.get();

        libro.setIsbn(libroForUpdate.getIsbn());
        libro.setTitulo(libroForUpdate.getTitulo());
        libro.setTematica(libroForUpdate.getTematica());

        return libro;
    }

    /**
     * Actualiza la información de un libro existente utilizando un objeto LibroDTO.
     *
     * @param libroDTO El LibroDTO con la información actualizada.
     * @return El LibroDTO actualizado.
     * @throws LibroNotFoundException Si el libro no se encuentra en la base de datos.
     */
    public LibroDTO updateLibroDTO(LibroDTO libroDTO) throws LibroNotFoundException {
        Libro libroForUpdate = libroMapper.toLibro(libroDTO);
        Libro libroActualizado = updateLibro(libroForUpdate);
        return libroMapper.toLibroDTO(libroActualizado);
    }

}
