package controller;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import model.User;
import model.UserSessionBean;

@RequestScoped
@Named("loginmb")
public class LoginMB {

    @EJB
    private UserSessionBean UserSessionBean;

    private String email;
    private String senha;

    public String realizarLogin() {
        User User = UserSessionBean.buscarUserPorEmail(email);
        if (User != null && User.getSenha().equals(senha)) {
            // Armazena o usuário logado na sessão
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UserLogado", User);

            // Redireciona para a página 'Users.xhtml' após o login
            return "Users?faces-redirect=true";
        } else {
            // Adiciona uma mensagem de erro
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos!", null));
            return null;
        }
    }

    // Getters and Setters for email and senha
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
