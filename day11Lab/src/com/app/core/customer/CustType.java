package com.app.core.customer;

public enum CustType {
	SILVER, GOLD, PLATINUM;
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
