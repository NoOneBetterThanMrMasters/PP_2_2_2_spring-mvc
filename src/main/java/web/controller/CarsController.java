package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(ModelMap model, @RequestParam (value = "count", defaultValue = "5") int count){
        List<Car> cars = new ArrayList<>(carService.getCars(count));
        model.addAttribute("cars", cars);
        return "cars";
    }
}