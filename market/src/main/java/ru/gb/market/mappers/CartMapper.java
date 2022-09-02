package ru.gb.market.mappers;


import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.gb.market.DTO.CartListProductDto;
import ru.gb.market.models.CartOrder;

@Mapper(injectionStrategy = InjectionStrategy.FIELD)
public interface CartMapper {

        @Mappings(value = {
                @Mapping(target = "product", source = "product")
        })
        CartOrder mapFromDto(CartListProductDto item);
    }