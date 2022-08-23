package com.moviebooking;

import java.util.List;

import com.exceptions.InvalidSeatNumberException;
import com.exceptions.SeatsNotAvailableException;
import com.exceptions.UnknownShowException;
import com.model.Show;

public interface ShowManager {
	public void populate(Show show) ;

	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws UnknownShowException, SeatsNotAvailableException, InvalidSeatNumberException;

}
