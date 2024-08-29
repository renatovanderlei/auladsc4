package model;

import java.util.List;

import jakarta.ejb.Stateless;
import model.repositorios.UserRepositorio;

@Stateless
public class UserSessionBean {

    private UserRepositorio UserRepositorio = new UserRepositorio();

    public void criarUser(User User) {
        validarCadastro(User);
        UserRepositorio.adicionarUser(User);
    }

    public void atualizarUser(User User) { // chamar o validar também
        UserRepositorio.atualizarUser(User);
    }

    public void removerUser(String id) {
        UserRepositorio.removerUser(id);
    }

    public User buscarUserPorId(String id) {
        return UserRepositorio.buscarUserPorId(id);
    }

    public User buscarUserPorEmail(String email) {
        return UserRepositorio.buscarUserPorEmail(email);
    }

    public List<User> listarUsers() {
        return UserRepositorio.listarUsers();
    }

    private void validarCadastro(User User) {
        if (User.getNome() == null || User.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário não pode estar vazio.");
        }
    }
}

