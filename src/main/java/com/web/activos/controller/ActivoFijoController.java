package com.web.activos.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.web.activos.dto.ActivoFijo;
import com.web.activos.dto.ConsultaActivoFijo;
import com.web.activos.service.ActivoFijoService;

@RestController
@RequestMapping("/api/activoFijo/")
public class ActivoFijoController {

	@Autowired
	ActivoFijoService activoFijoService;

	@PostMapping("/guardarActivoFijo")
	public ResponseEntity<?> registrarActivoFijo(@RequestBody ActivoFijo activoFijo) {
		try {
			return new ResponseEntity(activoFijoService.insertActivoFijo(activoFijo), HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ResponseEntity("Error al insertar el registro en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
	}																											
	
	@PostMapping("/actualizarActivoFijo")
	public ResponseEntity<?> actualizarActivoFijo(@RequestBody ActivoFijo activoFijo){
		try {
			return new ResponseEntity(activoFijoService.updateActivoFijo(activoFijo), HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity("Error al insertar el registro en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/consultaTipoActivoFijo")
	public ResponseEntity<?> listaTipoActivoFijo(@RequestBody ConsultaActivoFijo consultaActivoFijo){
		try {
			return new ResponseEntity(activoFijoService.selectTipoActivoFijo(consultaActivoFijo), HttpStatus.OK);
		}catch(SQLException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}catch(ResponseStatusException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}																					
	
	@PostMapping("/consultaSerialActivoFijo")
	public ResponseEntity<?> listaSerialActivoFijo(@RequestBody ConsultaActivoFijo consultaActivoFijo){
		try {
			return new ResponseEntity(activoFijoService.selectSerialActivoFijo(consultaActivoFijo), HttpStatus.OK);
		}catch(SQLException ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(ResponseStatusException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
			//return new ResponseEntity("Error al realizar la consulta en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/consultaFechaActivoFijo")
	public ResponseEntity<?> listaFechaActivoFijo(@RequestBody ConsultaActivoFijo consultaActivoFijo){
		try {
			return new ResponseEntity(activoFijoService.selectFechaActivoFijo(consultaActivoFijo), HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ResponseEntity("Error al realizar la consulta en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
