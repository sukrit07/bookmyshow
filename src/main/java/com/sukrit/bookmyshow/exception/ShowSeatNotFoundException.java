package com.sukrit.bookmyshow.exception;

public class ShowSeatNotFoundException extends Exception {
    public ShowSeatNotFoundException(Long showSeatId) {
        super("Show Seat with id " + showSeatId + " isn't AVAILABLE");
    }
}
