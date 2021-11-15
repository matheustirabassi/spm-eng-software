package com.curso.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Federacao.class)
public abstract class Federacao_ {

	public static volatile SingularAttribute<Federacao, Long> codigo;
	public static volatile SingularAttribute<Federacao, String> telefone;
	public static volatile SingularAttribute<Federacao, String> sigla;
	public static volatile SingularAttribute<Federacao, String> nome;
	public static volatile SingularAttribute<Federacao, Long> cnpj;
	public static volatile ListAttribute<Federacao, Clube> clubes;
	public static volatile SingularAttribute<Federacao, String> presidente;

	public static final String CODIGO = "codigo";
	public static final String TELEFONE = "telefone";
	public static final String SIGLA = "sigla";
	public static final String NOME = "nome";
	public static final String CNPJ = "cnpj";
	public static final String CLUBES = "clubes";
	public static final String PRESIDENTE = "presidente";

}

