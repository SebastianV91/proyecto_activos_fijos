package com.web.activos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.activos.dto.Area;



@Component
public class AreaRepository {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	public int insertAreaRepository(Area area) {
		
		String sql = "INSERT INTO BIENES_ACTIVOS.AREA "
				+ " (ID_ACTIVO_FIJO, ID_CIUDAD, NOMBRE_AREA) "
				+ "VALUES (?, ?, ?) ";
		
		int rows = jdbcTemplate.update(sql, area.getIdActivoFijo(), area.getIdCiudad(), area.getNombreArea());

		return rows;
		
	}
	
}
