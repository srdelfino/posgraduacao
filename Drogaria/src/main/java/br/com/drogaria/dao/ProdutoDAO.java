package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;

public class ProdutoDAO {
	public void salvar(Produto produto) {
		// Captura uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Declara o objeto que irá armazenar a transação
		Transaction transacao = null;

		try {
			// Inicia a transação
			transacao = sessao.beginTransaction();

			// Realiza a operação
			sessao.save(produto);

			// Confirma a operação
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			// Verifica se a transação foi iniciada
			if (transacao != null) {
				// Desfaz a operação
				transacao.rollback();
			}

			// Propaga a exceção
			throw runtimeException;
		} finally {
			// Finaliza a sessão
			sessao.close();
		}
	}

	public void editar(Produto produto) {
		// Captura uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Declara o objeto que irá armazenar a transação
		Transaction transacao = null;

		try {
			// Inicia a transação
			transacao = sessao.beginTransaction();

			// Realiza a operação
			sessao.update(produto);

			// Confirma a operação
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			// Verifica se a transação foi iniciada
			if (transacao != null) {
				// Desfaz a operação
				transacao.rollback();
			}

			// Propaga a exceção
			throw runtimeException;
		} finally {
			// Finaliza a sessão
			sessao.close();
		}
	}

	public void excluir(Produto produto) {
		// Captura uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Declara o objeto que irá armazenar a transação
		Transaction transacao = null;

		try {
			// Inicia a transação
			transacao = sessao.beginTransaction();

			// Realiza a operação
			sessao.delete(produto);

			// Confirma a operação
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			// Verifica se a transação foi iniciada
			if (transacao != null) {
				// Desfaz a operação
				transacao.rollback();
			}

			// Propaga a exceção
			throw runtimeException;
		} finally {
			// Finaliza a sessão
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		// Captura uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Declara uma coleção para armazenar o resultado da consulta
		List<Produto> produtos = null;

		try {
			// Cria uma consulta
			Criteria consulta = sessao.createCriteria(Produto.class);

			// Define a ordenação
			consulta.addOrder(Order.asc("descricao"));

			// Executa a consulta e armazena o resultado na coleção
			produtos = consulta.list();
		} catch (RuntimeException runtimeException) {
			// Propaga a exceção
			throw runtimeException;
		} finally {
			// Finaliza a sessão
			sessao.close();
		}

		// Retorna o resultado da consulta
		return produtos;
	}

	public Produto buscar(Integer codigo) {
		// Captura uma sessão
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// Declara um objeto para guardar o resultado da consulta
		Produto produto = null;

		try {
			// Cria uma consulta
			Criteria consulta = sessao.createCriteria(Produto.class);

			// Adiciona uma restrição na consulta para pesquisar pela chave
			// primária
			consulta.add(Restrictions.idEq(codigo));

			// Realiza a consulta e o resultado que é único é armazenado no
			// objeto
			produto = (Produto) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			// Propaga a exceção
			throw runtimeException;
		} finally {
			// Finaliza a sessão
			sessao.close();
		}

		// Retorna o resultado da consulta
		return produto;
	}
}
