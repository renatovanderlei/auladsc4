package model.repositorios;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserRepositorio {

    private List<User> Users = new ArrayList<>();
    private int idCounter = 1;

    public UserRepositorio() {
        // Usuário de teste
        User UserTeste = new User();
        UserTeste.setId(String.valueOf(idCounter++));
        UserTeste.setNome("teste1");
        UserTeste.setEmail("teste1@example.com");
        UserTeste.setSenha("teste1");
        Users.add(UserTeste);
    }

    public void adicionarUser(User User) {
        User.setId(String.valueOf(idCounter++));
        Users.add(User);
    }

    public void atualizarUser(User User) {
        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).getId().equals(User.getId())) {
                Users.set(i, User);
                return;
            }
        }
    }

    public void removerUser(String id) {
        Users.removeIf(u -> u.getId().equals(id));//pegar o booleano e tratar no service
    }

    public User buscarUserPorId(String id) {
        return Users.stream()
            .filter(User -> User.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public User buscarUserPorEmail(String email) {
        return Users.stream()
            .filter(User -> User.getEmail().equals(email))
            .findFirst()
            .orElse(null);
    }

    public List<User> listarUsers() {
        return new ArrayList<>(Users);
    }
}
