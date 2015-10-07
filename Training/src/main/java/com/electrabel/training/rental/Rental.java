package com.electrabel.training.rental;
class Rental {
	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented() {
		return daysRented;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public double calculateRentalAmount() {
		return movie.calculatePrice(daysRented);
	}

}