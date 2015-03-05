import org.springframework.beans.factory.annotation.Autowired;

import br.com.concursos.domain.Area;
import br.com.concursos.repository.AreaRepository;

public class Cliente {
	@Autowired
	static AreaRepository repository;
	
	public static void save(Area area){
		Cliente.repository.save(area);
	}
	
	public static void main(String[] args) {
		
		Area area = new Area();
		
		area.setDescricao("Ciêcias Humanas");
		
		Cliente.save(area);
		
		
	}
	
	
}
