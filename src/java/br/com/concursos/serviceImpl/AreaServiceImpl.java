package br.com.concursos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concursos.domain.Area;
import br.com.concursos.repository.AreaRepository;
import br.com.concursos.service.AreaService;

@Service("areaServiceImpl")
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository repository;
	
	@Override
	public void salvar(Area area) {
		repository.save(area);
		
	}

	@Override
	public List<Area> listAll() {
		return (List<Area>) repository.listAll();
	}

	@Override
	public Area find(Long codigo) {
		return repository.findOne(codigo);
	}
	
	

}
