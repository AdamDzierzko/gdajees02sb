package pl.coderslab.demospringdata.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void changeBookTitle(final String oldOne, final String newOne){
        Query q = entityManager.createQuery(
                "update Book b set b.title = :newOne" +
                        " where b.title = :oldOne");
        q.setParameter("newOne", newOne).setParameter("oldOne", oldOne).
                executeUpdate();
    };

    @Override
    public void resetRating(final int rating) {
        Query qe = entityManager.createQuery("update Book b set b.rating = :rating");

        qe.setParameter("rating",rating).executeUpdate();
    };
}
