package ru.coffee.machine.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(catalog = "coffee_machine", schema = "public", name = "drinks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DrinksEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
