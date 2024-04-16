# Springboot-Practice
Project for learning Springboot

## Contributors
- risby
- -Mr Valentine

## Overview
- Based on CH 2 in *Spring in Action* - https://www.manning.com/books/spring-in-action-sixth-edition
- Taco Project Features
  - Display selection of dynamic (as opposed to hard-coded) taco ingredients for customers to choose from 
  - Allow customers to choose taco ingredients to create taco order
  - Allow customers to submit their taco orders
  - Validator taco orders

## Code Overview
- Model
  - Ingredient
  - Taco
  - TacoOrder 
- Controller
  - DesignTacoController
    - Handle HTTP GET/ POST requests for `/design` path
    - Pass ingredients into view to display to user
    - Accept chosen ingredients submitted by user
  - OrderController
- DTO
  - IngredientByIdConverter
- 
  - View that renders list of ingredients to user's browser