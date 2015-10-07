package com.electrabel.training.rental;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.electrabel.training.rental.movies.ChildrensMovie;
import com.electrabel.training.rental.movies.NewRelease;
import com.electrabel.training.rental.movies.RegularMovie;

public class CustomerTest {

	@Test
	public void testProcessRental() {
    	Customer customer = new Customer("Ben");

		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new RegularMovie("The Boondock Saints"));
		movies.add(new NewRelease("The Maze Runner"));
		movies.add(new ChildrensMovie("Cars"));
		
		addRental(customer, movies.get(0), 1);
		addRental(customer, movies.get(1), 2);
		addRental(customer, movies.get(2), 3);
		
    	String result = customer.processRental();
    	
    	System.out.println(result);

    	//fail("Not yet implemented");
	}

	private void addRental(Customer customer, Movie movie, int numberOfDays) {
		customer.addRental(new Rental(movie, numberOfDays));
	}

}
