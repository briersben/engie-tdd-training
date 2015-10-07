package com.electrabel.training.rental.movies;

import com.electrabel.training.rental.Movie;
import com.electrabel.training.rental.MovieType;

public class NewRelease extends Movie {

	public NewRelease(String title) {
		super(title, MovieType.NEW_RELEASE);
	}
}
