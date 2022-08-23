package com.ms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity
public class Hollywood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	private String language;
	private int releasedIn;
	private int revenueInDollars;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getReleasedIn() {
		return releasedIn;
	}
	public void setReleasedIn(int releasedIn) {
		this.releasedIn = releasedIn;
	}
	public int getRevenueInDollars() {
		return revenueInDollars;
	}
	public void setRevenueInDollars(int revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}
	
	
}
