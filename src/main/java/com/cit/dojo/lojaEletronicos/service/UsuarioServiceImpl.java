package com.cit.dojo.lojaEletronicos.service;

import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.LoginModel;
import com.cit.dojo.lojaEletronicos.entity.Usuario;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	
	@Override
	public Usuario efetuarLogin(LoginModel loginModel) {
		return new Usuario();
	}
	
	@Override
	public void salvarUsuario(Usuario usuario) {
	}
}
