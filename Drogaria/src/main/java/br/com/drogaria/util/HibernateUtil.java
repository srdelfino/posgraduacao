package br.com.drogaria.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	// Declara um objeto para armazenar a fábrica de sessões
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Declara um objeto para ler as configurações do Hibernate 
			Configuration configuration = new Configuration();
			
			// Efetua a leitura das configurações do Hibernate
			configuration.configure("hibernate.cfg.xml");

			// Registra o serviço
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// Cria a fábrica de sessões
			SessionFactory sessionFactory = configuration
					.buildSessionFactory(serviceRegistry);
			
			// Retorna a fábrica de sessões
			return sessionFactory;
		} catch (Throwable throwable) {
			// Propaga a exceção
			throw new ExceptionInInitializerError(throwable);
		}
	}

	public static SessionFactory getSessionFactory() {
		// Retorna a fábrica de sessões criada
		return sessionFactory;
	}
}
