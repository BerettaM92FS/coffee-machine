package ru.coffee.machine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockIngredientsDto {
    private Integer id;
    private Integer coffee;
    private Integer water;
    private Integer milk;
}
