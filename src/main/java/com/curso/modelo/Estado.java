package com.curso.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Estado extends BaseEntity {

  private static final long serialVersionUID = 1L;
  private String nome;
  @OneToMany(mappedBy = "estado")
  private Set<Cidade> cidades = new HashSet<>();
}
