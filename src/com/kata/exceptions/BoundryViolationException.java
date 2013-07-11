package com.kata.exceptions;

public class BoundryViolationException extends Exception {
	public BoundryViolationException() {
		super("Boundry has been violated");
	}
}
