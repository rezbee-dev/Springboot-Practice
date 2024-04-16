package com.example.restservice.controllers;

import com.example.restservice.models.Ingredient;
import com.example.restservice.models.Ingredient.Type;
import com.example.restservice.models.Order;
import com.example.restservice.models.Taco;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
// prefix routes associated with this controller with /design
@RequestMapping("/design")
// Used to store model attributes in HTTP Servlet Session b/w requests
//   - In this case, model attribute with name `order` will be saved in HTTP servlet session, until another controller method uses SessionStatus.setComplete()
@SessionAttributes("order")
public class DesignTacoController {

    Logger logger = LoggerFactory.getLogger(DesignTacoController.class);


    // Initialize servlet model with ingredients to make it accessible by our view
    //   runs before request is handled, and view is returned
    //   ingredients are categorized by their types
    //   Model
    //   - object that ferries data b/w controller and view
    //   - data is placed in Model's attributes and then copied into servlet request attributes
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        // Note: this data would've normally be loaded from database
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        for(Type type: Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), this.filterByType(ingredients, type));
        }
    }

    // helper method
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.type().equals(type))
                .collect(Collectors.toList());
    }

    // Initializing order and taco key,values in model
    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
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
    public String processTaco(@Valid Taco taco, Errors error, @ModelAttribute Order order) {

        if(error.hasErrors()) {
            return "design";
        }

        order.addTaco(taco);
        // see OrderController
        return "redirect:/orders/current";
    }
}
