package model;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import model.repositorios.UsuarioRepositorio;

@Stateless
public class UsuarioBean {

	@EJB
	private UsuarioRepositorio repositorio;
	
	public void adicionar(Usuario u) {
		
		this.repositorio.saveUsario(u);
	}

	public List<Usuario> listaUsuarios() {
		return this.repositorio.findAll();
	}
}
