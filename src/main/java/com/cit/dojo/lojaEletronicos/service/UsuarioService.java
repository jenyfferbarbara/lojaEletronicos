package com.cit.dojo.lojaEletronicos.service;

import com.cit.dojo.lojaEletronicos.entity.LoginModel;
import com.cit.dojo.lojaEletronicos.entity.Usuario;

public interface UsuarioService {
	
	public Usuario efetuarLogin(LoginModel loginModel);

	void salvarUsuario(Usuario usuario);
	
}
