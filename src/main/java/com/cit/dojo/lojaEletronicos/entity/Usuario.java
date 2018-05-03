package com.cit.dojo.lojaEletronicos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
 
	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = -2107507136460226656L;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@NotNull
	@Size(max = 20)
	@Column(name="login", unique = true, nullable = false)
	private String login;
	
	@NotNull
	@Size(max = 20)
	@Column(name="senha", nullable = false)
	private String senha;

	@NotNull
	@Size(max = 1)
	@Column(name="administrador", nullable = false)
	private String administrador;
	
	@Size(max = 30)
	@Column(name="nome")
	private String nome;
 
	@Size(max = 30)
	@Column(name="endereco")
	private String endereco;
	
	@Size(max = 15)
	@Column(name="telefone")
	private String telefone;
	
	@Size(max = 30)
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Usuario() {
		this.administrador = "N";
	}
}
