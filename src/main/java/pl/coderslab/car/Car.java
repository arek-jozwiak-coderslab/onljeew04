package pl.coderslab.car;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")

@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model_name")
    private String modelName;
    private String description;
    @Transient
    private String modelCapitalize;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @ManyToOne
    private Category category;

    @PrePersist
    public void prePersist() {

        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

    @ManyToOne
    private User user;

    public String toString() {
        return "Car(id=" + this.getId() + ", modelName=" + this.getModelName() + ", description=" + this.getDescription() + ", modelCapitalize=" + this.getModelCapitalize() + ", user=" + this.getUser() + ")";
    }
}
