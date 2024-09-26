package ru.coffee.machine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.coffee.machine.domain.DrinksEntity;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDto {
    private Integer id;
    private DrinksEntity drink;
    private Date date;
}
