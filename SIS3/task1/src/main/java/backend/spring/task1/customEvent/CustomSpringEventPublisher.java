package backend.spring.task1.customEvent;

import backend.spring.task1.GenericSpringAppEvent;
import backend.spring.task1.GenericStringSpringAppEvent;
import backend.spring.task1.GenericStringSpringEvent;
import backend.spring.task1.customEvent.CustomSpringEvent;
import backend.spring.task1.genericEvent.GenericSpringEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event. ");
        final CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

    public void publishGenericEvent(final String message, boolean success) {
        System.out.println("Publishing generic event.");
        final GenericSpringEvent<String> genericSpringEvent = new GenericStringSpringEvent(message, success);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }

    public void publishGenericAppEvent(final String message) {
        System.out.println("Publishing generic event.");
        final GenericSpringAppEvent<String> genericSpringEvent = new GenericStringSpringAppEvent(this, message);
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }

}