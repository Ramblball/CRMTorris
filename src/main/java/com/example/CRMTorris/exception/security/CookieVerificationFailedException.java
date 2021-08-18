package com.example.CRMTorris.exception.security;

public class CookieVerificationFailedException extends RuntimeException {
    public CookieVerificationFailedException(String message) {
        super(message);
    }
}
