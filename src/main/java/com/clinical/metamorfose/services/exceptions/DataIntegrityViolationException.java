package com.clinical.metamorfose.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    private  static final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String mensage) {
        super(mensage);
    }
    public DataIntegrityViolationException(String mensage, Throwable cause) {
        super(mensage, cause);
    }
}
