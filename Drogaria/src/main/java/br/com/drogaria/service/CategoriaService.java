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

import br.com.drogaria.dao.CategoriaDAO;
import br.com.drogaria.domain.Categoria;

@Path("/categoria")
public class CategoriaService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		List<Categoria> categorias = categoriaDAO.listar();

		GenericEntity<List<Categoria>> categoriaWrapper = new GenericEntity<List<Categoria>>(
				categorias) {
		};

		return Response.ok(categoriaWrapper).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		Categoria categoria = categoriaDAO.buscar(codigo);

		return Response.ok(categoria).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Categoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		categoriaDAO.salvar(categoria);

		return Response.ok(categoria).build();
	}

	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		Categoria categoria = categoriaDAO.buscar(codigo);

		categoriaDAO.excluir(categoria);

		return Response.ok(categoria).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Categoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();

		categoriaDAO.editar(categoria);

		return Response.ok(categoria).build();
	}

}
