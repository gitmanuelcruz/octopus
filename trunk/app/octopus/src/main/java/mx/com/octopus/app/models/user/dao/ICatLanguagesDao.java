package mx.com.octopus.app.models.user.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.octopus.app.models.user.entity.Idioma;

public interface ICatLanguagesDao extends CrudRepository<Idioma, Long> {

}
