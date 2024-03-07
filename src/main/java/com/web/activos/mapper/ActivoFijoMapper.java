package com.web.activos.mapper;

import java.util.Date;

public class ActivoFijoMapper {

	private String tipoActivo;
	
	private String nombre;
	
	private String descripcion;
	
	private String serial;
	
	private String num_interno_inventario;
	
	private Double peso;
	
	private Double alto;
	
	private Double ancho;
	
	private Double largo;
	
	private Integer valor_compra;
	
	private Date fecha_compra;

	public String getTipoActivo() {
		return tipoActivo;
	}

	public void setTipoActivo(String tipoActivo) {
		this.tipoActivo = tipoActivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNum_interno_inventario() {
		return num_interno_inventario;
	}

	public void setNum_interno_inventario(String num_interno_inventario) {
		this.num_interno_inventario = num_interno_inventario;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAlto() {
		return alto;
	}

	public void setAlto(Double alto) {
		this.alto = alto;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Integer getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(Integer valor_compra) {
		this.valor_compra = valor_compra;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	
}
