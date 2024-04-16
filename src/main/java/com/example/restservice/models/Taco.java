package com.example.restservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//public record Taco(String name, List<Ingredient> ingredientList) {
//    public Taco(){
//        this("",new ArrayList<>());
//    }
//}

@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Database will generate IDs
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @Size(min=1, message="You must choose at least 1 ingredient")
    // Declares ManyToMany relationship between taco and ingredient
    //  - Taco can have many ingredients
    //  - Ingredient can be part of many tacos
    // Can use @JoinTable and @JoinColumn to specify the Join table
    //   or, can omit it and JPA will generate the table and column names automatically
    @ManyToMany()
    private List<Ingredient> ingredientList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public String toString() {
        return "Taco{" +
                "name='" + name + '\'' +
                ", ingredientList=" + ingredientList +
                '}';
    }
}