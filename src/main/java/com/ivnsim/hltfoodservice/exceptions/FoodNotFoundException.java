package com.ivnsim.hltfoodservice.exceptions;

public class FoodNotFoundException extends RuntimeException {

    public FoodNotFoundException(String message) {
        super(message);
    }

}
