package backend.spring.springboottesting;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "person")
public class Employee {

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
//    @Size(min = 3, max = 20)
    private String name;

    private Date birthday;

}
