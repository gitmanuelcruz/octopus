package mx.com.octopus.app.models.user.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.octopus.app.models.user.entity.Departamento;

public interface IDepartamentoDao extends CrudRepository<Departamento,Long> {

}
