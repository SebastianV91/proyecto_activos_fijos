package com.web.activos.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.web.activos.dto.ActivoFijo;
import com.web.activos.dto.ConsultaActivoFijo;
import com.web.activos.repository.ActivoFijoRepository;

@Service
public class ActivoFijoService extends ActivoFijoRepository{

	public Map<String, Object> insertActivoFijo(ActivoFijo activoFijo)  {
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(selectValidacionSerialRepository(activoFijo)) {
			response.put("mensaje", "Serial ya existente");
		}else if(insertActivosFijosRepository(activoFijo) == 1) {
			response.put("mensaje", "Activo fijo registrado exitosamente");			
		}else {
			response.put("mensaje", "El activo fijo no pudo ser registrado");
		}
		
		return response;
		
	}

	public Map<String, Object> updateActivoFijo(ActivoFijo activoFijo){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(updateActivosFijosRepository(activoFijo) == 1) {
			response.put("mensaje", "Activo fijo actualizado exitosamente");
		}else {
			response.put("mensaje", "El activo fijo no pudo ser modificado");
		}
		
		return response;
		
	}
	
	public Map<String, Object> selectTipoActivoFijo(ConsultaActivoFijo consultaActivoFijo) throws ResponseStatusException, SQLException{
		return selectTipoActivoFijoRepository(consultaActivoFijo);
	}
	
	public Map<String, Object> selectSerialActivoFijo(ConsultaActivoFijo consultaActivoFijo) throws ResponseStatusException, SQLException{
		return selectSerialActivoFijoRepository(consultaActivoFijo);
	}
	
	public Map<String, Object> selectFechaActivoFijo(ConsultaActivoFijo consultaActivoFijo){
		return selectFechaActivoFijoRepository(consultaActivoFijo);
	}
	
}
