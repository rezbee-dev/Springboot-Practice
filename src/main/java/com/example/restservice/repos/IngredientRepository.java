package com.example.restservice.repos;

import com.example.restservice.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

// Spring automatically generates implementations of repository
// Features CRUD operations such as findAll, findById, etc
// <X,Y> -> X = type of object to be persisted in db, Y = type of the persisted object's ID field
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
