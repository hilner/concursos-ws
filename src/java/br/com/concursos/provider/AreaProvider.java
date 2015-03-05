package br.com.concursos.provider;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.concursos.domain.Area;
import br.com.concursos.service.AreaService;

@Path("/area")
public class AreaProvider {

	
	private AreaService areaService;
	
	
	@SuppressWarnings("resource")
	public AreaProvider(){
		ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");

		areaService = (AreaService) context .getBean("areaServiceImpl");
	}
	
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Area> listAll(){
		return areaService.listAll();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String inserir(Area area){
		String retorno;
		try{
			areaService.salvar(area);
			retorno ="salvo!";
		}catch(Exception e){
			retorno = e.getMessage();
		}
		return retorno;
		
	}
	
	@GET
	@Path("{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Area getArea(@PathParam("codigo") Integer codigo){
		return areaService.find(Long.valueOf(codigo));
	}
	
}
