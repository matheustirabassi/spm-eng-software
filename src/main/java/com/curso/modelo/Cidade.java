package com.curso.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Cidade extends BaseEntity {

  private static final long serialVersionUID = 1L;
  private String nome;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "estado_id")
  private Estado estado;
}
