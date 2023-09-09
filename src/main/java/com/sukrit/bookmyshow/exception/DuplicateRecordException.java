package com.sukrit.bookmyshow.exception;

public class DuplicateRecordException extends Exception{

  public final String message;

  public DuplicateRecordException(String message) {
    super(message);
    this.message = message;
  }
}
