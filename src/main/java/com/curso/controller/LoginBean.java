package com.curso.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import com.curso.modelo.Administrador;
import com.curso.service.AdministradorService;
import com.curso.util.MessageUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AdministradorService admService;
	@Column(unique=true)
	private String email;
	private String senha;
	private Administrador administrador;

	private Logger log = Logger.getLogger(LoginBean.class);

	public void inicializar() {
		log.info("Login bean inicializar...");
	}

	public Administrador isValidLogin() {
		System.out.println(admService.findByEmail(email));
		log.info("isValidLogin...");
		administrador = (Administrador) admService.findByEmail(email);
		
		if (administrador != null) {
			if (!senha.equals(administrador.getSenha())) {
				throw new RuntimeException("senha inválida");
			}
		}
		return administrador;

	}

	public String entrar() {
		Administrador adm = isValidLogin();
		log.info("Entrando...");
		if (adm != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			if ((Administrador) request.getSession().getAttribute("administrador") == null) {
				request.getSession().setAttribute("administrador", adm);
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

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

}
