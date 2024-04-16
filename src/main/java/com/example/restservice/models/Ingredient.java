package com.example.restservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // required to declared class as JPA entity
// @Table = Optional; Default Table name is Class name
// @Id = required to uniquely identify entity in database
//  - Note, @Id is from jakarta.persistence package, not spring package
//  - Note, since we will supply the string for @Id, no @GeneratedValue is needed
//  - See main method for prepopulating db with ingredients
public record Ingredient(@Id String id, String name, Type type) {
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
