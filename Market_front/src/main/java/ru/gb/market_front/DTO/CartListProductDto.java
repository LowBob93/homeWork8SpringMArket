package ru.gb.market_front.DTO;

import lombok.Data;

import java.util.Objects;

@Data
public class CartListProductDto {
    private Long id;
    private String cartId;
    private int count;
    private long price;
    private ProductDto product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartListProductDto that = (CartListProductDto) o;
        return Objects.equals(product.getId(), that.product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(product.getId());
    }
}