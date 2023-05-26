package pl.deren.trainer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private long idUser;
    private String name;
    private String surname;
    private String email;
    private String password;
    private long id_user_details;
    private long user_role;

    @ManyToMany
    @JoinTable(
            name = "user_training",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idTraining")
    )

    private List<Training> trainings;
}
