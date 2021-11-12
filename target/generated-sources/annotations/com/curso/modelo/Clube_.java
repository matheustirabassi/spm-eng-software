package com.curso.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Clube.class)
public abstract class Clube_ {

	public static volatile SingularAttribute<Clube, Long> codigo;
	public static volatile SingularAttribute<Clube, String> sigla;
	public static volatile SingularAttribute<Clube, Federacao> federacao;
	public static volatile SingularAttribute<Clube, String> nome;
	public static volatile ListAttribute<Clube, Atleta> atletas;

	public static final String CODIGO = "codigo";
	public static final String SIGLA = "sigla";
	public static final String FEDERACAO = "federacao";
	public static final String NOME = "nome";
	public static final String ATLETAS = "atletas";

}

