package com.viewnext.kidaprojects.crudlibros.dto;


/**
 * Esta clase representa un objeto de transferencia de datos (DTO) para un libro.
 * Un objeto LibroDTO contiene información básica sobre un libro, como su ISBN, título y temática.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 25 de Septiembre de 2023
 */
public class LibroDTO {
	
	private String isbnDTO;
	private String tituloDTO;
	private String tematicaDTO;
	
	public LibroDTO(String isbnDTO, String tituloDTO, String tematicaDTO) {
		super();
		this.isbnDTO = isbnDTO;
		this.tituloDTO = tituloDTO;
		this.tematicaDTO = tematicaDTO;
	}
	
	public LibroDTO() {
		
	}

	public String getIsbnDTO() {
		return isbnDTO;
	}

	public void setIsbnDTO(String isbnDTO) {
		this.isbnDTO = isbnDTO;
	}

	public String getTituloDTO() {
		return tituloDTO;
	}

	public void setTituloDTO(String tituloDTO) {
		this.tituloDTO = tituloDTO;
	}

	public String getTematicaDTO() {
		return tematicaDTO;
	}

	public void setTematicaDTO(String tematicaDTO) {
		this.tematicaDTO = tematicaDTO;
	}
	
	
	
	
}
