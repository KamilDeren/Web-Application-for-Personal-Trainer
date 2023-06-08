package pl.deren.trainer.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainingDTO {
    private Long id;
    private String title;
    private String level;
    private Timestamp date;
    private String room;
    private String name;
    private String surname;
    private String fullNameOfTrainer;
    private Long phoneNumber;
    private String sex;
    private String cityName;
    private Long runBy;
    private Timestamp createdAt;

    public TrainingDTO(String name, String surname, Long phoneNumber, String sex, String cityName) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        setSex(sex);
        setCityName(cityName);
    }

    public TrainingDTO(Long id, String title, String level, Timestamp date, String room, String fullNameOfTrainer, Timestamp createdAt) {
        setId(id);
        setTitle(title);
        setLevel(level);
        setDate(date);
        setRoom(room);
        setFullNameOfTrainer(fullNameOfTrainer);
        setCreatedAt(createdAt);
    }
}
