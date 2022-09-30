package mx.com.octopus.app.models.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAT_LANGUAGES")
public class Idioma implements Serializable {

	@Id
	@Column(name = "LANGUAGE_ID")
	private String idiomaId;

	@Column(name = "LANGUAGE_NAME")
	private String idiomaNombre;

	public String getIdiomaId() {
		return idiomaId;
	}

	public void setIdiomaId(String idiomaId) {
		this.idiomaId = idiomaId;
	}

	public String getIdiomaNombre() {
		return idiomaNombre;
	}

	public void setIdiomaNombre(String idiomaNombre) {
		this.idiomaNombre = idiomaNombre;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
