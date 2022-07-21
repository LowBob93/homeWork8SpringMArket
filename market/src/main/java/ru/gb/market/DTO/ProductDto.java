package ru.gb.market.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.gb.market.models.Product;


@Data
@NoArgsConstructor
public class ProductDto {
    private  Long id;
    @NotNull(message = "can't be empty")

    @Length(min = 3, max = 255, message = "product title must be 3 to 255 symbols.")
    private String title;

    @Min(value = 1, message = "price can't be lower then 1 rub")
    private  int price;


    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}
