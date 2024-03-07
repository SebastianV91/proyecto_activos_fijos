package com.web.activos.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.activos.dto.Ciudad;
import com.web.activos.repository.CiudadRepository;

@Service
public class CiudadService extends CiudadRepository{
	
	public Map<String, Object> insertCiudad(Ciudad ciudad){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(insertCiudadRepository(ciudad) == 1) {
			response.put("mensaje", "Ciudad registrada exitosamente");
		}
		
		return response;
		
	}
	
}
