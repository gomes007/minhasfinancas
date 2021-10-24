package com.curso.minhasfinancas.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.minhasfinancas.model.entity.Usuario;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		// cenario
		// Usuario usuario =
		// Usuario.builder().nome("usuario").email("usuario@email").build();
		entityManager.persist(criarUsuario());

		// acao/execucao
		boolean result = repository.existsByEmail("usuario@email.com");

		// verificacao
		Assertions.assertThat(result).isTrue();
	}

	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		// cenário

		// acao
		boolean result = repository.existsByEmail("usuario@email.com");

		// verificacao
		Assertions.assertThat(result).isFalse();
	}

	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		// cenário
		// Usuario usuario = criarUsuario();

		// acao
		Usuario usuarioSalvo = repository.save(criarUsuario());

		// verificacao
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
	}

	@Test
	public void deveBuscarUmUsuarioPorEmail() {
		// cenario

		entityManager.persist(criarUsuario());

		// verificacao
		Optional<Usuario> result = repository.findByEmail("usuario@email.com");

		Assertions.assertThat(result.isPresent()).isTrue();

	}

	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExisteNaBase() {

		// verificacao
		Optional<Usuario> result = repository.findByEmail("usuario@email.com");

		Assertions.assertThat(result.isPresent()).isFalse();

	}

	
	public static Usuario criarUsuario() {
		return Usuario.builder().nome("usuario").email("usuario@email.com").senha("senha").build();
	}

}
