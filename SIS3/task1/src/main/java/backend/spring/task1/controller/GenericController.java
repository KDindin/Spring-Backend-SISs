package backend.spring.task1.controller;

import backend.spring.task1.customEvent.CustomSpringEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GenericController {

    private final CustomSpringEventPublisher eventPublisher;

    public GenericController(CustomSpringEventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/publishEvent")
    public String publishEvent() {
        eventPublisher.publishGenericEvent("test1", true);
        return "Event published";
    }
}
