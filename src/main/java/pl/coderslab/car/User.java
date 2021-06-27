package pl.coderslab.car;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@ToString(of = {"if", "firstName"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    @OneToMany(mappedBy = "user")
    private List<Car> cars;
    @ManyToMany
    private List<Address> addresses;

}
