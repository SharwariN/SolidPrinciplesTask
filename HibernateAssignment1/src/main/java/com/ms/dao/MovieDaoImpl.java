package com.ms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ms.HibernateUtil;
import com.ms.model.Movie;

public class MovieDaoImpl implements MovieDao {

	public void addMovie(Movie movie) {

		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			session.persist(movie);
			session.getTransaction().commit();
			System.out.println("Movie record has been successfully inserted");
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteMovie(int movieId) {

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			Movie movie = session.load(Movie.class, movieId);
			session.delete(movie);
			session.getTransaction().commit();
			System.out.println("Record has been deleted successfully");
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateMovie(int movieId) {

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			Movie movie = session.load(Movie.class, movieId);
			movie.setRevenueInDollars(100000);
			session.merge(movie);
			session.getTransaction().commit();
			System.out.println("Record has been updated successfully");
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Movie getMovie(int movieId) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Movie movie = session.get(Movie.class, movieId);
		
        session.close();
        
        return movie;
	}
}
