package com.web.activos.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.activos.dto.Area;
import com.web.activos.repository.AreaRepository;

@Service
public class AreaService extends AreaRepository{

	public Map<String, Object> insertArea(Area area){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(insertAreaRepository(area) == 1) {
			response.put("mensaje", "Area registrada exitosamente");
		}
		
		return response;
		
	}

}
