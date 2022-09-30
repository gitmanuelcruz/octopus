package mx.com.octopus.app.models.user.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.octopus.app.models.user.entity.Privilegio;

public interface IPrivilegioDao extends CrudRepository<Privilegio, Long> {

}
