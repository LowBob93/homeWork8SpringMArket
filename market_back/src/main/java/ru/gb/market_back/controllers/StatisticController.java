package ru.gb.market_back.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.market_back.statistic.DTO.StatisticDTO;
import ru.gb.market_back.mappers.TimeStatisticMapper;
import ru.gb.market_back.services.StatisticService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
public class    StatisticController {
    private final TimeStatisticMapper mapper;
    private final StatisticService service;

    @GetMapping
    public ResponseEntity<List<StatisticDTO>> getStatistic() {
        List<StatisticDTO> result = service.getAllStatistic()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
        return new ResponseEntity<List<StatisticDTO>>(result, HttpStatus.OK);
    }
}