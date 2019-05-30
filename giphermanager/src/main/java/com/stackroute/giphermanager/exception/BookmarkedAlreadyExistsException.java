package com.stackroute.giphermanager.exception;

public class BookmarkedAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;

	public BookmarkedAlreadyExistsException(String message) {
        super(message);
    }
}
