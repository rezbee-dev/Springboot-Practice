package com.example.restservice.controllers;

import com.example.restservice.models.Order;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors())
            return "orderForm";

        logger.info("Order submitted: {}", order);
        logger.info("Order tacos {}", order.getTacos());

        sessionStatus.setComplete();

        return "redirect:/";
    }

}
