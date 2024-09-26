package ru.coffee.machine.service;

import ru.coffee.machine.dto.DrinksDto;

import java.util.List;

public interface DrinksService {
    List<DrinksDto> findAll();
}
