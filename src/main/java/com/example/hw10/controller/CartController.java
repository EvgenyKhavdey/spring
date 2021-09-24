package com.example.hw10.controller;

import com.example.hw10.dao.CartDto;
import com.example.hw10.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;

    @GetMapping
    public CartDto getCart() {
        return new CartDto(cart);
    }

    @PutMapping("/add/{id}")
    public void addToCart(@PathVariable Integer id) {
        cart.addToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }
}

