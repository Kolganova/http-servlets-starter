package com.kolganova.http.validator;

public interface Validator <T> {
    ValidationResult isValid(T object);
}
