package ru.gb.market_back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.market_back.statistic.model.Statistic;

@Repository
public interface TimeStatisticRepository extends CrudRepository<Statistic, String> {
}