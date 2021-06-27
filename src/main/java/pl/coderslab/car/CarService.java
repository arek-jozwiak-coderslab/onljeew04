package pl.coderslab.car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public void save(Car car) {
        // sending email to newsletter
        carDao.save(car);
        // add info to workers
    }

    public List<Car> findAll() {
        return carDao.findAll();
    }
}
