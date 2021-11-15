package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class PesquisaAdministradorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Administrador> administradores = new ArrayList<Administrador>();
	private Administrador administradorSelecionado;
	
	@Inject
	AdministradorService admService;

		
	@PostConstruct
	public void inicializar() {
		administradores = admService.findAll();
	}
	
	public void delete() {
		try {
			admService.delete(administradorSelecionado);			
			this.administradores.remove(administradorSelecionado);
			MessageUtil.sucesso("Administrador " + administradorSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
	}
	
	
	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public Administrador getAdministradorSelecionado() {
		return administradorSelecionado;
	}

	public void setAdministradorSelecionado(Administrador administradorSelecionado) {
		this.administradorSelecionado = administradorSelecionado;
	}

	
}