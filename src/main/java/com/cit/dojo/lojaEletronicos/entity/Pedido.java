package com.cit.dojo.lojaEletronicos.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
 
	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = 1193940118809978622L;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@NotNull
	@Size(max = 10)
	@Column(name="codigo", unique = true, nullable = false)
	private String codigo;
	
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente", nullable = false)
    private Usuario cliente;
	
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto", nullable = false)
    private Produto produto;

	@NotNull
    @Digits(integer = 5, fraction = 2)
	@Column(name="valor", nullable = false)
	private BigDecimal valor;
	
	@NotNull
	@Size(max = 10)
	@Column(name="status", nullable = false)
	private String status;

	@Transient
	private Long qtdProduto;
	
	public Pedido() {
		this.produto = new Produto();
		this.cliente = new Usuario();
		this.status = "PENDENTE";
	}
	
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

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Long qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
}
