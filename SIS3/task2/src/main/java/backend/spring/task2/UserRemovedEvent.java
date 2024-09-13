package backend.spring.task2;


class UserRemovedEvent {

    public String name;

    UserRemovedEvent(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

}