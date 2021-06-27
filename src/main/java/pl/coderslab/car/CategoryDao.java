package pl.coderslab.car;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;


    public List<Category> findAll() {
        return entityManager
                .createQuery("SELECT c from Category c")
                .getResultList();
    }


    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }
}
