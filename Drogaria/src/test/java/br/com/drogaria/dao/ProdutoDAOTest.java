package br.com.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Categoria;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		// Cria o objeto que permite chamar ações do banco de dados
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		// Pesquisa uma categoria e armazena o resultado em um objeto
		Categoria categoria = categoriaDAO.buscar(1);

		// Cria o objeto que irá receber os dados do produto
		Produto produto = new Produto();

		// Preenche os atributos do objeto
		produto.setCodigoBarra("1234567890123");
		produto.setDataFabricacao(new Date());
		produto.setDescricao("DescricaoA");
		produto.setQuantidade(4);
		produto.setValor(30.57);
		produto.setAtivo(true);

		// Preenche a chave estrangeira
		produto.setCategoria(categoria);

		// Cria o objeto que permite chamar ações do banco de dados
		ProdutoDAO dao = new ProdutoDAO();

		// Invoca a operação de salvar
		dao.salvar(produto);
	}

	@Test
	@Ignore
	public void listar() {
		// Cria o objeto que permite chamar ações do banco de dados
		ProdutoDAO dao = new ProdutoDAO();

		// Realiza a consulta e armazena o resultado em uma coleção
		List<Produto> produtos = dao.listar();

		// Imprime o resultado da consulta
		System.out.println(produtos);
	}

	@Test
	@Ignore
	public void buscar() {
		// Cria o objeto que permite chamar ações do banco de dados
		ProdutoDAO dao = new ProdutoDAO();

		// Realiza a consulta e armazena o resultado em um objeto
		Produto produto = dao.buscar(50);

		// Imprime o resultado da consulta
		System.out.println(produto);
	}

	@Test
	@Ignore
	public void editar() {
		// Cria o objeto que permite chamar ações do banco de dados
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		// Pesquisa uma categoria e armazena o resultado em um objeto
		Categoria categoria = categoriaDAO.buscar(1);

		// Cria o objeto que permite chamar ações do banco de dados
		ProdutoDAO dao = new ProdutoDAO();

		// Pesquisa por um determinado produto com base em seu código
		Produto produto = dao.buscar(2);

		// Altera os valores dos atributos que serão editados
		produto.setCodigoBarra("9876543210987");
		produto.setDataFabricacao(new Date());
		produto.setDescricao("DescricaoX");
		produto.setQuantidade(7);
		produto.setValor(123.45);
		produto.setAtivo(false);
		
		// Preenche a chave estrangeira
		produto.setCategoria(categoria);


		// Chama o método que edita o produto
		dao.editar(produto);
	}

	@Test
	@Ignore
	public void excluir() {
		// Cria o objeto que permite chamar ações do banco de dados
		ProdutoDAO dao = new ProdutoDAO();

		// Pesquisa por um determinado produto com base em seu código
		Produto produto = dao.buscar(50);

		// Chama o método que remove o produto
		dao.excluir(produto);
	}
}
