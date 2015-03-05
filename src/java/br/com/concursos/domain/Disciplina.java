package br.com.concursos.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.omg.CosNaming.IstringHelper;

@Entity
@Table(name="DISCIPLINA")
public class Disciplina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4463873515653172397L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private Long codigo;
	
	@Column(name="DESCRICAO", nullable=false, unique=true)
	private String descricao;
	
	@OneToMany(mappedBy="disciplina",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Questao> questoes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codigo).append(descricao).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Disciplina){
			return true;
		}else{
			Disciplina other = (Disciplina) obj;
			return new EqualsBuilder().append(codigo, other.codigo).append(descricao, other.codigo).isEquals();
		}
	}
	
	
}
