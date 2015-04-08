package br.com.drogaria.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;

@Path("/produto")
public class ProdutoService {
	// Anotação que define que o tipo da requisição será GET
	// Anotação que define que o resultado produzido será no formato JSON
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		// Declara e instancia o DAO do produto
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Recupera todos os produtos da base de dados
		List<Produto> produtos = produtoDAO.listar();

		// Converte a lista de produtos em uma lista de entidades genéricas
		GenericEntity<List<Produto>> produtoWrapper = new GenericEntity<List<Produto>>(
				produtos) {
		};

		// Retorna o resultado para quem invocou o método
		return Response.ok(produtoWrapper).build();
	}

	// Anotação que define que o tipo da requisição será GET
	// Anotação que define o código do produto a ser pesquisado
	// Anotação que define que o resultado produzido será no formato JSON
	// Anotação que associa o parâmetro de uma URL com um parâmetro de um método
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		// Declara e instancia o DAO do produto
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Recupera um produto da base de dados com base em seu código
		Produto produto = produtoDAO.buscar(codigo);

		// Retorna o resultado para quem invocou o método
		return Response.ok(produto).build();
	}

	// Anotação que define que o tipo da requisição será POST
	// Anotação que define que o o parâmetro a ser recebido será no formato JSON
	// Anotação que define que o resultado produzido será no formato JSON
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Produto produto) {
		// Declara e instancia o DAO do produto
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Armazena o produto na base de dados
		produtoDAO.salvar(produto);

		// Retorna o resultado para quem invocou o método
		return Response.ok(produto).build();
	}

	// Anotação que define que o tipo da requisição será DELETE
	// Anotação que define o código do produto a ser removido
	// Anotação que define que o resultado produzido será no formato JSON
	// Anotação que associa o parâmetro de uma URL com um parâmetro de um método
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo) {
		// Declara e instancia o DAO do produto
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Recupera o produto da base de dados
		Produto produto = produtoDAO.buscar(codigo);

		// Remove o produto da base de dados
		produtoDAO.excluir(produto);

		// Retorna o resultado para quem invocou o método
		return Response.ok(produto).build();
	}

	// Anotação que define que o tipo da requisição será PUT
	// Anotação que define que o o parâmetro a ser recebido será no formato JSON
	// Anotação que define que o resultado produzido será no formato JSON
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Produto produto) {
		// Declara e instancia o DAO do produto
		ProdutoDAO produtoDAO = new ProdutoDAO();

		// Armazena o produto na base de dados
		produtoDAO.editar(produto);

		// Retorna o resultado para quem invocou o método
		return Response.ok(produto).build();
	}

}
