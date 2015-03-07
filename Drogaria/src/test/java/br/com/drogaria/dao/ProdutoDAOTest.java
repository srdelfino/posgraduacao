package br.com.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Produto produto = new Produto();
		produto.setCodigoBarra("1234567890123");
		produto.setDataFabricacao(new Date());
		produto.setDescricao("DescricaoA");
		produto.setQuantidade(4);
		produto.setValor(30.57);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(produto);
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.listar();
	}
}
