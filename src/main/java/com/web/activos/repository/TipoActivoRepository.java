package com.web.activos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.web.activos.dto.TipoActivo;

public class TipoActivoRepository {
	
	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	
	public int insertTipoActivoRepository(TipoActivo tipoActivo) {
		
		String sql = "INSERT INTO BIENES_ACTIVOS.TIPO_ACTIVO "
				+ " (NOMBRE) "
				+ "VALUES (?) ";
		
		int rows = jdbcTemplate.update(sql, tipoActivo.getNombre());

		return rows;
		
	}
	
}
