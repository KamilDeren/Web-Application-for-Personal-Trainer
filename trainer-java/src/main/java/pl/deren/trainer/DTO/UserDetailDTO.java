package pl.deren.trainer.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDetailDTO {
    private long city;
    private long phoneNumber;
    private String sex;
}