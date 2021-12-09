package com.curso.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.curso.modelo.Login;
import com.curso.service.LoginService;
import com.curso.util.MessageUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
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

  public void inicializar() {
    log.info("Login bean inicializar...");
  }

  public Login isValidLogin() {
    log.info(loginService.findByEmail(email));
    log.info("isValidLogin...");
    login = loginService.findByEmail(email);

    if (login != null && !senha.equals(login.getSenha())) {
      MessageUtil.erro("senha inválida");
      throw new RuntimeException("senha inválida");
    }

    return login;

  }

  public String entrar() {
    Login user = isValidLogin();
    log.info("Entrando...");
    if (user != null) {
      FacesContext context = FacesContext.getCurrentInstance();
      HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
      if ((Login) request.getSession().getAttribute("user") == null) {
        request.getSession().setAttribute("user", user);
        MessageUtil.erro("Você não está logado!");
        log.info("usuario não logado:" + user.getUsuario());
      } else {
        MessageUtil.alerta("Você já está logado");
      }
    }
    return "Home.xhtml";
  }

  public void sair() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession session = (request).getSession();
    session.invalidate();
    MessageUtil.alerta("saindo...");
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
