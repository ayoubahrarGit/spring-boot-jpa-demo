package com.ensat.demo.services;

import java.util.Optional;

public interface ICrudService<T> {
	
	public void save(T entity);
	public void delete(T entity);
	public Optional<T> find(int id);
	public Optional<T> find(String name);
	public Iterable<T> all();
}
