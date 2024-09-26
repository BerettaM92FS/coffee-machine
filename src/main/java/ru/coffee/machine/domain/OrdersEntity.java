package ru.coffee.machine.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(catalog = "coffee_machine", schema = "public", name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "drinks_id")
    private DrinksEntity drink;

    @Column(name = "date")
    private Date date;
}
