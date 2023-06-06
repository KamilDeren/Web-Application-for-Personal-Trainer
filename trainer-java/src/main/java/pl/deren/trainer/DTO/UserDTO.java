package pl.deren.trainer.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private String surname;
    private String email;
    private UserDetailDTO userDetail;
}
