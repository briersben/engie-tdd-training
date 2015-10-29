package com.electrabel.training.potter.v3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Potter 
 * Once upon a time there was a series of 5 books about a very English hero called Harry. (At least when this Kata was invented, there were only 5. Since then they have multiplied)
 * 
 * Children all over the world thought he was fantastic, and, of course, so did the publisher. So in a gesture of immense generosity to mankind, (and to increase sales) they set up 
 * the following pricing model to take advantage of Harry’s magical powers. 
 * 
 * One copy of any of the five books costs 8 EUR. 
 * If, however, you buy two different books from the series, you get a 5% discount on those two books. 
 * If you buy 3 different books, you get a 10% discount. 
 * With 4 different books, you get a 20% discount. 
 * If you go the whole hog, and buy all 5, you get a huge 25% discount.
 *  
 * Note that if you buy, say, four books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the fourth book still costs 8 EUR.
 * 
 * Potter mania is sweeping the country and parents of teenagers everywhere are queuing up with shopping baskets overflowing with Potter books. Your mission is to write a piece of code to calculate the price of any conceivable shopping basket, giving as big a discount as possible.
 *  
 * For example, how much does this basket of books cost? 
 * • 2 copies of the first book
 * • 2 copies of the second book 
 * • 2 copies of the third book
 * • 1 copy of the fourth book
 * • 1 copy of the fifth book 
 * > Answer: 51.20 EUR 
 */
public class PotterTest {

	private static final float DELTA = (float) 0.001;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void should_return_0_if_no_books() {
		Basket basket = new Basket();
		assertEquals(0, basket.getTotalPrice(), DELTA);
	}
	
	@Test
	public void should_return_normal_price_if_only_one_book() {
		Basket basket = new Basket();
		basket.add("Book1", 1);
		assertEquals(8, basket.getTotalPrice(), DELTA);
	}

	@Test
	public void should_return_normal_price_if_multiple_copies_of_same_book() {
		Basket basket = new Basket();
		basket.add("Book1", 2);
		assertEquals(16, basket.getTotalPrice(), DELTA);
	}

	
	
	@Test
	public void should_return_discounted_price() {
		BookSet bookSet = new BookSet();
		assertEquals(0, bookSet.calculateDiscountedPrice(), DELTA);
		bookSet.add("Book1");
		assertEquals(8, bookSet.calculateDiscountedPrice(), DELTA);
		bookSet.add("Book2");
		assertEquals(15.2, bookSet.calculateDiscountedPrice(), DELTA);
	}

	@Test
	public void should_return_discounted_price_for_3_sets() {
		Basket basket = new Basket();
		basket.add("Book1", 2);
		basket.add("Book2", 2);
		basket.add("Book3", 2);
		basket.add("Book4", 1);
		basket.add("Book5", 1);
		assertEquals(51.20, basket.getTotalPrice(), 0.1);
	}
	
}
