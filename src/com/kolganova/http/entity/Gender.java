package com.kolganova.http.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    FEMALE,
    MALE;

    public static Optional<Gender> find(String gender) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(gender))
                .findFirst();
    }
}
