package org.dipesh.jersey.rest.simple_restapi.dao;

import java.util.List;

public interface GenericDao<T> {
	
	List<T> getAll();
	T findById(int id);
	T create(T t);
	boolean update();
	boolean delete(int id);
}
