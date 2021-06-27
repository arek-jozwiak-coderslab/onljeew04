package pl.coderslab.library;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public List<Publisher> findAll() {
        return entityManager
                .createQuery("select b from Publisher b")
                .getResultList();
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }
}
