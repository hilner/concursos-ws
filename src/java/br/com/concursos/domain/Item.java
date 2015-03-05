package br.com.concursos.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="ITEM", indexes={@Index(columnList="letra")})
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4078300632069652105L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private Long codigo;
	
	@Column(name="DESCRICAO", nullable=false)
	private String descricao;
	
	@Column(name="LETRA", nullable=false)
	private String letra;
	
	@Column(name="GABARITO", nullable=false)
	private Boolean gabarito;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="QUESTAO", nullable=false)
	private Questao questao;

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

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Boolean getGabarito() {
		return gabarito;
	}

	public void setGabarito(Boolean gabarito) {
		this.gabarito = gabarito;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codigo).append(descricao)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			return true;
		} else {
			Item other = (Item) obj;
			return new EqualsBuilder().append(codigo, other.codigo)
					.append(descricao, other.descricao).isEquals();
		}
	}
	
}
