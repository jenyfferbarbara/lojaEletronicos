package com.cit.dojo.lojaEletronicos.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cit.dojo.lojaEletronicos.entity.LoginModel;
import com.cit.dojo.lojaEletronicos.entity.Usuario;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	
	@Override
	public Usuario efetuarLogin(LoginModel loginModel) {
		Usuario usuario = new Usuario();
		usuario.setLogin("tst");
		return usuario;
	}
	
	@Override
	public void validarUsuarioLogado(String loginUsuarioLogado) throws Exception {
		if(StringUtils.isEmpty(loginUsuarioLogado)) {
			throw new BusinessException("Usuário não logado.");
		}
	}
	
	
	@Override
	public void salvarUsuario(Usuario usuario) {
	}
}
