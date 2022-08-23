package com.ms;

import java.util.Scanner;

import com.ms.dao.MovieDaoImpl;
import com.ms.model.Movie;

public class App {
	public static void main(String[] args) {

		System.out.println("1.Insert a Movie\n2.Delete a Movie\n3.Update a Movie\n4.Get a Movie ");

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int choice = sc.nextInt();

		Movie movie = new Movie();
		MovieDaoImpl daoImpl = new MovieDaoImpl();

		if (choice == 1) {

			System.out.println("Enter Movie Name");
			String movieName = sc.next();
			System.out.println("Enter Movie Language");
			String movieLanguage = sc1.nextLine();
			System.out.println("Enter Released in Year");
			int releasedIn = sc.nextInt();
			System.out.println("Enter Revenue in Dollars");
			int revenue = sc.nextInt();

			movie.setMovieName(movieName);
			movie.setLanguage(movieLanguage);
			movie.setReleasedIn(releasedIn);
			movie.setRevenueInDollars(revenue);

			daoImpl.addMovie(movie);
		} else if (choice == 2) {
			System.out.println("Enter movie id you want to delete");
			int movieId = sc.nextInt();

			daoImpl.deleteMovie(movieId);
		} else if (choice == 3) {
			System.out.println("Enter movie ID you want to update");
			int movied = sc.nextInt();

			daoImpl.updateMovie(movied);
		} else if (choice == 4) {
			System.out.println("Enter movie ID you want to get");
			int movied = sc.nextInt();
			System.out.println(daoImpl.getMovie(movied));
		}
	}
}
