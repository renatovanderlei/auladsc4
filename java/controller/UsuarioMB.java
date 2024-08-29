package controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import model.Telefone;
import model.Usuario;
import model.UsuarioAdmin;
import model.UsuarioBean;

@RequestScoped
@Named
public class UsuarioMB {
	
	private String nome;
	private int idade;
	private String cpf;
	private String matricula;
	private String codPais1;
	private int DDD1;
	private String telefone1;
	private String codPais2;
	private int DDD2;
	private String telefone2;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	@EJB
	private UsuarioBean uBean;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getCodPais1() {
		return codPais1;
	}
	public void setCodPais1(String codPais1) {
		this.codPais1 = codPais1;
	}
	public int getDDD1() {
		return DDD1;
	}
	public void setDDD1(int dDD1) {
		DDD1 = dDD1;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getCodPais2() {
		return codPais2;
	}
	public void setCodPais2(String codPais2) {
		this.codPais2 = codPais2;
	}
	public int getDDD2() {
		return DDD2;
	}
	public void setDDD2(int dDD2) {
		DDD2 = dDD2;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String salvarUsuario() {
		Usuario u = new Usuario(nome, idade, cpf);
		u.getTelefones().add(new Telefone(this.codPais1, this.DDD1, this.telefone1));
		u.getTelefones().add(new Telefone(this.codPais2, this.DDD2, this.telefone2));
		
		this.uBean.adicionar(u);
		
		this.usuarios = this.uBean.listaUsuarios();
		//this.usuarios.add(u);
		return "usuario.xhtml";
	}
	
	public String salvarUsuarioAdmin() {
		Usuario u = new UsuarioAdmin();
		u.setNome(nome);
		u.setCpf(cpf);
		u.setIdade(idade);
		((UsuarioAdmin)u).setMatricula("teste"); 
		this.uBean.adicionar(u);
		
		this.usuarios = this.uBean.listaUsuarios();
		//this.usuarios.add(u);
		return "usuario.xhtml";
	}
	
	
}
