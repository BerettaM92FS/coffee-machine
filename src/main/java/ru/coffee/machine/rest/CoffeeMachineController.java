package ru.coffee.machine.rest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.machine.dto.RecipeDto;
import ru.coffee.machine.service.DrinksService;
import ru.coffee.machine.service.OrdersService;
import ru.coffee.machine.service.RecipeService;
import ru.coffee.machine.service.StockIngredientsService;

@RestController
@RequestMapping("/coffee")
@RequiredArgsConstructor
public class CoffeeMachineController {

    private final DrinksService drinksService;
    private final RecipeService recipeService;
    private final StockIngredientsService stockService;
    private final OrdersService ordersService;

    @Operation(summary = "Получить список напитков")
    @GetMapping("/allDrinks")
    public ResponseEntity<?> getAllDrinks() {
        return ResponseEntity.ok(drinksService.findAll());
    }

    @Operation(summary = "Получить список рецептов")
    @GetMapping("/allRecipe")
    public ResponseEntity<?> getAllRecipe() {
        return ResponseEntity.ok(recipeService.findAll());
    }

    @Operation(summary = "Добавить рецепт")
    @PostMapping("/addRecipe")
    public ResponseEntity<?> addRecipe(
            @RequestBody RecipeDto dto
    ) {
        return ResponseEntity.ok().body(recipeService.save(dto));
    }

    @Operation(summary = "Изменить рецепт")
    @PutMapping("/updateRecipe")
    public ResponseEntity<?> update(
            @RequestBody RecipeDto dto
    ) {
        return ResponseEntity.ok().body(recipeService.update(dto));
    }

    @Operation(summary = "Удалить рецепт")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(recipeService.delete(id));
    }

    @Operation(summary = "Заказать кофе")
    @GetMapping("/getCoffee/{id}")
    public ResponseEntity<?> getCoffee(
            @PathVariable("id") Integer id
    ) {
        return ResponseEntity.ok(stockService.getCoffee(id));
    }

    @Operation(summary = "Самый популярный кофе")
    @GetMapping("/getPopularDrink")
    public ResponseEntity<?> getPopularDrink() {
        return ResponseEntity.ok(ordersService.getPopularDrink());
    }

    @Operation(summary = "Остатки ингредиентов")
    @GetMapping("/getIngredients")
    public ResponseEntity<?> getIngredients() {
        return ResponseEntity.ok(stockService.getIngredients());
    }

    @Operation(summary = "Пополнить ингредиенты")
    @PostMapping("/addIngredients")
    public ResponseEntity<?> addIngredients() {
        return ResponseEntity.ok(stockService.addIngredients());
    }
}
