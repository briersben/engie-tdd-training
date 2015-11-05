package com.electrabel.training.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
	private Map<String,Integer> bookList = new TreeMap<String,Integer>();

	public void add(String book, int quantity) {
		bookList.put(book, quantity);
	}

	public BigDecimal getTotalPrice() {
		// create book sets
		List<BookSet> bookSets = createBookSets();

		// 
		reallocateBooksInSetsToGetBetterDiscount(bookSets);

		// calculate total price
		return calculateDiscountedPrice(bookSets);
	}

	private List<BookSet> createBookSets() {
		List<BookSet> bookSets = new ArrayList<BookSet>();
		for (String book : bookList.keySet()) {
			int quantity = bookList.get(book);
			for (int i = 0; i < quantity; i++) {
				addBookToSet(bookSets, book);
			}
		}
		return bookSets;
	}

	private void addBookToSet(List<BookSet> bookSets, String book) {
		boolean bookAdded = false;
		for (BookSet bookSet : bookSets) {
			if (!bookSet.contains(book)) {
				bookSet.add(book);
				bookAdded = true;
				break;
			}
		}
		if (!bookAdded) {
			BookSet bookSet = new BookSet();
			bookSet.add(book);
			bookSets.add(bookSet);
		}
	}

	private void decideWhichSetIsTheBestOption(List<BookSet> bookSets, String book) {
		
	}
	
	private BigDecimal calculateDiscountedPrice(List<BookSet> bookSets) {
		BigDecimal price = BigDecimal.ZERO;
		for (BookSet bookSet : bookSets) {
			price = price.add(bookSet.calculateDiscountedPrice());
		}
		return price;
	}

	
	
	// --- option 2 : check if move book to other smaller size set results in better outcome (discount)
	
	private boolean reallocateBooksInSetsToGetBetterDiscount(List<BookSet> bookSets) {
		for (BookSet bookSet : bookSets) {
			bookSet.reallocateBooksInSetsToGetBetterDiscount(bookSets);
		}
		
		return false;
	}

	
	
}
