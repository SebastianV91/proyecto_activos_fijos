package com.web.activos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.activos.dto.Ciudad;



@Component
public class CiudadRepository {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	
	public int insertCiudadRepository(Ciudad ciudad) {
		
		String sql = "INSERT INTO BIENES_ACTIVOS.CIUDAD "
				+ " (NOMBRE) "
				+ "VALUES (?) ";
		
		int rows = jdbcTemplate.update(sql, ciudad.getNombre());

		return rows;
		
	}
	
}
