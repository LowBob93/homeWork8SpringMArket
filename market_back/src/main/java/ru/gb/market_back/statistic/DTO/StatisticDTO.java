package ru.gb.market_back.statistic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDTO {
    private String serviceName;
    private List<StatisticUnitDTO> methods;
    private StatisticUnitDTO summary;
}