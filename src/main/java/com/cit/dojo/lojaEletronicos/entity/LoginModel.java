package com.cit.dojo.lojaEletronicos.entity;

import java.io.Serializable;

public class LoginModel implements Serializable {

	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = 2595483378022211778L;

	private String login;
	
	private String senha;

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
}
