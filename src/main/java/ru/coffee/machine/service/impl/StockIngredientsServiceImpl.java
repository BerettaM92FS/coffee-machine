package ru.coffee.machine.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffee.machine.domain.DrinksEntity;
import ru.coffee.machine.domain.OrdersEntity;
import ru.coffee.machine.domain.RecipeEntity;
import ru.coffee.machine.domain.StockIngredientsEntity;
import ru.coffee.machine.repository.OrdersRepository;
import ru.coffee.machine.repository.RecipeRepository;
import ru.coffee.machine.repository.StockIngredientsRepository;
import ru.coffee.machine.service.StockIngredientsService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockIngredientsServiceImpl implements StockIngredientsService {

    private final StockIngredientsRepository stockRepository;
    private final RecipeRepository recipeRepository;
    private final OrdersRepository ordersRepository;

    @Override
    public String getIngredients() {
        StockIngredientsEntity entity = stockRepository.findById(1).orElseThrow();
        return "Список ингредиентов: \n"
                + "кофе " + entity.getCoffee() + "\n"
                + "вода " + entity.getWater() + "\n"
                + "молоко " + entity.getMilk() + "\n";
    }

    @Override
    public String addIngredients() {
        Optional<StockIngredientsEntity> entityOptional = stockRepository.findById(1);
        if (entityOptional.isPresent()) {
            StockIngredientsEntity entity = entityOptional.get();
            Integer coffee = entity.getCoffee();
            Integer water = entity.getWater();
            Integer milk = entity.getMilk();
            entity.setCoffee(coffee + 250);
            entity.setWater(water + 1000);
            entity.setMilk(milk + 900);
            stockRepository.save(entity);
            return "Список ингредиентов: \n"
                    + "кофе " + entity.getCoffee() + "\n"
                    + "вода " + entity.getWater() + "\n"
                    + "молоко " + entity.getMilk() + "\n";
        }
        return "Объект не найден!";
    }

    @Override
    public String getCoffee(Integer id) {
        Optional<RecipeEntity> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()) {
            RecipeEntity recipeEntity = recipeOptional.get();
            useIngredients(recipeEntity);
            newOrder(recipeEntity.getDrink());
            return "Ваш " + recipeEntity.getDrink().getName() + " готов!";
        }
        return "Объект не найден!";
    }

    private String useIngredients(RecipeEntity recipeEntity) {
        StockIngredientsEntity entity = stockRepository.findById(1).orElseThrow();

        Integer coffee = entity.getCoffee();
        Integer water = entity.getWater();
        Integer milk = entity.getMilk();

        if (coffee - recipeEntity.getCoffee() < 0) {
            return "Недостаточно кофе!";
        }

        if (water - recipeEntity.getWater() < 0) {
            return "Недостаточно воды!";
        }

        if (milk - recipeEntity.getMilk() < 0) {
            return "Недостаточно молока!";
        }

        entity.setCoffee(coffee - recipeEntity.getCoffee());
        entity.setWater(water - recipeEntity.getWater());
        entity.setMilk(milk - recipeEntity.getMilk());
        stockRepository.save(entity);
        return "Ингридиенты собраны!";
    }

    private void newOrder(DrinksEntity drink) {
        OrdersEntity order = new OrdersEntity();
        order.setDrink(drink);
        order.setDate(new Date());
        ordersRepository.save(order);
    }
}
