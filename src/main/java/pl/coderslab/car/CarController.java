package pl.coderslab.car;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    private final UserDao userDao;
    private final CarService carService;

    public CarController(UserDao userDao, CarService carService) {
        this.userDao = userDao;
        this.carService = carService;
    }


    @RequestMapping("/all")

    public String allCars(Model model) {
        List<Car> all = carService.findAll();
        all.forEach(c -> System.out.println(c));

        model.addAttribute("cars", carService.findAll());
        return "cars/all";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addCar() {
        Car car = new Car();
        car.setModelName("Passat").setDescription("asdasd");

        User byId = userDao.findById(1l);
        car.setUser(byId);
        carService.save(car);
        return "added car";
    }
}
