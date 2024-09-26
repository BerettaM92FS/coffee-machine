package ru.coffee.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.coffee.machine.domain.OrdersEntity;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
    @Query("SELECT d.name FROM OrdersEntity o " +
            "LEFT JOIN o.drink d " +
            "GROUP BY d.name " +
            "HAVING COUNT(d.name) > 1 " +
            "ORDER BY COUNT(d.name) DESC")
    List<String> getPopularDrink();

    @Query(value = "SELECT o.* FROM public.orders o ORDER BY o.id ASC LIMIT 100", nativeQuery = true)
    List<OrdersEntity> findFirstHundred();
}
