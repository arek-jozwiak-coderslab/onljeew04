package pl.coderslab.library;

import org.springframework.stereotype.Repository;
import pl.coderslab.car.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }
    public void update(Book book) {
        entityManager.merge(book);
    }

    public List<Book> findAll() {
        return entityManager
                .createQuery("select b from Book b")
                .getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rat");
        query.setParameter("rat", rating);
        return query.getResultList();
    }

    public List<Book> findAllByRatingSecond(int rating) {
       return entityManager
               .createQuery("select b from Book b where b.rating = :rat")
               .setParameter("rat", rating)
               .getResultList();
    }

    public void deleteById(long id) {
        Book byId = this.findById(id);
        entityManager.remove(
                entityManager.contains(byId) ? byId : entityManager.merge(byId));
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }
}
