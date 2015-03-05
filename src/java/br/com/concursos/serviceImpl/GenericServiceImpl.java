package br.com.concursos.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.xml.internal.bind.v2.model.core.ID;

import br.com.concursos.repository.GenericRepositoy;
import br.com.concursos.service.GenericService;

public class GenericServiceImpl<T> implements GenericService<T> {

	@Autowired
	GenericRepositoy<T> repositoy;

	@Override
	public <S extends T> S save(S entity) {

		return repositoy.save(entity);
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {

		return repositoy.save(entities);
	}

	@Override
	public T findOne(ID id) {

		return repositoy.findOne(id);
	}

	@Override
	public boolean exists(ID id) {

		return repositoy.exists(id);
	}

	@Override
	public Iterable<T> findAll() {

		return repositoy.findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {

		return repositoy.findAll(ids);
	}

	@Override
	public long count() {

		return repositoy.count();
	}

	@Override
	public void delete(ID id) {
		repositoy.delete(id);
	}

	@Override
	public void delete(T entity) {
		repositoy.delete(entity);

	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		repositoy.delete(entities);

	}

	@Override
	public void deleteAll() {
		repositoy.deleteAll();

	}

}
