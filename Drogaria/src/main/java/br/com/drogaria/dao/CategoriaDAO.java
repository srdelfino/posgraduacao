package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.drogaria.domain.Categoria;
import br.com.drogaria.util.HibernateUtil;

public class CategoriaDAO {
	public Categoria salvar(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(categoria);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return categoria;
	}
	
	public Categoria editar(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(categoria);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return categoria;
	}
	
	public Categoria excluir(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(categoria);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return categoria;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> categorias = null;

		try {
			Criteria consulta = sessao.createCriteria(Categoria.class);
			consulta.addOrder(Order.asc("descricao"));
			
			categorias = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return categorias;
	}
	
	public Categoria buscar(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Categoria categoria = null;

		try {
			Criteria consulta = sessao.createCriteria(Categoria.class);
			consulta.add(Restrictions.idEq(codigo));
			
			categoria = (Categoria) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return categoria;
	}
}
