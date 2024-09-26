package ru.coffee.machine.service;

import ru.coffee.machine.dto.OrdersDto;

public interface OrdersService {
    String save(OrdersDto dto);

    String getPopularDrink();
}
