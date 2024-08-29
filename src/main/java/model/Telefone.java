package model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Telefone {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(length = 4)
	private String codPais;
	private Integer DDD;
	@Column(length = 10)
	private String telefone;

	public Telefone(String codPais, Integer dDD, String telefone) {
		this.codPais = codPais;
		DDD = dDD;
		this.telefone = telefone;
	}

	public Telefone() {

	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public Integer getDDD() {
		return DDD;
	}

	public void setDDD(Integer dDD) {
		DDD = dDD;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
