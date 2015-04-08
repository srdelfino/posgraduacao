package br.com.drogaria.service;

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

import br.com.drogaria.domain.Categoria;

public class CategoriaServiceTest {
	private static final String REST_SERVICE_URL = "http://localhost:8080/Drogaria/rest/categoria";
	private static final Client client = ClientBuilder.newClient().register(
			JacksonFeature.class);

	@Test
	@Ignore
	public void salvar() {
		Categoria categoria = new Categoria();
		categoria.setDescricao("BIJOUTERIA");

		Categoria categoriaSalva = client
				.target(REST_SERVICE_URL)
				.request()
				.post(Entity.entity(categoria, MediaType.APPLICATION_JSON),
						Categoria.class);

		Assert.assertNotNull(categoriaSalva);
	}

	@Test
	@Ignore
	public void editar() {
		Categoria categoria = new Categoria();
		categoria.setCodigo(4);
		categoria.setDescricao("TESTE");

		Categoria categoriaEditada = client
				.target(REST_SERVICE_URL)
				.request()
				.put(Entity.entity(categoria, MediaType.APPLICATION_JSON),
						Categoria.class);

		Assert.assertNotNull(categoriaEditada);
	}

	@Test
	public void excluir() {
		Integer codigo = 4;

		GenericType<Categoria> categoriaType = new GenericType<Categoria>() {
		};

		Categoria categoriaExcluida = client.target(REST_SERVICE_URL)
				.path("/{codigo}").resolveTemplate("codigo", codigo).request()
				.delete(categoriaType);

		Assert.assertNotNull(categoriaExcluida);
	}

	@Test
	@Ignore
	public void listar() {
		GenericType<List<Categoria>> categoriaType = new GenericType<List<Categoria>>() {
		};

		List<Categoria> categorias = client.target(REST_SERVICE_URL).request()
				.get(categoriaType);

		Assert.assertNotNull(categorias);
	}

	@Test
	@Ignore
	public void buscar() {
		Integer codigo = 4;

		Categoria categoria = client.target(REST_SERVICE_URL).path("/{codigo}")
				.resolveTemplate("codigo", codigo).request()
				.get(Categoria.class);

		Assert.assertNotNull(categoria);
	}
}
