package ru.gb.market.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private List<ProductDto> cart;
}