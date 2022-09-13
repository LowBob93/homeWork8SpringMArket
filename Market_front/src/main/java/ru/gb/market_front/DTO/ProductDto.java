package ru.gb.market_front.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.gb.market_back.models.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class ProductDto {
    private  Long id;
    @NotNull(message = "can't be empty")

    @Length(min = 3, max = 255, message = "product title must be 3 to 255 symbols.")
    private String title;

    @Min(value = 1, message = "price can't be lower then 1 rub")
    private  long price;

    private String categoryName;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();

    }
}
