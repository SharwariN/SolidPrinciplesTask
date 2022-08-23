package com.moviebooking;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import com.exceptions.InvalidSeatNumberException;
import com.exceptions.SeatsNotAvailableException;
import com.exceptions.UnknownShowException;
import com.model.Show;

public class ShowManagerImpl implements ShowManager {

	public static volatile List<Show> shows = populateShows();

	@Override
	public void populate(Show show) {
		shows.add(show);
	}

	@Override
	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws UnknownShowException, SeatsNotAvailableException, InvalidSeatNumberException {
		boolean nameFlag = false;
		boolean timeFlag = false;
		boolean seatsFlag = false;
		for (Show show : shows) {
			if (show.getShowName().equalsIgnoreCase(showName)) {			
				nameFlag = true;
				if (show.getShowTime().equals(show_time)) {
					timeFlag = true;
					if(show.getSeatsAvailable() >= noOfSeats) {
						show.setSeatsAvailable(show.getSeatsAvailable() - noOfSeats);
						seatsFlag = true;
						
						 System.out.println("\nYou have successfully booked '"+ show.getShowName() +"' show.");
						 System.out.println("Remaining seats:" + show.getSeatsAvailable());
					}		
				} 
				break;
			}
		}
		
		if (!nameFlag) {
			throw new UnknownShowException("The Movie Show " + showName + " is not available for booking.");
		} else if(!timeFlag) {
			throw new UnknownShowException("The Movie Show " + showName + " is not available at the time " + show_time);
		} else if(!seatsFlag) {
			throw new SeatsNotAvailableException(
					"All the seats are already booked. The Show is HouseFull, Sorry fot the incovinience");
		}
	}

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private static List<Show> populateShows() {
		return new LinkedList() {
		};
	}
}
