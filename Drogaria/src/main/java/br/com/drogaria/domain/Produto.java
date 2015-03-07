package br.com.drogaria.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// Anotação que define para não ficar solicitando a definição de um serial para a classe
// Anotação que define que a classe será uma entidade do Hibernate
// Anotação que define o nome da sequência que irá gerar a chave primária. 
@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name = "produtoSequence", sequenceName = "produtoSequence", allocationSize = 1)
public class Produto implements Serializable {
	// Anotação que define qual atributo será a chave primária
	// Anotação que define qual sequência irá gerar a chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoSequence")
	private Integer codigo;

	// Anotação para definir o tamanho de uma coluna
	@Column(length = 13)
	private String codigoBarra;

	// Anotação para definir o tamanho de uma coluna
	// Anotação para definir que um atributo não pode ser nulo
	@Column(length = 50)
	@Basic(optional = false)
	private String descricao;

	// Anotação para definir que um atributo não pode ser nulo
	@Basic(optional = false)
	private Integer quantidade;

	// Anotação para definir que um atributo não pode ser nulo
	@Basic(optional = false)
	private Double valor;

	// Anotação que define que o atributo será do tipo data
	// Anotação para definir que um atributo não pode ser nulo
	@Temporal(TemporalType.DATE)
	@Basic(optional = false)
	private Date dataFabricacao;

	// Anotação para definir que um atributo não pode ser nulo
	@Basic(optional = false)
	private Boolean ativo;

	// Anotação para que o relacionamento será do tipo Muitos-Para-Um
	// Anotação para definir a chave estrangeira não pode ser nula
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Categoria categoria;

	// Métodos leitores e acessores
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Anotação que define que um método será reescrito
	// Esse método serve para "imprimir" o conteúdo de um objeto
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", codigoBarra=" + codigoBarra
				+ ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", valor=" + valor + ", dataFabricacao=" + dataFabricacao
				+ ", ativo=" + ativo + ", categoria=" + categoria + "]";
	}
}
