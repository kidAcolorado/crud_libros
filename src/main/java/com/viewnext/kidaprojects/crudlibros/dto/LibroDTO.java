package com.viewnext.kidaprojects.crudlibros.dto;



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
