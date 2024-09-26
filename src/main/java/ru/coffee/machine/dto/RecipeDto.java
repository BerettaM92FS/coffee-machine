package ru.coffee.machine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.coffee.machine.domain.DrinksEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecipeDto {
    private Integer id;
    private DrinksDto drink;
    private Integer coffee;
    private Integer water;
    private Integer milk;
}
