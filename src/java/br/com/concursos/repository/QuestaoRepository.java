package br.com.concursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.concursos.domain.Area;
import br.com.concursos.domain.Questao;

@Repository
public interface QuestaoRepository extends CrudRepository<Area, Long>{
	@Query("select o from questao as o "
			+ "where case when :area is not null then o.area = :area else true end "
			+ "case when :disciplina is not null then o.disciplina = :disciplina else true end"
			+ "order by rand()"
			+ "limit :maxQuestoes")
	List<Questao> consultar(@Param("area") Area area, @Param("disciplina")String disciplina, @Param("maxQuestoes") int maxQuestoes);
}
