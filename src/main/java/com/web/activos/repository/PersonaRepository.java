package com.web.activos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.activos.dto.Persona;



@Component
public class PersonaRepository {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	public int insertPersonaRepository(Persona persona) {
		
		String sql = "INSERT INTO BIENES_ACTIVOS.PERSONA "
				+ " (ID_ACTIVO_FIJO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, EDAD) "
				+ "VALUES (?, ?, ?, ?, ?, ?) ";
		
		int rows = jdbcTemplate.update(sql, persona.getIdActivoFijo(), persona.getPrimer_nombre(), persona.getSegundo_nombre(), persona.getPrimer_apellido(), persona.getSegundo_apellido(), persona.getEdad());

		return rows;
		
	}
	
}
