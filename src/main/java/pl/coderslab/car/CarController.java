package pl.coderslab.car;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addCar() {
        Car car = new Car();
        car.setModelName("Passat");
        carService.save(car);

        return "added car";
    }
}
