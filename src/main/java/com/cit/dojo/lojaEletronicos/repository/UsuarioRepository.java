package com.cit.dojo.lojaEletronicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
 
	@Query("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
	Usuario getUser(@Param("login") String usuario, @Param("senha") String senha);
	
}
