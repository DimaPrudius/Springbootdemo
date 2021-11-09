package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car,Long> {


}
