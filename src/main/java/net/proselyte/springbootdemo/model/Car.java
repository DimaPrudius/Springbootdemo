package net.proselyte.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_cars")
    private String brandCar;
    @Column(name = "engine_capacity")
    private double engineCapacity;
}
