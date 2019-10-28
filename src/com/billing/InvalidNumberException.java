package com.billing;

public class InvalidNumberException extends Exception {
    InvalidNumberException(String number) {
        super(number);
    }
}  