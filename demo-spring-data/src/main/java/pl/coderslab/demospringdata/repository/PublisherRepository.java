package pl.coderslab.demospringdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.demospringdata.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByNip(final int nip);
    Publisher findByRegon(final int regon);
}
