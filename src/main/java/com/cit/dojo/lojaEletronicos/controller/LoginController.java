package com.cit.dojo.lojaEletronicos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.LoginModel;
import com.cit.dojo.lojaEletronicos.entity.Usuario;
import com.cit.dojo.lojaEletronicos.service.UsuarioService;

@Component
public class LoginController implements Serializable {

	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = -1358150352110497404L;

	@Autowired
	private transient UsuarioService usuarioService;

	private LoginModel loginModel = new LoginModel();

	public String efetuarLogin() {

		Usuario usuario = usuarioService.efetuarLogin(loginModel);

		if (usuario != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuario.getLogin());

			return "sistema/home?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível efetuar o Login.", null));
			return "";
		}
	}
	
	public String efetuarLogout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", null);
		return "/index?faces-redirect=true";
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
}