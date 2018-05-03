package com.cit.dojo.lojaEletronicos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.Usuario;
import com.cit.dojo.lojaEletronicos.service.BusinessException;
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
			FacesContext facesContext = FacesContext.getCurrentInstance();
			usuarioService.validarUsuarioLogado((String) facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado"));

			usuarioService.salvarUsuario(usuario);
		} catch (BusinessException be) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, be.getMessage(), null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao cadastrar o Usuário.", null));
		}
		
		if(FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro Usuário efetuado com Sucesso.", null));
		}

		return "";
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