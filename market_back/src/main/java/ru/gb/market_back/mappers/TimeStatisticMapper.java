package ru.gb.market_back.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.gb.market_back.statistic.DTO.StatisticDTO;
import ru.gb.market_back.statistic.model.Statistic;


@Mapper(injectionStrategy = InjectionStrategy.FIELD)
public interface TimeStatisticMapper {
    @Mappings(value = {
            @Mapping(target = "serviceName", source = "id")
    })
    StatisticDTO map(Statistic statistic);
}