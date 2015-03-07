package br.com.drogaria.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;

public class HibernateUtilTest {
	// Anotação que informa que o método será um caso de teste
	// Anotação que informa que o método será ignorado durante os testes
	@Test
	@Ignore
	public void conectar(){
		// Captura a fábrica de sessão
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		
		// Apartir da fábrica de sessão captura uma sessão aberta
		Session sessao = fabrica.openSession();
		
		// Fecha a sessão
		sessao.close();
		
		// Fecha a fábrica de sessão
		fabrica.close();
	}
}
