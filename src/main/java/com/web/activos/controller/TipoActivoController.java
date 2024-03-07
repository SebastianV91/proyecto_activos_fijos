package com.web.activos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.activos.dto.TipoActivo;
import com.web.activos.service.TipoActivoService;

@RestController
@RequestMapping("/api/tipoActivo/")
public class TipoActivoController {
	
	@Autowired
	TipoActivoService tipoActivoService;

	@PostMapping("/guardarTipoActivo")
	public ResponseEntity<?> registrarActivoFijo(@RequestBody TipoActivo tipoActivo){
		return new ResponseEntity(tipoActivoService.insertTipoActivo(tipoActivo), HttpStatus.OK);
	}
	
}
