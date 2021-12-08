package com.curso.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
public class Endereco extends BaseEntity {

  private static final long serialVersionUID = 1L;
  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String cep;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "tutor_id")
  private Tutor tutor;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cidade_id")
  private Cidade cidade;
}
