package com.electrabel.training.rental;
public class Movie {
	
	private String title;
	private MovieType movieType;
	
	public Movie(String title, MovieType movieType) {
		this.title = title;
		this.movieType = movieType;
	}
	
	public String getTitle (){
		return title;
	}
	
	public MovieType getMovieType() {
		return movieType;
	}
	
	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}
	
	public boolean isRegular() {
		return getMovieType().isOfType(MovieType.REGULAR);
	}

	public boolean isNewRelease() {
		return getMovieType().isOfType(MovieType.NEW_RELEASE);
	}
	
	public boolean isChildren() {
		return getMovieType().isOfType(MovieType.CHILDRENS);
	}

	public int calculatePrice(int daysRented) {
		int thisAmount = 0;

		// TODO Refactor this method further using polyorphism and create Movie subclasses
		
		if (isRegular()) {
			thisAmount += 2;
			if (daysRented > 2)
				thisAmount += (daysRented - 2) * 1.5;
		} else if (isNewRelease()) {
			thisAmount += daysRented * 3;
		} else if (isChildren()) {
			thisAmount += 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
		}
		
		return thisAmount;
	}

}