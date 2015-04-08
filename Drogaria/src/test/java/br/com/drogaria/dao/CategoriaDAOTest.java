package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Categoria;

public class CategoriaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		// Cria o objeto que irá receber os dados
		Categoria categoria = new Categoria();

		// Preenche os atributos do objeto
		categoria.setDescricao("DescricaoA");

		// Cria o objeto que permite chamar ações do banco de dados
		CategoriaDAO dao = new CategoriaDAO();

		// Invoca a operação de salvar
		dao.salvar(categoria);
	}

	@Test
	@Ignore
	public void listar() {
		// Cria o objeto que permite chamar ações do banco de dados
		CategoriaDAO dao = new CategoriaDAO();

		// Realiza a consulta e armazena o resultado em uma coleção
		List<Categoria> categorias = dao.listar();

		// Imprime o resultado da consulta
		System.out.println(categorias);
	}

	@Test
	@Ignore
	public void buscar() {
		// Cria o objeto que permite chamar ações do banco de dados
		CategoriaDAO dao = new CategoriaDAO();

		// Realiza a consulta e armazena o resultado em um objeto
		Categoria categoria = dao.buscar(1);

		// Imprime o resultado da consulta
		System.out.println(categoria);
	}

	@Test
	@Ignore
	public void editar() {
		// Cria o objeto que permite chamar ações do banco de dados
		CategoriaDAO dao = new CategoriaDAO();

		// Pesquisa por um determinada categoria com base em seu código
		Categoria categoria = dao.buscar(50);

		// Altera os valores dos atributos que serão editados
		categoria.setDescricao("DescricaoX");

		// Chama o método que edita a categoria
		dao.editar(categoria);
	}

	@Test
	@Ignore
	public void excluir() {
		// Cria o objeto que permite chamar ações do banco de dados
		CategoriaDAO dao = new CategoriaDAO();

		// Pesquisa por um determinada categoria com base em seu código
		Categoria categoria = dao.buscar(50);

		// Chama o método que remove a categoria
		dao.excluir(categoria);
	}
}
