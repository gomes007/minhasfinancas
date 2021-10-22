package com.curso.minhasfinancas.service;

import com.curso.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsurio(Usuario usuario);
	
	void valiarEmail(String email);
	

}
