package ru.coffee.machine.service.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.coffee.machine.domain.OrdersEntity;
import ru.coffee.machine.dto.OrdersDto;
import ru.coffee.machine.repository.OrdersRepository;
import ru.coffee.machine.service.OrdersService;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository repository;
    private final ModelMapper modelMapper;

    public OrdersServiceImpl(OrdersRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String save(OrdersDto dto) {
        OrdersEntity entity = modelMapper.map(dto, OrdersEntity.class);
        repository.save(entity);
        return "Объект сохранён!";
    }

    @Override
    public String getPopularDrink() {
        List<String> coffeeList = repository.getPopularDrink();
        if (coffeeList.isEmpty()) {
            return "Заказы отсутствуют!";
        }
        return coffeeList.get(0);
    }

    @Scheduled(fixedDelay = 3600000)
    private void checkOrders() {
        List<OrdersEntity> entities = repository.findFirstHundred();
        List<OrdersEntity> delEntities = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (OrdersEntity order : entities) {
            LocalDate oldDate = order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(currentDate, oldDate);
            if (period.getYears() >= 5) {
                delEntities.add(order);
            }
        }
        repository.deleteAll(delEntities);
    }
}
