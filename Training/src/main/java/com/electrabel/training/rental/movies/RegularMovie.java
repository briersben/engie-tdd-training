package com.electrabel.training.rental.movies;

import com.electrabel.training.rental.Movie;
import com.electrabel.training.rental.MovieType;

public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title, MovieType.REGULAR);
	}
}
