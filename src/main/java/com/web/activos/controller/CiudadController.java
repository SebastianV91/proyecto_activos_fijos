package com.web.activos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.activos.dto.Ciudad;
import com.web.activos.service.CiudadService;

@RestController
@RequestMapping("/api/ciudad/")
public class CiudadController {

	@Autowired
	CiudadService ciudadService;

	@PostMapping("/guardarCiudad")
	public ResponseEntity<?> registrarCiudad(@RequestBody Ciudad ciudad){
		try {
			return new ResponseEntity(ciudadService.insertCiudad(ciudad), HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ResponseEntity("Error al insertar el registro en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
