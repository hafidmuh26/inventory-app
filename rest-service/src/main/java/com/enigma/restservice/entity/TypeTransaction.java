package com.enigma.restservice.entity;


import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum TypeTransaction {
    PURCHASING("Purchasing"),
    SELLING("Selling");

    private String value;

    TypeTransaction(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TypeTransaction fromValue(String value) {
        for (TypeTransaction typeTransaction : values()) {
            if (typeTransaction.value.equalsIgnoreCase(value)) {
                return typeTransaction;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
