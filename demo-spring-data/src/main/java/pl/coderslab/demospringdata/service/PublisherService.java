package pl.coderslab.demospringdata.service;

import org.springframework.stereotype.Service;
import pl.coderslab.demospringdata.model.Publisher;
import pl.coderslab.demospringdata.repository.PublisherRepository;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher findByNipp (final int nip) {
        return publisherRepository.findByNip(nip);
    }

    public Publisher findByRegonn (final int regon) {
        return publisherRepository.findByRegon(regon);
    }
}
