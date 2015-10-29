package com.electrabel.training.potter.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
	private static final int UNIT_PRICE = 8;
	
	private Map<String,Integer> bookList = new HashMap<String,Integer>();
	
	public void add(String book, int quantity) {
		bookList.put(book, quantity);
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		
		// create sets
		List<List<String>> sets = createSets();
		
		// calculate total price
		for (List<String> set : sets) {
			int setPrice = calculatePrice(set);
			totalPrice+=setPrice;
		}
		
		return totalPrice;
	}

	private List<List<String>> createSets() {
		List<List<String>> sets = new ArrayList<List<String>>();
		
		for (String book : bookList.keySet()) {
			int quantity = bookList.get(book);
			for (int i = 0; i < quantity; i++) {
				addBookToSet(sets, book);
				
				List<String> set = new ArrayList<String>();
				set.add(book);
				sets.add(set);
			}
		}
		
		return sets;
	}

	private void addBookToSet(List<List<String>> sets, String book) {
	}

	private int calculatePrice(List<String> set) {
		int price = set.size() * UNIT_PRICE;
		return price;
	}

	
	
	
}
