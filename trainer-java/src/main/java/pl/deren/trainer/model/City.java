package pl.deren.trainer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {

    @Id
    private long id;
    private String city_name;

    @OneToOne(mappedBy = "city")
    private UserDetail userDetail;
}
