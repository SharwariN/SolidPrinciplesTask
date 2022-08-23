package com.ms;

import java.util.Properties;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return sf;
	}
}
