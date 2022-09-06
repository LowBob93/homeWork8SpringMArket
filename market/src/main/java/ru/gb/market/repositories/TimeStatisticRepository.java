package ru.gb.market.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.market.statistic.model.Statistic;

@Repository
public interface TimeStatisticRepository extends CrudRepository<Statistic, String> {
}