package com.curso.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Login;
import com.curso.service.LoginService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;
@Named
@ViewScoped
public class CadastroLoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Login login;
	
	@Inject
	private LoginService loginService;
	
	
	public void save() {
		try {
			
			this.loginService.save(login);
			MessageUtil.sucesso("Login salvo com sucesso!");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		} catch (Exception ex) {
			MessageUtil.erro(ex.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar(){
		limpar();		
	}	

	public void limpar() {
		this.login = new Login();		
	}	

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

}
