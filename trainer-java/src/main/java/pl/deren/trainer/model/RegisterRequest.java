package pl.deren.trainer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Long phoneNumber;
    private String sex;
    private Timestamp created_at;
    private String cityName;
    private Long city_id;
    private Long user_detail_id;
    private Long user_role_id;
}
