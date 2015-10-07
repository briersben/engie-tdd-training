package com.electrabel.training.rental;
public enum MovieType {
	REGULAR(0),
	NEW_RELEASE(1),
	CHILDRENS(2);
	
	private int priceCode;
	
	MovieType(int priceCode) {
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}
	
	public boolean isOfType(MovieType movieType) {
		return this == movieType;
	}
	
}
