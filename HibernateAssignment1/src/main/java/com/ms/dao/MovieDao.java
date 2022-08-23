package com.ms.dao;

import com.ms.model.Movie;

public interface MovieDao {

	public void addMovie(Movie movie);
	
	public void deleteMovie(int movieId);
	
	public void updateMovie(int movieId);
	
	public Movie getMovie(int movieId);
}
