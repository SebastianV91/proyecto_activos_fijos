package com.web.activos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.activos.dto.Persona;
import com.web.activos.service.PersonaService;

@RestController
@RequestMapping("/api/persona/")
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	@PostMapping("/guardarPersona")
	public ResponseEntity<?> registrarPersona(@RequestBody Persona persona){
		try {
			return new ResponseEntity(personaService.insertPersona(persona), HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ResponseEntity("Error al insertar el registro en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
