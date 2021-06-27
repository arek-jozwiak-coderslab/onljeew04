package pl.coderslab.library;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
