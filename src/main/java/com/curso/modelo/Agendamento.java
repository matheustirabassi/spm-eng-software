package com.curso.modelo;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Embeddable
@Entity
@NamedQuery(name = "Agendamento.buscarTodos", query = "select f from Agendamento f")
public class Agendamento extends BaseEntity {

  private static final long serialVersionUID = 1L;
  private Date dataHoraMarcada;
  private String observacao;
  @ManyToOne
  private Tutor tutor;



}
