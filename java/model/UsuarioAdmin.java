package model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( value="UA" )
public class UsuarioAdmin extends Usuario {

	private String matricula;

	public UsuarioAdmin() {
		
	}
	
	public UsuarioAdmin(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
}
