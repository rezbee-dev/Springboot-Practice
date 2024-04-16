package com.example.restservice.models;

public record Ingredient(String id, String name, Type type) {
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
