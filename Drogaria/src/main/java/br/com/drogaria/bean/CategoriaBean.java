package br.com.drogaria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CategoriaDAO;
import br.com.drogaria.domain.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	private Categoria categoria;
	private List<Categoria> categorias;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@PostConstruct
	public void iniciar() {
		try {
			// Cria um objeto para armazenar os dados da tela
			categoria = new Categoria();

			// Cria um objeto para ter acesso as operações de banco de dados
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			
			// Recupera os registros do banco de dados e armazena o resultado em uma lista
			categorias = categoriaDAO.listar();
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public void incluir() {
		try {
			// Cria um objeto para ter acesso as operações de banco de dados
			CategoriaDAO categoriaDAO = new CategoriaDAO();

			// Invoca o método que efetua a inserção de um objeto
			categoriaDAO.salvar(this.categoria);

			// Reinicializa os objetos de tela
			this.iniciar();

			// Exibe uma mensagem de sucesso
			Messages.addGlobalInfo("Inclusão Realizada com Sucesso");
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public void excluir() {
		try {
			if(categoria.getCodigo() == null){
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma categoria");
				
				// Interrompe a execução do método
				return;
			}
			
			// Cria um objeto para ter acesso as operações de banco de dados
			CategoriaDAO categoriaDAO = new CategoriaDAO();

			// Invoca o método que efetua a exclusão de um objeto
			categoriaDAO.excluir(this.categoria);

			// Reinicializa os objetos de tela
			this.iniciar();

			// Exibe uma mensagem de sucesso
			Messages.addGlobalInfo("Exclusão Realizada com Sucesso");
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public void editar() {
		try {
			if(categoria.getCodigo() == null){
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma categoria");
				
				// Interrompe a execução do método
				return;
			}
			
			// Cria um objeto para ter acesso as operações de banco de dados
			CategoriaDAO categoriaDAO = new CategoriaDAO();

			// Invoca o método que efetua a edição de um objeto
			categoriaDAO.editar(this.categoria);

			// Reinicializa os objetos de tela
			this.iniciar();

			// Exibe uma mensagem de sucesso
			Messages.addGlobalInfo("Edição Realizada com Sucesso");
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}
}
