package backend.spring.task1;

import backend.spring.task1.genericEvent.GenericSpringEvent;

public class GenericStringSpringEvent extends GenericSpringEvent<String> {

    public GenericStringSpringEvent(final String what, final boolean success) {
        super(what, success);
    }

}