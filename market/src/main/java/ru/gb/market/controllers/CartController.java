package ru.gb.market.controllers;


import org.springframework.web.bind.annotation.*;
import ru.gb.market.DTO.CartDto;
import ru.gb.market.DTO.ProductDto;
import ru.gb.market.exceptions.ResourceNotFoundException;
import ru.gb.market.services.CartService;
import ru.gb.market.services.ProductService;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/cart")

public class CartController {

        private  CartService cartService;
        private   ProductService productService;

        public CartController(CartService cartService, ProductService productService) {
            this.cartService = cartService;
            this.productService = productService;
        }

        @GetMapping("")
        public CartDto getCart(){
            CartDto dto = new CartDto();
            dto.setCart(cartService
                    .getCart()
                    .stream()
                    .map(ProductDto::new)
                    .collect(Collectors.toList())
            );
            return dto;
        }

        @PutMapping("")
        public void addProductToCart(@RequestBody ProductDto productDto){
            cartService.addProductToCart(productService.findById(
                            productDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDto.getId() + " not found"))
            );
        }

        @DeleteMapping("/{id}")
        public void deleteProductFromCart(@PathVariable Long id){
            cartService.deleteProductFromCartById(id);
        }

    }

