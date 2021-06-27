package pl.coderslab.car;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
