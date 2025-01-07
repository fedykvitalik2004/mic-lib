package org.vitalii.fedyk.domain.exception;

public class OperationNotPermittedException extends RuntimeException{
    public OperationNotPermittedException(String message) {
        super(message);
    }
}