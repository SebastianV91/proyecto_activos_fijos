package com.web.activos.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.activos.dto.Persona;
import com.web.activos.repository.PersonaRepository;

@Service
public class PersonaService extends PersonaRepository{

	public Map<String, Object> insertPersona(Persona persona){
		
		Map<String, Object> response = new HashMap<String, Object>();
	
		if(insertPersonaRepository(persona) == 1) {
			response.put("mensaje", "Persona registrada exitosamente");
		}
		
		return response;
		
	}
	
}
