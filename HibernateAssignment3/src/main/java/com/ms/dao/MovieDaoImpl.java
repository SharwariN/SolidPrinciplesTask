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

	public List<Movie> getMovieDetails(String language) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
	    session.beginTransaction();
	    
	    Query query = session.createQuery("FROM Movie M WHERE M.language = :language");
	    query.setParameter("language", language);
	    List<Movie> movies = query.list();
	    
	    session.close();
	    
	    return movies;
	}

	public List<Movie> getMoviesForDirector(int directorId) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
	    session.beginTransaction();
	    
	    Query query = session.createQuery("FROM Movie M WHERE M.director.directorId = :directorId");
	    query.setParameter("directorId", directorId);
	    List<Movie> movies = query.list();
	    
	    session.close();
	    
	    return movies;
	}

	public void addMovie(Movie movie) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(movie);

		if (movie.getLanguage().equals("English")) {
			String hql = "INSERT INTO Hollywood (movieName, language, releasedIn, revenueInDollars) "
					+ "SELECT movieName, language, releasedIn, revenueInDollars FROM Movie";

			Query query = session.createQuery(hql);
			int result = query.executeUpdate();

		}

		session.getTransaction().commit();
		System.out.println("Movie has been added successfully");
		session.close();

	}

	public void updateRevenue(int movieId) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Movie m1 = session.load(Movie.class, 1);
		m1.setRevenueInDollars(100000);
		
		session.getTransaction().commit();
		
		session.close();
	}

	public List<String> getDistinctLanguages() {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
	    Query query = session.createQuery("SELECT DISTINCT M.language FROM Movie M");
	    
	    List<String> languages = query.list();
	    
	    session.close();
	    
		return languages;
	}

	public List<Movie> getMovieAndDirectorName() {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("FROM Movie");
		
		List<Movie> movies = query.getResultList();
		
		for(Movie m : movies) {
			System.out.println("Movie: " + m.getMovieName() + ", Director: " + m.getDirector().getDirectorName());
		}
		session.close();
		
 		return movies;
	}

}
