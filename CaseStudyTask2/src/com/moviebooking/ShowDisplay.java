package com.moviebooking;

import java.util.List;

import com.model.Show;

@FunctionalInterface
interface ShowDetails {
	public List<Show> displayAllShows();
}

public class ShowDisplay implements ShowDetails{

	@Override
	public List<Show> displayAllShows() {
		return ShowManagerImpl.shows;
	}
	
}
