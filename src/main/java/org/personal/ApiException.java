package org.personal;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
