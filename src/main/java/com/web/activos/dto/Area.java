package com.web.activos.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer idActivoFijo;
	
	private Integer IdCiudad;
	
	private String nombreArea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIdActivoFijo() {
		return idActivoFijo;
	}

	public void setIdActivoFijo(Integer idActivoFijo) {
		this.idActivoFijo = idActivoFijo;
	}

	public Integer getIdCiudad() {
		return IdCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		IdCiudad = idCiudad;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	
}
