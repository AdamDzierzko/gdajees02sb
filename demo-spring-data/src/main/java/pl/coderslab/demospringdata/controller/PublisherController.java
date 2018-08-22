package pl.coderslab.demospringdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.demospringdata.model.Publisher;
import pl.coderslab.demospringdata.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/byNip")
    public Publisher findByNip(@RequestParam final int nip) {
        return publisherService.findByNipp(nip);
    }

    @GetMapping("/byRegon")
    public Publisher findByRegon(@RequestParam final int regon) {
        return publisherService.findByRegonn(regon);
    }
}
