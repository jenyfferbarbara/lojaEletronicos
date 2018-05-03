package com.cit.dojo.lojaEletronicos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="produto")
public class Produto implements Serializable {
 
	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = -4895561648863060376L;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@NotNull
	@Size(max = 10)
	@Column(name="codigo", unique = true, nullable = false)
	private String codigo;
	
	@Size(max = 50)
	@Column(name="descricao")
	private String descricao;

	@NotNull
    @Digits(integer = 5, fraction = 2)
	@Column(name="valor", nullable = false)
	private BigDecimal valor;
	
	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
