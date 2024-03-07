package com.web.activos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.activos.dto.Area;
import com.web.activos.service.AreaService;

@RestController
@RequestMapping("/api/area/")
public class AreaController {
	
	@Autowired
	AreaService areaService;
	
	@PostMapping("/guardarArea")
	public ResponseEntity<?> registrarArea(@RequestBody Area area){
		try {
			return new ResponseEntity(areaService.insertArea(area), HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			return new ResponseEntity("Error al insertar el registro en la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
