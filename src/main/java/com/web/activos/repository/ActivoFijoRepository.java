package com.web.activos.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.web.activos.dto.ActivoFijo;
import com.web.activos.dto.ConsultaActivoFijo;
import com.web.activos.mapper.ActivoFijoMapper;

@Component
public class ActivoFijoRepository {
	
	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	
	public int insertActivosFijosRepository(ActivoFijo activoFijo) {
		
		String sql = "INSERT INTO BIENES_ACTIVOS.ACTIVO_FIJO "
				+ " (NOMBRE, DESCRIPCION, SERIAL, NUM_INTERNO_INVENTARIO, PESO, ALTO, ANCHO, LARGO, VALOR_COMPRA, FECHA_COMPRA, ID_TIPO_ACTIVO) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		int rows = jdbcTemplate.update(sql, activoFijo.getNombre(), activoFijo.getDescripcion(), activoFijo.getSerial(), activoFijo.getNum_interno_inventario(), activoFijo.getPeso(), activoFijo.getAlto(), activoFijo.getAncho(), activoFijo.getLargo(), activoFijo.getValor_compra(), activoFijo.getFecha_compra(), activoFijo.getId_tipo_activo());

		return rows;
		
	}
	
	public int updateActivosFijosRepository(ActivoFijo activoFijo) {
		
		String sql = "UPDATE BIENES_ACTIVOS.ACTIVO_FIJO "
				+ " SET NOMBRE = ?, DESCRIPCION = ?, SERIAL = ?, NUM_INTERNO_INVENTARIO = ?, PESO = ?, ALTO = ?, ANCHO = ?, LARGO = ?, VALOR_COMPRA = ?, FECHA_COMPRA =  ?, ID_TIPO_ACTIVO = ?"
				+ "WHERE ID = ? ";
		
		int rows = jdbcTemplate.update(sql, activoFijo.getNombre(), activoFijo.getDescripcion(), activoFijo.getSerial(), activoFijo.getNum_interno_inventario(), activoFijo.getPeso(), activoFijo.getAlto(), activoFijo.getAncho(), activoFijo.getLargo(), activoFijo.getValor_compra(), activoFijo.getFecha_compra(), activoFijo.getId_tipo_activo(), activoFijo.getIdActivoFijo());

		return rows;
		
	}
	
	public Map<String, Object> selectTipoActivoFijoRepository(ConsultaActivoFijo consultaActivoFijo) throws ResponseStatusException,SQLException{
		
		Map<String, Object> respuesta = new HashMap<>();
		List<ActivoFijoMapper> listaTipoActivoFijo = new ArrayList<>();
	
		String sql = "SELECT A.NOMBRE AS TIPO_ACTIVO_FIJO, B.NOMBRE AS NOMBRE_ACTIVO_FIJO, B.DESCRIPCION, B.SERIAL, B.NUM_INTERNO_INVENTARIO, B.PESO, B.ALTO, B.ANCHO, B.LARGO, B.VALOR_COMPRA, B.FECHA_COMPRA "
				+ " FROM BIENES_ACTIVOS.TIPO_ACTIVO A INNER JOIN BIENES_ACTIVOS.ACTIVO_FIJO B ON A.ID = B.ID_TIPO_ACTIVO "
				+ " WHERE A.NOMBRE = ? ";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, consultaActivoFijo.getNombre());

		if(rows != null) {
			for(Map<String, Object> row: rows) {
				ActivoFijoMapper tipoActivoFijo = new ActivoFijoMapper();
				tipoActivoFijo.setTipoActivo((String) row.get("TIPO_ACTIVO_FIJO"));
				tipoActivoFijo.setNombre((String) row.get("NOMBRE_ACTIVO_FIJO"));
				tipoActivoFijo.setDescripcion((String) row.get("DESCRIPCION"));
				tipoActivoFijo.setSerial((String) row.get("SERIAL"));
				tipoActivoFijo.setNum_interno_inventario((String) row.get("NUM_INTERNO_INVENTARIO"));
				tipoActivoFijo.setPeso((Double) row.get("PESO"));
				tipoActivoFijo.setAlto((Double) row.get("ALTO"));
				tipoActivoFijo.setAncho((Double) row.get("ANCHO"));
				tipoActivoFijo.setLargo((Double) row.get("LARGO"));
				tipoActivoFijo.setValor_compra((Integer) row.get("VALOR_COMPRA"));
				tipoActivoFijo.setFecha_compra((Date) row.get("FECHA_COMPRA"));
				listaTipoActivoFijo.add(tipoActivoFijo);
			}
			
			if(rows.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}else {
				respuesta.put("ActivosFijos", listaTipoActivoFijo);
			}
			
		}																							
		
