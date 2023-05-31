package pl.deren.trainer.controller;

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

    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String city;
    private long phone_number;
    private String sex;
    private Timestamp created_at;
    private String image;
    private long user_detail_id;
}
