package ru.gb.market_front.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.market_back.DTO.CartDto;
import ru.gb.market_back.DTO.CartListProductDto;
import ru.gb.market_back.services.CartService;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor

public class CartController {

    private final CartService cartService;

    @GetMapping(value = {"", "/{cartId}"})
    public CartDto getCart(@PathVariable(required = false) String cartId) {
        if (cartId == null) {
            cartId = UUID.randomUUID().toString();
        }
        System.out.println("getCart");
        return cartService.getCart(cartId);
    }


    @PutMapping("")
    public CartDto addProduct(@RequestBody CartListProductDto item) {
        return cartService.addProductToCart(item.getCartId(), item);
    }

    @DeleteMapping("/{cartId}/{itemId}")
    public CartDto deleteProductFromCart(@PathVariable String cartId, @PathVariable Long itemId) {
        return cartService.deleteProductFromCartById(cartId, itemId);
    }
}

