package com.curso.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Login.class)
public abstract class Login_ extends com.curso.modelo.BaseEntity_ {

	public static volatile SingularAttribute<Login, String> senha;
	public static volatile SingularAttribute<Login, String> usuario;
	public static volatile SingularAttribute<Login, String> email;

	public static final String SENHA = "senha";
	public static final String USUARIO = "usuario";
	public static final String EMAIL = "email";

}

