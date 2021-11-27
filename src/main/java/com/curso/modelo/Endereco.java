package com.curso.modelo;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
@EqualsAndHashCode(callSuper = true)
@Entity
public class Endereco extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	@ManyToOne
	private Tutor tutor;
	@OneToOne
	private Cidade cidade;
}
