package br.com.concursos.service;

import java.util.List;

import br.com.concursos.domain.Area;


public interface AreaService {

	void salvar(Area area);

	List<Area> listAll();

	Area find(Long codigo);
	
	
}
