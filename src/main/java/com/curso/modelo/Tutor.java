package com.curso.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.curso.modelo.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Embeddable
@NamedQueries({ @NamedQuery(name = "Tutor.buscarTodos", query = "select a from Tutor a"),
		@NamedQuery(name = "Tutor.buscarPorEmail", query = "select a from Tutor a where a.email = :email") })
public class Tutor {
	@Id
	private Long cpf;
	private String nome;
	@Column(unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private Date dataNascimento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataModificacao;

	@PrePersist
	@PreUpdate
	public void configuraDatasCriacaoAlteracao() {
		this.dataModificacao = new Date();

		if (this.dataCriacao == null) {
			this.dataCriacao = new Date();
		}
	}

}