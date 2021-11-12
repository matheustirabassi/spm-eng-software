package com.curso.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Federacao;
import com.curso.service.FederacaoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class CadastroFederacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Federacao federacao;
	
	
	@Inject
	private FederacaoService federacaoService;
	
	
	
	public void salvar() {
		try {
			this.federacaoService.salvar(federacao);
			MessageUtil.sucesso("Federacao salvo com sucesso!");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar(){
		this.limpar();		
	}
	
	public void limpar() {
		this.federacao = new Federacao();
	}

	public Federacao getFederacao() {
		return federacao;
	}

	public void setFederacao(Federacao federacao) {
		this.federacao = federacao;
	}

	
	
}
