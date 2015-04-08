package br.com.drogaria.dao;

import java.util.Date;

import org.junit.Test;

import br.com.drogaria.domain.Categoria;
import br.com.drogaria.domain.Produto;

public class PopulaTest {
	@Test
	public void popular(){
		Categoria c1 = new Categoria();
		c1.setDescricao("MEDICAMENTO");
		
		Categoria c2 = new Categoria();
		c2.setDescricao("PERFUMARIA");
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		
		categoriaDAO.salvar(c1);
		categoriaDAO.salvar(c2);
		
		Produto p1 = new Produto();
		p1.setAtivo(true);
		p1.setCategoria(c1);
		p1.setCodigoBarra("1234567890123");
		p1.setDataFabricacao(new Date());
		p1.setDescricao("CATAFLAN POMADA COM 60GR");
		p1.setQuantidade(13);
		p1.setValor(7.27);
		
		Produto p2 = new Produto();
		p2.setAtivo(true);
		p2.setCategoria(c2);
		p2.setCodigoBarra("3210987654321");
		p2.setDataFabricacao(new Date());
		p2.setDescricao("REXONA AEROSOL COM 40 ML");
		p2.setQuantidade(5);
		p2.setValor(13.23);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(p1);
		produtoDAO.salvar(p2);
	}
}
