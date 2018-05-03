package com.cit.dojo.lojaEletronicos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.Usuario;
import com.cit.dojo.lojaEletronicos.service.UsuarioService;

@Component
public class UsuarioController implements Serializable {

	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = -266136348615516433L;


	@Autowired
	private transient UsuarioService usuarioService;

	private Usuario usuario = new Usuario();

	public String salvar() {

		try {
			usuarioService.salvarUsuario(usuario);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso Usuario", null));

			// return "sistema/home?faces-redirect=true";

			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Usuario", null));
			return "";
		}
	}

	public String cancelar() {
		return "home?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}