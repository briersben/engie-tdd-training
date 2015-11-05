package com.electrabel.training.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BookSet {
	private List<String> books = new ArrayList<String>();
	
	private static final float UNIT_PRICE = 8;
	
	private static final int DISCOUNT_SET_OF_1 = 0;
	private static final int DISCOUNT_SET_OF_2 = 5;
	private static final int DISCOUNT_SET_OF_3 = 10;
	private static final int DISCOUNT_SET_OF_4 = 20;
	private static final int DISCOUNT_SET_OF_5 = 25;

	public BookSet() {
	}

	public BookSet(BookSet bookSet) {
		this.books.addAll(bookSet.books);
	}
	
	public void add(String book) {
		books.add(book);
	}

	public void remove(String book) {
		books.remove(book);
	}

	public boolean contains(String book) {
		return books.contains(book);
	}
	
	public BigDecimal calculateDiscountedPrice() {
		return calculateDiscountedPrice(books.size());
	}

	public BigDecimal calculateDisountedPriceWithNewBook() {
		return calculateDiscountedPrice(books.size() + 1);
	}

	private BigDecimal calculateDiscountedPrice(int numberOfBooks) {
		BigDecimal totalPrice = BigDecimal.valueOf(numberOfBooks * UNIT_PRICE);
		return totalPrice.subtract(getDiscount(totalPrice));
	}

	private BigDecimal getDiscount(BigDecimal totalPrice) {
		int discountPercentage = getDiscountPercentage(books.size());
		return totalPrice.multiply(new BigDecimal(discountPercentage)).divide(new BigDecimal(100));
	}
	
	private int getDiscountPercentage(int numberOfBooksInSet) {
		int discount = 0;
		switch (numberOfBooksInSet) {
		case 5:
			discount = DISCOUNT_SET_OF_5;
			break;
		case 4:
			discount = DISCOUNT_SET_OF_4;
			break;
		case 3:
			discount = DISCOUNT_SET_OF_3;
			break;
		case 2:
			discount = DISCOUNT_SET_OF_2;
			break;
		default:
			break;
		}
		return discount;
	}

	private boolean isSetOf2BetterThanSetOf1() {
		return DISCOUNT_SET_OF_2 > DISCOUNT_SET_OF_1; 
	}
	
	private boolean isSetOf3BetterThanSetOf2() {
		return DISCOUNT_SET_OF_3 > DISCOUNT_SET_OF_2; 
	}

	private boolean isSetOf4BetterThanSetOf3() {
		return DISCOUNT_SET_OF_3 > DISCOUNT_SET_OF_2; 
	}

	private boolean isSetOf5BetterThanSetOf4() {
		return DISCOUNT_SET_OF_3 > DISCOUNT_SET_OF_2; 
	}
	
	// --- option 1 : check if 2 sets of x is better than 1 set of (x+1)
	private boolean is2SetsOf4BetterThanOneSetOf5() {
		return false;
	}
	
	// --- option 2 : check if move book to other smaller size set results in better outcome (discount)
	
	public void reallocateBooksInSetsToGetBetterDiscount(List<BookSet> otherBookSets) {
		for (BookSet otherBookSet : otherBookSets) {
			reallocateBooksInSetsToGetBetterDiscount(otherBookSet);
		}
	}

	private void reallocateBooksInSetsToGetBetterDiscount(BookSet otherBookSet) {
		if (otherBookSet == this)
			return;

		System.out.println("reallocateBooksInSetsToGetBetterDiscount : bookSet " + toString());
		System.out.println("reallocateBooksInSetsToGetBetterDiscount : otherBookSet " + otherBookSet.toString());
		
		BigDecimal currentDiscount = calculateDiscountedPrice();
		BigDecimal currentDiscountOtherBookSet = otherBookSet.calculateDiscountedPrice();

		BookSet newBookSet = new BookSet(this);
		Collections.reverse(newBookSet.books);
		BookSet newOtherBookSet = new BookSet(otherBookSet);
		
		// move book
		for (String book : newBookSet.books) {
			if (newOtherBookSet.contains(book))
				continue;
			System.out.println("[test] " + book + " added to newOtherBookSet ");
			System.out.println("[test] " + book + " removed from newBookSet ");
			newOtherBookSet.add(book);
			newBookSet.remove(book);
			BigDecimal discount = newBookSet.calculateDiscountedPrice();
			BigDecimal discountOtherBookSet = newOtherBookSet.calculateDiscountedPrice();
			
			if (discount.compareTo(currentDiscount) > 0) {
				otherBookSet.add(book);
				this.remove(book);
				break;
			}
			newOtherBookSet.remove(book);
			newBookSet.add(book);
		}
	}

//	private boolean isBetterInSet() {
//	// create clone of bookSets
//	
//}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String book : books)
			sb.append(book);
		return sb.toString();
	}
	
}
