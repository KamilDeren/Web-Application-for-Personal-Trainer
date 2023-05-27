package pl.deren.trainer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private long user_detail_id;
    private long user_role;

    @ManyToMany(mappedBy = "users")

    private List<Training> trainings;
}
