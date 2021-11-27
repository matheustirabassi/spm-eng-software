package com.curso.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
@Entity
@NamedQueries({ @NamedQuery(name = "Agendamento.buscarTodos", query = "select f from Agendamento f") })
public class Agendamento extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Date dataHoraMarcada;
	private String observacao;
	@ManyToOne
	private Tutor tutor;



}
