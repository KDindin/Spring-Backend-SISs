package backend.spring.task2;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class Publisher {

    private final ApplicationEventPublisher publisher;

    Publisher(ApplicationEventPublisher publisher) {

        this.publisher = publisher;
    }
    void publishEvent() {
        // Async Event
        publisher.publishEvent("I'm Async");

        // @EventListener Annotated and ApplicationListener
        publisher.publishEvent(new UserCreatedEvent(this, "Lucario"));
        publisher.publishEvent(new UserRemovedEvent("Lucario"));

        // Conditional Listener
        publisher.publishEvent(new UserCreatedEvent(this, "reflectoring"));
        publisher.publishEvent(new UserRemovedEvent("reflectoring"));

    }
//    void publishEvent(final String name) {
//        // Publishing event created by extending ApplicationEvent
//        publisher.publishEvent(new UserCreatedEvent(this, name));
//        // Publishing an object as an event
//        publisher.publishEvent(new UserRemovedEvent(name));
//    }
}