		return respuesta;
		
	}
	
	public Map<String, Object> selectSerialActivoFijoRepository(ConsultaActivoFijo consultaActivoFijo) throws ResponseStatusException,SQLException{
		
		Map<String, Object> respuesta = new HashMap<>();
		List<ActivoFijoMapper> listaTipoActivoFijo = new ArrayList<>();
	
		String sql = "SELECT A.NOMBRE AS TIPO_ACTIVO_FIJO, B.NOMBRE AS NOMBRE_ACTIVO_FIJO, B.DESCRIPCION, B.SERIAL, B.NUM_INTERNO_INVENTARIO, B.PESO, B.ALTO, B.ANCHO, B.LARGO, B.VALOR_COMPRA, B.FECHA_COMPRA "
				+ " FROM BIENES_ACTIVOS.TIPO_ACTIVO A INNER JOIN BIENES_ACTIVOS.ACTIVO_FIJO B ON A.ID = B.ID_TIPO_ACTIVO "
				+ " WHERE B.SERIAL = ? ";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, consultaActivoFijo.getSerial());

		if(rows != null) {
			for(Map<String, Object> row: rows) {
				ActivoFijoMapper serialActivoFijo = new ActivoFijoMapper();
				serialActivoFijo.setTipoActivo((String) row.get("TIPO_ACTIVO_FIJO"));
				serialActivoFijo.setNombre((String) row.get("NOMBRE_ACTIVO_FIJO"));
				serialActivoFijo.setDescripcion((String) row.get("DESCRIPCION"));
				serialActivoFijo.setSerial((String) row.get("SERIAL"));
				serialActivoFijo.setNum_interno_inventario((String) row.get("NUM_INTERNO_INVENTARIO"));
				serialActivoFijo.setPeso((Double) row.get("PESO"));
				serialActivoFijo.setAlto((Double) row.get("ALTO"));
				serialActivoFijo.setAncho((Double) row.get("ANCHO"));
				serialActivoFijo.setLargo((Double) row.get("LARGO"));
				serialActivoFijo.setValor_compra((Integer) row.get("VALOR_COMPRA"));
				serialActivoFijo.setFecha_compra((Date) row.get("FECHA_COMPRA"));
				listaTipoActivoFijo.add(serialActivoFijo);
			}
			
			if(rows.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}else {
				respuesta.put("ActivosFijos", listaTipoActivoFijo);
			}
			
		}																							
		
		return respuesta;
		
	}
	
	public Map<String, Object> selectFechaActivoFijoRepository(ConsultaActivoFijo consultaActivoFijo){
		
		Map<String, Object> respuesta = new HashMap<>();
		List<ActivoFijoMapper> listaTipoActivoFijo = new ArrayList<>();
	
		String sql = "SELECT A.NOMBRE AS TIPO_ACTIVO_FIJO, B.NOMBRE AS NOMBRE_ACTIVO_FIJO, B.DESCRIPCION, B.SERIAL, B.NUM_INTERNO_INVENTARIO, B.PESO, B.ALTO, B.ANCHO, B.LARGO, B.VALOR_COMPRA, B.FECHA_COMPRA "
				+ " FROM BIENES_ACTIVOS.TIPO_ACTIVO A INNER JOIN BIENES_ACTIVOS.ACTIVO_FIJO B ON A.ID = B.ID_TIPO_ACTIVO "
				+ " WHERE B.FECHA_COMPRA = TO_DATE(?, 'YYYY-MM-DD') ";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, consultaActivoFijo.getFecha_compra());

		if(rows != null) {
			for(Map<String, Object> row: rows) {
				ActivoFijoMapper serialActivoFijo = new ActivoFijoMapper();
				serialActivoFijo.setTipoActivo((String) row.get("TIPO_ACTIVO_FIJO"));
				serialActivoFijo.setNombre((String) row.get("NOMBRE_ACTIVO_FIJO"));
				serialActivoFijo.setDescripcion((String) row.get("DESCRIPCION"));
				serialActivoFijo.setSerial((String) row.get("SERIAL"));
				serialActivoFijo.setNum_interno_inventario((String) row.get("NUM_INTERNO_INVENTARIO"));
				serialActivoFijo.setPeso((Double) row.get("PESO"));
				serialActivoFijo.setAlto((Double) row.get("ALTO"));
				serialActivoFijo.setAncho((Double) row.get("ANCHO"));
				serialActivoFijo.setLargo((Double) row.get("LARGO"));
				serialActivoFijo.setValor_compra((Integer) row.get("VALOR_COMPRA"));
				serialActivoFijo.setFecha_compra((Date) row.get("FECHA_COMPRA"));
				listaTipoActivoFijo.add(serialActivoFijo);
			}
			
			if(rows.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}else {
				respuesta.put("ActivosFijos", listaTipoActivoFijo);
			}
			
		}																							
		
		return respuesta;
		
	}
	
	public boolean selectValidacionSerialRepository(ActivoFijo activoFijo) {
		
		String sql = "SELECT NOMBRE, DESCRIPCION, SERIAL, NUM_INTERNO_INVENTARIO, PESO, ALTO, ANCHO, LARGO, VALOR_COMPRA, FECHA_COMPRA "
				+ " FROM BIENES_ACTIVOS.ACTIVO_FIJO  "
				+ "WHERE SERIAL = ? ";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, activoFijo.getSerial());
		
		if(rows != null) {
			
			if(rows.isEmpty()) {
				return false;
			}else {
				return true;
			}
		
		}else {
			return true;
		}
		
	}
	
}
