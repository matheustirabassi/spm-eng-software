package com.curso.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import com.curso.modelo.Login;
import com.curso.service.LoginService;
import com.curso.util.MessageUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	LoginService loginService;
	@Column(unique = true)
	private String email;
	private String senha;
	private Login login;

	private Logger log = Logger.getLogger(LoginBean.class);

	public void inicializar() {
		log.info("Login bean inicializar...");
	}

	public Login isValidLogin() {
		log.info(loginService.findByEmail(email));
		log.info("isValidLogin...");
		login = (Login) loginService.findByEmail(email);

		if (login != null) {
			if (!senha.equals(login.getSenha())) {
				throw new RuntimeException("senha inválida");
			}
		}
		return login;

	}

	public String entrar() {
		Login adm = isValidLogin();
		log.info("Entrando...");
		if (adm != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			if ((Login) request.getSession().getAttribute("login") == null) {
				request.getSession().setAttribute("login", adm);
				log.info("usuario não logado:" + adm.getNome());
			} else {
				MessageUtil.alerta("Você já está logado");
			}
		}
		return "Home.xhtml";
	}

	public void sair() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = ((HttpServletRequest) request).getSession();
		session.invalidate();
		log.info("saindo da conta...");

	}

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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
