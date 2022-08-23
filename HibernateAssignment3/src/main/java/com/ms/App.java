package com.ms;

import java.util.Scanner;

import com.ms.dao.MovieDaoImpl;
import com.ms.model.Director;
import com.ms.model.Movie;

public class App 
{
    public static void main( String[] args )
    {
        //Insert movies in database
    	
//    	Director d1 = new Director();
//    	d1.setDirectorName("Chris Columbus");
//    	d1.setBornId(1958);
//    	
//    	Director d2 = new Director();
//    	d2.setDirectorName("Aamir Khan");
//    	d2.setBornId(1965);
//    	
//    	
//    	Director d3 = new Director();
//    	d3.setDirectorName("R.Balki");
//    	d3.setBornId(1967);
//    	
//    	
//    	Movie m1 = new Movie();
//    	m1.setMovieName("Home Alone");
//    	m1.setLanguage("English");
//    	m1.setReleasedIn(1990);
//    	m1.setRevenueInDollars(476700000);
//    	m1.setDirector(d1);
//    	
//    	Movie m2 = new Movie();
//    	m2.setMovieName("Taare Zameen Par");
//    	m2.setLanguage("Hindi");
//    	m2.setReleasedIn(2007);
//    	m2.setRevenueInDollars(13000000);
//    	m2.setDirector(d2);
//    	
//    	Movie m3 = new Movie();
//    	m3.setMovieName("Paa");
//    	m3.setLanguage("Hindi");
//    	m3.setReleasedIn(2009);
//    	m3.setRevenueInDollars(4700000);
//    	m3.setDirector(d3);
//
//    	
//    	MovieDaoImpl dao = new MovieDaoImpl();
//    	
//    	dao.addMovie(m1);
//    	dao.addMovie(m2);
//    	dao.addMovie(m3);
    	
// ---------------------------------------------------------------------------------------------------
    	
    	// Get movie details based on language
    	
//    	MovieDaoImpl dao = new MovieDaoImpl();
//    	System.out.println(dao.getMovieDetails("English"));
//    	System.out.println(dao.getMovieDetails("Hindi"));
    	
    	
 // --------------------------------------------------------------------------------------------------
    	
    	// Get Movie details based on director
    	
//    	MovieDaoImpl dao = new MovieDaoImpl();
//        System.out.println(dao.getMoviesForDirector(11));
        
 // ---------------------------------------------------------------------------------------------------
        
    	// Update movie revenue
    	
//    	MovieDaoImpl dao = new MovieDaoImpl();
//    	dao.updateRevenue(1);
    	
  // ---------------------------------------------------------------------------------------------------
    	
    	// get distinct languages
    	
//    	MovieDaoImpl dao = new MovieDaoImpl();
//    	System.out.println(dao.getDistinctLanguages());
    	
 // ------------------------------------------------------------------------------------------------------
    	
    	// Get movie name and director name
    	
//    	MovieDaoImpl dao = new MovieDaoImpl();
//        dao.getMovieAndDirectorName();
    }
}
