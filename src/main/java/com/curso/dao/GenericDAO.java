package com.curso.dao;

import java.util.List;

public interface GenericDAO<T> {
	T findById(Long id);

	List<T> findAll();

	T save(T t);

	T saveOrUpdate(T t);

	void saveOrUpdateAll(List<T> t);

	void delete(T t);

}
