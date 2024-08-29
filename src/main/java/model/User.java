package model;

public class User {
    private String id;      // Identificador único
    private String nome;    // Nome do usuário
    private String email;   // Email do usuário
    private String senha;   // Senha do usuário

    // Construtor padrão
    public User() {}

    // Construtor com parâmetros
    public User(String id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
