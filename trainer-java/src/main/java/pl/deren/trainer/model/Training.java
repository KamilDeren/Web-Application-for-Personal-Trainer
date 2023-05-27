package pl.deren.trainer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "training")
public class Training {
    @Id
    @Column(name = "id")
    private long id;
    private String title;
    private String level;
    private String date;
    private String room;
    private long run_by;
    private String created_at;

    @JsonIgnoreProperties("trainings")
    @ManyToMany
    @JoinTable(name = "user_training",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))

    private List<User> users;

}
