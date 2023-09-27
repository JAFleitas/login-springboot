package com.crisalis.backoffice.exception.custom;

public class NotCreatedException extends RuntimeException{
    private static final String DESCRIPTION = "Empty element (400). ";

    public NotCreatedException(String detail) {
        super(DESCRIPTION.concat(detail));
    }
}
