package pl.coderslab.car;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", description='" + description + '\'' +
                ", modelCapitalize='" + modelCapitalize + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }

    @ManyToOne
    private User user;

    public String getModelName() {
        return modelName;
    }

    public Car setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }


    public String getModelCapitalize() {
        return modelCapitalize;
    }

    public void setModelCapitalize(String modelCapitalize) {
        this.modelCapitalize = modelCapitalize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
