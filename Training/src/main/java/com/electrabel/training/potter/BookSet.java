package com.electrabel.training.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class BookSet {
    private static final Logger LOG = Logger.getLogger(BookSet.class);

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
	
	public BigDecimal getDiscountedPrice() {
		return getTotalPrice().subtract(getDiscount());
	}

	private BigDecimal getTotalPrice() {
		return BigDecimal.valueOf(books.size() * UNIT_PRICE);
	}
	
	private BigDecimal getDiscount() {
		return getDiscount(books.size());
	}

	private BigDecimal getDiscount(int numberOfBooks) {
		BigDecimal totalPrice = BigDecimal.valueOf(numberOfBooks * UNIT_PRICE);
		int discountPercentage = getDiscountPercentage(numberOfBooks);
		return totalPrice.multiply(new BigDecimal(discountPercentage)).divide(new BigDecimal(100));
	}

	private BigDecimal getDiscountWithAdditionalBook() {
		return BigDecimal.ZERO;
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

	public void reallocateBooksInSetsToGetBetterDiscount(List<BookSet> otherBookSets) {
		for (BookSet otherBookSet : otherBookSets) {
			reallocateBooksInSetsToGetBetterDiscount_OPTION_1(otherBookSet);
		}
	}


	// --- OPTION 1 : check if 2 sets of x is better than 1 set of (x+1) and 1 set of (x-1)
	
	private void reallocateBooksInSetsToGetBetterDiscount_OPTION_1(BookSet otherBookSet) {
		if (otherBookSet == this || otherBookSet.books.size() >= this.books.size())
			return;
		
		switch (books.size()) {
		case 5:
			if (otherBookSet.books.size() == 3 && isTwoSetsOf4BetterThanOneSetOf5AndOneSetOf3()) {
				String lastBook = books.get(books.size() - 1);
				otherBookSet.add(lastBook);
				remove(lastBook);
			}
		case 4:
			if (otherBookSet.books.size() == 2 && isTwoSetsOf3BetterThanOneSetOf4AndOneSetOf2()) {
				String lastBook = books.get(books.size() - 1);
				otherBookSet.add(lastBook);
				remove(lastBook);
			}
		case 3:
			if (otherBookSet.books.size() == 1 && isTwoSetsOf2BetterThanOneSetOf3AndOneSetOf1()) {
				String lastBook = books.get(books.size() - 1);
				otherBookSet.add(lastBook);
				remove(lastBook);
			}
		default:
		}
	}

	private boolean isTwoSetsOf4BetterThanOneSetOf5AndOneSetOf3() {
		return isTwoSetsOfBetterThanSetsOf(4, 5, 3);
	}

	private boolean isTwoSetsOf3BetterThanOneSetOf4AndOneSetOf2() {
		return isTwoSetsOfBetterThanSetsOf(3, 4, 2);
	}

	private boolean isTwoSetsOf2BetterThanOneSetOf3AndOneSetOf1() {
		return isTwoSetsOfBetterThanSetsOf(2, 3, 1);
	}

	private boolean isTwoSetsOfBetterThanSetsOf(int twoSetsOf, int oneSetOf, int anotherSetOf) {
		BigDecimal discount = getDiscount(oneSetOf).add(getDiscount(anotherSetOf));
		BigDecimal discountTwoSetsOf = getDiscount(twoSetsOf).multiply(new BigDecimal(2));
		return discountTwoSetsOf.compareTo(discount) > 0;
	}


	// --- OPTION 2 : check if move book to other smaller size set results in better outcome (discount)
	
	private void reallocateBooksInSetsToGetBetterDiscount_OPTION_2(BookSet otherBookSet) {
		if (otherBookSet == this || otherBookSet.books.size() >= this.books.size())
			return;
		
		LOG.debug("[bookSet] " + toString() + " - [otherBookSet] " + otherBookSet.toString());
		
		BigDecimal currentDiscount = getDiscount().add(otherBookSet.getDiscount());
		
		BookSet newBookSet = new BookSet(this);
		Collections.reverse(newBookSet.books);
		BookSet newOtherBookSet = new BookSet(otherBookSet);
		
		// move book
		for (String book : newBookSet.books) {
			if (!newOtherBookSet.contains(book)) {
				LOG.debug("[test] " + book + " removed from bookSet and added to otherBookSet ");
				newOtherBookSet.add(book);
				newBookSet.remove(book);
				BigDecimal discount = newBookSet.getDiscount().add(newOtherBookSet.getDiscount());
				
				if (discount.compareTo(currentDiscount) > 0) {
					otherBookSet.add(book);
					remove(book);
				}
				break;
			}
		}

		LOG.debug("[bookSet] " + toString() + " - [otherBookSet] " + otherBookSet.toString());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String book : books)
			sb.append(book);
		return sb.toString();
	}
	
}
