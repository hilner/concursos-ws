package br.com.concursos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.sun.xml.internal.bind.v2.model.core.ID;

@NoRepositoryBean
public interface GenericRepositoy<T> extends CrudRepository<T, ID>{

}
