
@Configuration
public class AppConfig {

    // Constructor-Based Dependency Injection
    @Bean
    public Item item1() {
        return new ItemImpl1();
    }

    @Bean
    public Store store() {
        return new Store(item1());
    }


    // Setter-Based Dependency Injection
    @Bean
    public Store store2() {
        Store store = new Store();
        store.setItem(item1());
        return store;
    }
    // <bean id="store" class="org.baeldung.store.Store">
    //     <property name="item" ref="item1" />
    // </bean>


    // Field-Based Dependency Injection
    public class Store {
        @Autowired
        private Item item; 
    }

    // Autowiring a bean by type
    @Bean(autowire = Autowire.BY_TYPE)
    public class Store2 {
        private Item item;
        public setItem(Item item) {
            this.item = item;
    }

    // Autowiring a bean by type
    public class Store3 {
    
        @Autowired
        private Item item;
    }

    //Autowiring bean by name
    public class Store4 {
    
        @Autowired
        @Qualifier("item1")
        private Item item;
    }
}
}