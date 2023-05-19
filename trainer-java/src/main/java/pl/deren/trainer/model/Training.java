package pl.deren.trainer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Training {
    @Id
    private long id_training;
    private String title;
    private String level;
    private String date;
    private String room;
    private long run_by;
    private String created_at;
}
