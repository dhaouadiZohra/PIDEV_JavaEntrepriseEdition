package tn.esprit.pidevjee.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.pidevjee.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
