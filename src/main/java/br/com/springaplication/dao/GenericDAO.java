package br.com.springaplication.dao;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T, Type extends Serializable> {

	private Class<T> persistentClass;

	protected Query<T> query;

	public GenericDAO(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
		this.query = OfyService.ofy().load().type(persistentClass);
	}

	public T save(T entity) {
		OfyService.ofy().save().entities(entity).now();
		return entity;
	}

	public void delete(Long id) {
		OfyService.ofy().delete().key(Key.create(persistentClass, id));
	}

	public T findById(Long id) {
		return OfyService.ofy().load().type(persistentClass).id(id).now();
	}

	public List<T> findAll() {
		return OfyService.ofy().load().type(persistentClass).list();
	}

}