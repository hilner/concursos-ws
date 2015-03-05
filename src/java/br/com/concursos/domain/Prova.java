package br.com.concursos.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="PROVA", indexes={@Index(columnList="area")})
public class Prova implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7422321522591879701L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private Long codigo;

	@Column(name="DESCRICAO", nullable=false)
	private String descricao;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="AREA", referencedColumnName="codigo", nullable=false)
	private Area area;

	@OneToMany(mappedBy="prova", cascade=CascadeType.ALL)
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Set<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codigo).append(descricao)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Prova) {
			return true;
		} else {
			Prova other = (Prova) obj;
			return new EqualsBuilder().append(codigo, other.codigo)
					.append(descricao, other.descricao).isEquals();
		}
	}

}
