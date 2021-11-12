package net.proselyte.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Cars")
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "brand_cars")
    private String brandCar;
    @Column(name = "engine_capacity")
    private double engineCapacity;
    @Column(name = "year_car")
    private String year;
    @Column(name = "picture_car")
    private String picture;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "car")
    private List<Review> reviews = new ArrayList<>();

}
