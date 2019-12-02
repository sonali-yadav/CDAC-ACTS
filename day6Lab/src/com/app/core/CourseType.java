package com.app.core;

public enum CourseType {
	DAC, DMC, DBDAC, DAI;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
