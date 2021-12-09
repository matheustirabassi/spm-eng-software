package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.curso.modelo.Login;
import com.curso.service.LoginService;
import com.curso.util.MessageUtil;


@Named
@ViewScoped
public class PesquisaLoginBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<Login> logins = new ArrayList<>();
  private Login loginSelecionado;

  @Inject
  LoginService loginService;


  @PostConstruct
  public void inicializar() {
    logins = loginService.findAll();
  }

  public void delete() {
    loginService.delete(loginSelecionado);
    this.logins.remove(loginSelecionado);
    MessageUtil.sucesso("Login " + loginSelecionado.getUsuario() + " excluído com sucesso.");
  }


  public List<Login> getLogins() {
    return logins;
  }

  public Login getLoginSelecionado() {
    return loginSelecionado;
  }

  public void setLoginSelecionado(Login loginSelecionado) {
    this.loginSelecionado = loginSelecionado;
  }


}
