package ru.coffee.machine.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(catalog = "coffee_machine", schema = "public", name = "stock_ingredients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockIngredientsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coffee")
    private Integer coffee;

    @Column(name = "water")
    private Integer water;

    @Column(name = "milk")
    private Integer milk;
}
