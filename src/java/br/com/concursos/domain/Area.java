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
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity 
@Table(name="AREA", indexes={@Index(columnList="codigo")})
public class Area implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7084464882626529541L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private Long codigo;

	@Column(name="DESCRICAO", nullable=false)
	private String descricao;
	
	@OneToMany(mappedBy="area",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Questao> questoes;

	@JsonIgnore
	public Set<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}

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
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codigo).append(descricao)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Area) {
			return true;
		} else {
			Area other = (Area) obj;
			return new EqualsBuilder().append(codigo, other.codigo)
					.append(descricao, other.descricao).isEquals();
		}
	}
	
}
