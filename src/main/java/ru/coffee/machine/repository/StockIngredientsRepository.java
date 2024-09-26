package ru.coffee.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffee.machine.domain.StockIngredientsEntity;

@Repository
public interface StockIngredientsRepository extends JpaRepository<StockIngredientsEntity, Integer> {

}
