package br.com.drogaria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CategoriaDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Categoria;
import br.com.drogaria.domain.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	private Produto produto;
	private List<Produto> produtos;
	private List<Categoria> categorias;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
			produto = new Produto();

			// Cria um objeto para ter acesso as operações de banco de dados
			ProdutoDAO produtoDAO = new ProdutoDAO();

			// Recupera os registros do banco de dados e armazena o resultado em uma lista
			produtos = produtoDAO.listar();

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
			ProdutoDAO produtoDAO = new ProdutoDAO();

			// Invoca o método que efetua a inserção de um objeto
			produtoDAO.salvar(this.produto);

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
			if (produto.getCodigo() == null) {
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma produto");

				// Interrompe a execução do método
				return;
			}

			// Cria um objeto para ter acesso as operações de banco de dados
			ProdutoDAO produtoDAO = new ProdutoDAO();

			// Invoca o método que efetua a exclusão de um objeto
			produtoDAO.excluir(this.produto);

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
			if (produto.getCodigo() == null) {
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma produto");

				// Interrompe a execução do método
				return;
			}

			// Cria um objeto para ter acesso as operações de banco de dados
			ProdutoDAO produtoDAO = new ProdutoDAO();

			// Invoca o método que efetua a edição de um objeto
			produtoDAO.editar(this.produto);

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
