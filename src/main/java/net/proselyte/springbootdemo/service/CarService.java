package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.Car;
import net.proselyte.springbootdemo.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {

    private final CarsRepository carsRepository;

    public CarService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public Car findById(Long id){
        return carsRepository.getOne(id);
    }
    public List<Car>findAll(){
        return carsRepository.findAll();
    }
    public Car saveCar(Car car){
        return carsRepository.save(car);

    }
    public void deleteById(Long id){
        carsRepository.deleteById(id);
    }
}
