package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.Car;
import net.proselyte.springbootdemo.service.CarService;

import net.proselyte.springbootdemo.service.ReviewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("car-delete/{carId}")
    public String deleteCar(@PathVariable("carId") Long carId) {
        carService.deleteById(carId);
        return "redirect:/cars";
    }

    @GetMapping("/car-update/{carId}")
    public String updateCarForm(@PathVariable("carId") Long carId, Model model) {
        Car car = carService.findById(carId);
        model.addAttribute("car", car);
        return "/car-update";
    }

    @PostMapping("/car-update")
    public String updateCar(Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

}
