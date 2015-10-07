package com.electrabel.training.rental.movies;

import com.electrabel.training.rental.Movie;
import com.electrabel.training.rental.MovieType;

public class ChildrensMovie extends Movie {

	public ChildrensMovie(String title) {
		super(title, MovieType.CHILDRENS);
	}
}
