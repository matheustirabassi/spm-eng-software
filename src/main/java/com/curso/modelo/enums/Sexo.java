package com.curso.modelo.enums;

public enum Sexo {

	FEMININO("feminino"),
	MASCULINO("masculino");
	
	private String descricao;
	
	Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
