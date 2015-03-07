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
	private static final String REST_SERVICE_URL = "http://localhost:8080/Drogaria/rest/produto";
	private static final Client client = ClientBuilder.newClient().register(
			JacksonFeature.class);

	@Test
	@Ignore
	public void salvar() {
		Produto produto = new Produto();
		produto.setCodigoBarra("1234567890123");
		produto.setDataFabricacao(new Date());
		produto.setDescricao("DescricaoB");
		produto.setQuantidade(4);
		produto.setValor(30.57);

		Produto produtoSalvo = client
				.target(REST_SERVICE_URL)
				.request()
				.post(Entity.entity(produto, MediaType.APPLICATION_JSON),
						Produto.class);
		
		Assert.assertNotNull(produtoSalvo);
	}

	@Test
	@Ignore
	public void listar() {
		GenericType<List<Produto>> produtoType = new GenericType<List<Produto>>() {
		};
		
		List<Produto> produtos = client.target(REST_SERVICE_URL).request()
				.get(produtoType);
		
		Assert.assertNotNull(produtos);
	}
	
	@Test
	public void buscar() {
		Integer codigo = 170;
		
		Produto produto = client.target(REST_SERVICE_URL).path("/{codigo}")
				.resolveTemplate("codigo", codigo).request().get(Produto.class);
		
		Assert.assertNotNull(produto);
	}
}
