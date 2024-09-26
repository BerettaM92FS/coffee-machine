package ru.coffee.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coffee.machine.domain.DrinksEntity;

@Repository
public interface DrinksRepository extends JpaRepository<DrinksEntity, Integer> {

}
