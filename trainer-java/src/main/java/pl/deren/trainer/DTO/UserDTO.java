package pl.deren.trainer.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String roleName;
    private Long phoneNumber;
    private String sex;
    private Timestamp createdAt;
    private String cityName;

    public UserDTO(Long id, String name, String surname, String email, String password, String roleName, Long phoneNumber, String sex, Timestamp createdAt, String cityName) {
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
        setRoleName(roleName);
        setPhoneNumber(phoneNumber);
        setSex(sex);
        setCreatedAt(createdAt);
        setCityName(cityName);
    }
}
