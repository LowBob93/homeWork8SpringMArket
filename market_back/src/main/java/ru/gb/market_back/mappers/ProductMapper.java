package ru.gb.market_back.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.gb.market_back.DTO.ProductDto;
import ru.gb.market_back.models.Product;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    @Mappings(value = {
            @Mapping(target = "categoryName", source = "category.name")
    })
    ProductDto mapToDto(Product product);
}