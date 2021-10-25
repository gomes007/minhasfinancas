package com.curso.minhasfinancas.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.minhasfinancas.exception.ErroAutenticacao;
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
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if (!usuario.isPresent()) {
			throw new ErroAutenticacao("usuario nao encontrado");
		}
		
		if (!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("senha invalida");
		}
		
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());		
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}
	}


	@Override
	public Optional<Usuario> obterPorId(Long id) {
		
		return repository.findById(id);
	}

}
