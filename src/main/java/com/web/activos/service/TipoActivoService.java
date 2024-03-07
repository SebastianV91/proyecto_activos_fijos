package com.web.activos.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.activos.dto.TipoActivo;
import com.web.activos.repository.TipoActivoRepository;

@Service
public class TipoActivoService extends TipoActivoRepository{
	
	public Map<String, Object> insertTipoActivo(TipoActivo tipoActivo){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(insertTipoActivoRepository(tipoActivo) == 1) {
			response.put("mensaje", "Tipo de activo registrado exitosamente");
		}
		
		return response;
		
	}
	
}
