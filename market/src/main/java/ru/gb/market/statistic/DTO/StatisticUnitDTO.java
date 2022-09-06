package ru.gb.market.statistic.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticUnitDTO {
    private String unitName;
    private int executionCount;
    private int averageExecutionTime;
    private long allExecutionTime;
}