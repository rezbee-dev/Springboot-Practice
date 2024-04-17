package com.example.restservice.controllers;

import com.example.restservice.models.TacoOrder;
import com.example.restservice.repos.OrderRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors())
            return "orderForm";

        this.orderRepository.save(tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
