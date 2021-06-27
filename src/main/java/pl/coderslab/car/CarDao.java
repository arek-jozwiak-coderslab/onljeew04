package pl.coderslab.car;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CarDao {

    @PersistenceContext
    EntityManager entityManager;


    public List<Car> findAll() {
        return entityManager
                .createQuery("SELECT c from Car c")
                .getResultList();
    }

    public void save(Car car) {
        entityManager.persist(car);
    }

    public Car findById(long id) {
        return entityManager.find(Car.class, id);
    }

    public void delete(Car car) {
        entityManager.remove(entityManager.contains(car) ?
                car : entityManager.merge(car));
    }

    public void deleteById(long id) {
        Car byId = this.findById(id);
        entityManager.remove(
                entityManager.contains(byId) ? byId : entityManager.merge(byId));
    }
}
