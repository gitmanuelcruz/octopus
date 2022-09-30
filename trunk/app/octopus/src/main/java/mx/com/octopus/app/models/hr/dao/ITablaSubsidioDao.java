package mx.com.octopus.app.models.hr.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.com.octopus.app.models.hr.entity.TablaSubsidio;

public interface ITablaSubsidioDao extends CrudRepository<TablaSubsidio, Long> {
	@Query(value="SELECT * "
			+ " FROM tabla_subsidio "
			+ " WHERE id_ejercicio_fiscal = :anio"
			+ " AND id_tipo_calculo = :tipocalculo"
			+ " AND :importe BETWEEN limite_inferior AND limite_superior",nativeQuery = true)
	public TablaSubsidio getTabuladorSubsidio(Long anio,Long tipocalculo, BigDecimal importe);
}
