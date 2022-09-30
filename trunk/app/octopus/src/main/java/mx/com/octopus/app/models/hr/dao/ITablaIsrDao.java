package mx.com.octopus.app.models.hr.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.com.octopus.app.models.hr.entity.TablaIsr;

public interface ITablaIsrDao extends CrudRepository<TablaIsr, Long> {

	@Query(value="SELECT * "
			+ " FROM tabla_isr "
			+ " WHERE id_ejercicio_fiscal = :anio"
			+ " AND id_tipo_calculo = :tipocalculo"
			+ " AND :importe BETWEEN limite_inferior AND limite_superior",nativeQuery = true)
	public TablaIsr getTabuladorISR(Long anio,Long tipocalculo, BigDecimal importe);
	
	@Query(value="SELECT *"
			+ "             FROM tabla_isr "
			+ "             WHERE id_ejercicio_fiscal = :anio"
			+ "             AND id_tipo_calculo = :idTipoCalculo "
			+ "             ORDER BY limite_inferior",nativeQuery = true)
	public List<TablaIsr> getTablaIsr(Long anio, Long idTipoCalculo);

}
