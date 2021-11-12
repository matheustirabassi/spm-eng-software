package com.curso.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Administrador;
import com.curso.service.AdministradorService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;
@Named
@ViewScoped
public class CadastroAdministradorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Administrador administrador;
	
	@Inject
	private AdministradorService administradorService;
	
	
	public void save() {
		try {
			
			this.administradorService.save(administrador);
			MessageUtil.sucesso("Administrador salvo com sucesso!");
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
		this.administrador = new Administrador();		
	}	

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	

}
