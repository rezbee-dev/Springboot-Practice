package com.example.restservice.controllers;

import com.example.restservice.models.Ingredient;
import com.example.restservice.models.Ingredient.Type;
import com.example.restservice.models.TacoOrder;
import com.example.restservice.models.Taco;
import com.example.restservice.repos.IngredientRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    Logger logger = LoggerFactory.getLogger(DesignTacoController.class);
    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }


    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        this.ingredientRepository.findAll().forEach(ingredients::add); // query all ingredients, and add each to list

        for(Type type: Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), this.filterByType(ingredients, type));
        }
    }

    // helper method
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    // Initializing order and taco key,values in model
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design"; // Spring will resolve the name "design" to the matching HTML file of the same name
    }

    @PostMapping
    // when form data is submitted, the form fields bind with the taco object
    // since form fields are just string values, not taco.ingredientList.ingredient, IngredientByIdConverter is used
    //   - since its annotated as @Component, Spring automatically discovers it and registers it with Spring MVC to be used when conversion of req params are needed
    // @Valid = to enable JavaBean Validation; validation occurs before this method is invoked
    //   - Errors will contain validation errors
    public String processTaco(@Valid Taco taco, Errors error, @ModelAttribute TacoOrder tacoOrder) {

        if(error.hasErrors()) {
            return "design";
        }

        tacoOrder.addTaco(taco);
        // see OrderController
        return "redirect:/orders/current";
    }
}
