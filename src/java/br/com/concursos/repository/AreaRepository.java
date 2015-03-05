package br.com.concursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.concursos.domain.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long>{

	@Query("SELECT o.codigo, o.descricao, null FROM Area o")
	List<Area> listAll();
	
	
}
