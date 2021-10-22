package com.curso.minhasfinancas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.minhasfinancas.exception.RegraNegocioException;
import com.curso.minhasfinancas.model.entity.Usuario;
import com.curso.minhasfinancas.model.repository.UsuarioRepository;
import com.curso.minhasfinancas.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	

	@Override
	public Usuario autenticar(String email, String senha) {
		return null;
	}

	@Override
	public Usuario salvarUsurio(Usuario usuario) {
		return null;
	}

	@Override
	public void valiarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}
	}

}
