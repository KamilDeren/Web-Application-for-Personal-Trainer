package pl.deren.trainer.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_detail")
public class UserDetail {

    @Id
    private Long id;
    @Column(name = "phone_number")
    private Long phoneNumber;
    private String sex;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "city_id", insertable = false, updatable = false)
    private Long cityId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(mappedBy = "userDetail")
    private User user;

}
