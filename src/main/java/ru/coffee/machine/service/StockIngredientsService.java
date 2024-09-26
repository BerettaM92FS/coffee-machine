package ru.coffee.machine.service;

import ru.coffee.machine.dto.DrinksDto;
import ru.coffee.machine.dto.StockIngredientsDto;

import java.util.List;

public interface StockIngredientsService {

    String getIngredients();

    String addIngredients();

    String getCoffee(Integer id);
}
