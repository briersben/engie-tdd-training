package com.electrabel.training.rental;

import java.util.ArrayList;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	
	public Customer (String name){
		this.name = name;
	}
	
	public void addRental(Rental arg) {
		rentals.add(arg);
	}
	
	public String getName (){
		return name;
	}
	
//	public String originalStatement() {
//		double totalAmount = 0;
//		int frequentRenterPoints = 0;
//		Enumeration rentals = _rentals.elements();
//		String result = "Rental Record for " + getName() + "\n";
//		
//		while (rentals.hasMoreElements()) {
//			double thisAmount = 0;
//			Rental each = (Rental) rentals.nextElement();
//			
//			//determine amounts for each line
//			switch (each.getMovie().getPriceCode()) {
//			case Movie.REGULAR:
//				thisAmount += 2;
//				if (each.getDaysRented() > 2)
//				thisAmount += (each.getDaysRented() - 2) * 1.5;
//				break;
//			case Movie.NEW_RELEASE:
//				thisAmount += each.getDaysRented() * 3;
//				break;
//			case Movie.CHILDRENS:
//				thisAmount += 1.5;
//				if (each.getDaysRented() > 3)
//					thisAmount += (each.getDaysRented() - 3) * 1.5;
//				break;
//			}
//			
//			// add frequent renter points
//			frequentRenterPoints ++;
//			// add bonus for a two day new release rental
//			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) frequentRenterPoints ++;
//			//show figures for this rental
//			result += "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(thisAmount) + "\n";
//			totalAmount += thisAmount;
//		}
//		//add footer lines
//		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//		result += "You earned " + String.valueOf(frequentRenterPoints) +
//		" frequent renter points";
//		return result;
//	}

    public static void main(String[] args) throws Exception {
    	Customer customer = new Customer("Ben");
    	Movie movie = new Movie("The Boondock Saints", MovieType.REGULAR);
    	Rental rental = new Rental(movie, 1);
    	customer.addRental(rental);
    	
    	customer.processRental();
    }

	public String processRental() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		
		// process the rental records for customer
		for (Rental rental : rentals) {
			//determine amounts for each line
			double rentalAmount = calculateRentalAmount(rental);
			
			// add frequent renter points
			frequentRenterPoints++;
			
			// add bonus for a two day new release rental
			calcuateFrequentRenterPoints(rental, frequentRenterPoints);
			
			//show figures for this rental
			result.append("\t" + rental.getMovie().getTitle()+ "\t" + String.valueOf(rentalAmount) + "\n");
			totalAmount += rentalAmount;
		}
		
		//add footer lines
		result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
		result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
		return result.toString();
	}

	/**
	 * Refactoring extracted method
	 */
	public double calculateRentalAmount(Rental rental) {
		return rental.calculateRentalAmount();
	}

	/**
	 * Refactoring extracted method
	 */
	public void calcuateFrequentRenterPoints(Rental rental, int frequentRenterPoints) {
		if (rental.getMovie().isNewRelease() && rental.getDaysRented() > 1) 
			frequentRenterPoints ++;
	}
}
	