package backend.spring.task1;

public class GenericStringSpringAppEvent extends GenericSpringAppEvent<String> {

    public GenericStringSpringAppEvent(final Object source, final String what) {
        super(source, what);
    }

}