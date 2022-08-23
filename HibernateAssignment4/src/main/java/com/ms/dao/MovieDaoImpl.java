package com.ms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ms.model.Movie;
import com.ms.util.HibernateUtil;

public class MovieDaoImpl implements MovieDao {

	public int highestRevenueGenerated(String language) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT MAX(M.revenueInDollars) from Movie M where M.language = :language", Integer.class);
		query.setParameter("language", language);
		Integer result = (Integer) query.getSingleResult();
		
		session.close();
		return result;
	}

	public int lowestRevenueGenerated(String language) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT MIN(M.revenueInDollars) from Movie M where M.language = :language", Integer.class);
		query.setParameter("language", language);
		Integer result = (Integer) query.getSingleResult();
		
		session.close();
		return result;
	}

	public long sumofRevenues(String language) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT SUM(M.revenueInDollars) from Movie M where M.language = :language", Long.class);
		query.setParameter("language", language);
		Long result = (Long) query.getSingleResult();
		
		session.close();
		return result;
	}

	public double avaerageOfRevenue(String language) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT AVG(M.revenueInDollars) from Movie M where M.language = :language", Double.class);
		query.setParameter("language", language);
		Double result = (Double) query.getSingleResult();
		
		session.close();
		return result;
	}

	public long numberOfMovies(String language) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("SELECT COUNT(*) from Movie M where M.language = :language", Long.class);
		query.setParameter("language", language);
		Long result = (Long) query.getSingleResult();
		
		session.close();
		return result;
	}

	

}
