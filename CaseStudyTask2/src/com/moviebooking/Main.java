package com.moviebooking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.model.Show;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		List<Show> list = ShowManagerImpl.shows;
		ShowManagerImpl showManagerImpl = new ShowManagerImpl();

		Scanner scanner = new Scanner(new File("C:\\Users\\GirishS4\\Downloads\\JavaTask2 Files\\show.txt"));

		while (scanner.hasNextLine()) {
		String st = scanner.nextLine();
		String[] split = st.split(",");
		String showName = split[0];
		String showTime = split[1];
		String seatsAvailable = split[2];

//		System.out.println(showName + " " + showTime + " " + seatsAvailable);
		showManagerImpl.populate(new Show(showName, showTime, Integer.parseInt(seatsAvailable)));
		}
		list = new ShowDisplay().displayAllShows();
		System.out.println("Available shows for Booking: \n");
		list.stream().sorted(Comparator.comparing(Show::getShowName)).forEach(x -> System.out.println(x));

		try {
			showManagerImpl.bookShow(list, "Sahi re Sahi", "03:30", 3);
			list = ShowManagerImpl.shows;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
