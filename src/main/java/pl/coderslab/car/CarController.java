package pl.coderslab.car;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CategoryDao categoryDao;

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        System.out.println("checkOptions()");
        String[] a = new String[]{"java", "php", "ruby", "python"};
        List<String> strings = Arrays.asList(a);
        return  strings;
    }

    private final CarService carService;

    public CarController(CategoryDao categoryDao, CarService carService) {
        this.categoryDao = categoryDao;
        this.carService = carService;
    }

    @RequestMapping("/all")
    public String allCars(Model model) {
        List<Car> all = carService.findAll();
        all.forEach(System.out::println);
        model.addAttribute("cars", carService.findAll());
        return "cars/all";
    }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("car", new Car());
        return "cars/add";
    }

    @PostMapping("/add")
    public String saveCar(Car car) {
        this.carService.save(car);
        return "redirect:/car/all";
    }
}
