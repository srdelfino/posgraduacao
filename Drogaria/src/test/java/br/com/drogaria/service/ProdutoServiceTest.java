package br.com.drogaria.service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Produto;

public class ProdutoServiceTest {
	// Define o endereço do serviço
	private static final String REST_SERVICE_URL = "http://localhost:8080/Drogaria/rest/produto";

	// Cria um cliente
	private static final Client client = ClientBuilder.newClient().register(
			JacksonFeature.class);

	// Anotação para informar que é um caso de teste
	// Anotação para informar que o teste deverá ser ignorado
	@Test
	@Ignore
	public void salvar() {
		// Cria um objeto do tipo produto
		Produto produto = new Produto();

		// Preenche as informações do produto
		produto.setCodigoBarra("1234567890123");
		produto.setDataFabricacao(new Date());
		produto.setDescricao("DescricaoB");
		produto.setQuantidade(4);
		produto.setValor(30.57);

		// Invoca o serviço para salvar o objeto e captura o retorno
		Produto produtoSalvo = client
				.target(REST_SERVICE_URL)
				.request()
				.post(Entity.entity(produto, MediaType.APPLICATION_JSON),
						Produto.class);

		// Verifica se o retorno é diferente de nulo
		Assert.assertNotNull(produtoSalvo);
	}

	// Anotação para informar que é um caso de teste
	// Anotação para informar que o teste deverá ser ignorado
	@Test
	@Ignore
	public void listar() {
		// Cria uma lista genérica para receber o resultado da requisição
		GenericType<List<Produto>> produtoType = new GenericType<List<Produto>>() {
		};

		// Invoca o serviço e recebe o resultado da requisição
		List<Produto> produtos = client.target(REST_SERVICE_URL).request()
				.get(produtoType);

		// Verifica se o retorno é diferente de nulovcc
		Assert.assertNotNull(produtos);
	}

	// Anotação para informar que é um caso de teste
	// Anotação para informar que o teste deverá ser ignorado
	@Test
	@Ignore
	public void buscar() {
		// Define o código que será pesquisado
		Integer codigo = 170;

		// Invoca o serviço e captura o resultado da requisição
		Produto produto = client.target(REST_SERVICE_URL).path("/{codigo}")
				.resolveTemplate("codigo", codigo).request().get(Produto.class);

		// Verifica se o retorno é diferente de nulo
		Assert.assertNotNull(produto);
	}
}
