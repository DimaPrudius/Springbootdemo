package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.Car;
import net.proselyte.springbootdemo.service.CarService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String findAll(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/car-create")
    public String creteCarForm(Car car) {
        return "car-create";
    }

    @PostMapping("/car-create")
    public String createCar(Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("car-delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("/car-update/{id}")
    public String updateCarForm(@PathVariable("id") Long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "/car-update";
    }

    @PostMapping("/car-update")
    public String updateCar(Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }
}
