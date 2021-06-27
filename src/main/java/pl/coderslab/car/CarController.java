package pl.coderslab.car;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        System.out.println("checkOptions()");
        String[] a = new String[]{"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/all")
    public String allCars(Model model) {
        List<Car> all = carService.findAll();
        all.forEach(c -> System.out.println(c));
        model.addAttribute("cars", carService.findAll());
        return "cars/all";
    }

    @GetMapping("/add")
    public String addCar(Model model) {
        Car car = new Car();
        car.setModelName("Passat");
        model.addAttribute("car", car);
        return "cars/add";
    }

    @PostMapping("/add")
    public String saveCar(Car car) {
        this.carService.save(car);
        return "redirect:/car/all";
    }
}
