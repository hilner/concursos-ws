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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="QUESTAO", indexes={@Index(columnList="prova")})
public class Questao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763132195908169290L;

	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private Long codigo;

	@Column(name="DESCRICAO", nullable=false)
	private String descricao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DISCIPLINA", nullable=false)
	private Disciplina disciplina;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="AREA", nullable=false)
	private Area area;
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="questao", cascade=CascadeType.ALL)
	private Set<Item> items;

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

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codigo).append(descricao)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Questao) {
			return true;
		} else {
			Questao other = (Questao) obj;
			return new EqualsBuilder().append(codigo, other.codigo)
					.append(descricao, other.descricao).isEquals();
		}
	}
	
}
