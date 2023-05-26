package pl.deren.trainer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Training {
    @Id
    private long idTraining;
    private String title;
    private String level;
    private String date;
    private String room;
    private long run_by;
    private String created_at;

    @ManyToMany
    @JoinTable(name = "user_training",
            joinColumns = @JoinColumn(name = "idTraining"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))

    private List<User> users;

}
