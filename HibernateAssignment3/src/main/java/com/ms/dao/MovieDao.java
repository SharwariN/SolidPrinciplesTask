package com.ms.dao;

import java.util.List;

import com.ms.model.Director;
import com.ms.model.Movie;

public interface MovieDao {

	public List<Movie> getMovieDetails(String language);
	
	public List<Movie> getMoviesForDirector(int directorId);
	
	public void addMovie(Movie movie);
	
	public void updateRevenue(int movieId);
	
	public List<String> getDistinctLanguages();
	
	public List<Movie> getMovieAndDirectorName();
	
}
