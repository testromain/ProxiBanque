package org.proxi.spring.Dao;

import java.util.List;

public interface ProxiBanqueDao<E> {
	
	void persist(E e) throws Exception;
	
	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;
	
	E findById(Object id) throws Exception;
	
	List<E> findAll() throws Exception;
	
	List<E> findByProperty(String prop, Object val) throws Exception;
	
	List<E> findInRange(int firstResult, int maxResults) throws Exception;
	
}
