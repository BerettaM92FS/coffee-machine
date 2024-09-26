package ru.coffee.machine.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(catalog = "coffee_machine", schema = "public", name = "recipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecipeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drinks_id")
    private DrinksEntity drink;

    @Column(name = "coffee")
    private Integer coffee;

    @Column(name = "water")
    private Integer water;

    @Column(name = "milk")
    private Integer milk;
}
