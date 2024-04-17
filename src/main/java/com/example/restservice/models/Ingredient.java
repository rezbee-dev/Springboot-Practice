package com.example.restservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // required to declared class as JPA entity
// @Table = Optional; Default Table name is Class name
// @Id = required to uniquely identify entity in database
//  - Note, @Id is from jakarta.persistence package, not spring package
//  - Note, since we will supply the string for @Id, no @GeneratedValue is needed
//  - See main method for prepopulating db with ingredients
//  - Note, java records cannot be @Entity
public class Ingredient {
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    @Id
    private String id;
    private String name;
    private Type type;


    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // No-arg constructor required by @Entity (Spring JPA)
    public Ingredient(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}



//public record Ingredient(@Id String id, String name, Type type) {
//    public enum Type {
//        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
//    }
//}
