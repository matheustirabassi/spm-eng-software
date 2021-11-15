package com.curso.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Login.class)
public abstract class Login_ {

	public static volatile SingularAttribute<Login, Date> dataModificacao;
	public static volatile SingularAttribute<Login, String> senha;
	public static volatile SingularAttribute<Login, String> nome;
	public static volatile SingularAttribute<Login, Integer> id;
	public static volatile SingularAttribute<Login, Date> dataCriacao;
	public static volatile SingularAttribute<Login, String> email;

	public static final String DATA_MODIFICACAO = "dataModificacao";
	public static final String SENHA = "senha";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String DATA_CRIACAO = "dataCriacao";
	public static final String EMAIL = "email";

}

