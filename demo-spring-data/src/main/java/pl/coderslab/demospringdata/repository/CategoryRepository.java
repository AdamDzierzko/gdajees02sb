package pl.coderslab.demospringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.demospringdata.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(final Long id);
}
