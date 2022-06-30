package ru.gb.market.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.models.Product;


@Data
@NoArgsConstructor
public class ProductDto {
    private  Long id;
    private String title;
    private  int price;


    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}
