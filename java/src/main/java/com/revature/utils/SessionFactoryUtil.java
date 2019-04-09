package com.revature.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
	
	private static SessionFactory sf;
	static {
		Configuration configuration = new Configuration().configure();
		configuration.setProperty("hibernate.connection.url",
				"jdbc:postgresql://" + System.getenv("proj2_URL") + ":5432/postgres");
		configuration.setProperty("hibernate.connection.username", System.getenv("proj2_USERNAME"));
		configuration.setProperty("hibernate.connection.password", System.getenv("proj2_PASSWORD"));
		configuration.setProperty("hibernate.default_schema", System.getenv("proj2_SCHEMA"));

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}

}
