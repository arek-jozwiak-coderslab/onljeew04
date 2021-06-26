package pl.coderslab.car;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;


    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public User findByIdWithCars(long id) {
        User byId = findById(id);
        Hibernate.initialize(byId.getCars());
        return byId;
    }


}
