package controller;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import model.User;
import model.UserSessionBean;

@Named("UserMB")
@RequestScoped
public class UserMB {

    @EJB
    private UserSessionBean UserSessionBean;

    private User User;
    private String id;
    private User UserSelecionado = new User();

    public UserMB() {
        this.User = new User();
    }

    public String criarUser() {
        try {
            UserSessionBean.criarUser(User);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário criado com sucesso!", null));
            return "home?faces-redirect=true";
        } catch (IllegalArgumentException e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;
        }
    }

    public String carregarUserParaEdicao() {
        this.UserSelecionado = UserSessionBean.buscarUserPorId(id);
        if (this.UserSelecionado == null) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao carregar usuário para edição.", null));
            return null;
        }
        return "Users?faces-redirect=true";
    }

    public String atualizarUser() {
        try {
            UserSessionBean.atualizarUser(UserSelecionado);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário atualizado com sucesso!", null));
            return "home?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar o usuário.", null));
            return null;
        }
    }

    public void removerUser() {
        UserSessionBean.removerUser(id);
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário removido com sucesso!", null));
    }

    public List<User> listarUsers() {
        return UserSessionBean.listarUsers();
    }

    // Getters e Setters
    public User getUser() { return User; }
    public void setUser(User User) { this.User = User; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public User getUserSelecionado() { return UserSelecionado; }
    public void setUserSelecionado(User UserSelecionado) { this.UserSelecionado = UserSelecionado; }
}