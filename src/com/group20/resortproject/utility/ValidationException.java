package com.group20.resortproject.utility;

/**
 * A generic exception to be honest. Just has a different name
 */
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}