package model.repositorios;

import java.util.List;

import javax.management.Query;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Usuario;

@Singleton
public class UsuarioRepositorio {

	@PersistenceContext(name = "auladsc")
    private EntityManager em;
	
	public void saveUsario(Usuario u) {
		this.em.persist(u);
		this.em.flush();
	}

	public List<Usuario> findAll() {
		Query q = em.createQuery("from Usuario u", Usuario.class);
        
		return q.getResultList();
	}
}
