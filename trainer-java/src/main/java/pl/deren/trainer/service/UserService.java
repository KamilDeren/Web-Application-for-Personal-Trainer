package pl.deren.trainer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.deren.trainer.DTO.UserDTO;
import pl.deren.trainer.DTO.UserDetailDTO;
import pl.deren.trainer.model.User;
import pl.deren.trainer.model.City;
import pl.deren.trainer.model.UserDetail;
import pl.deren.trainer.model.UserRole;
import pl.deren.trainer.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User editUser(User user) {
        User userEdited = userRepository.findById(user.getId()).orElseThrow();
        userEdited.setName(user.getName());
        userEdited.setSurname(userEdited.getSurname());
        userEdited.setEmail(user.getEmail());
        userEdited.setPassword(user.getPassword());

        UserDetail userDetail = userEdited.getUserDetail();
        if (userDetail != null) {
            userDetail.setCity(user.getUserDetail().getCity());
            userDetail.setPhoneNumber(user.getUserDetail().getPhoneNumber());
            userDetail.setSex(user.getUserDetail().getSex());
        }

        UserRole userRole = userEdited.getUserRole();
        if (userRole != null) {
            userRole.setRoleName(user.getUserRole().getRoleName());
        }

        return userEdited;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getUsersWithDetails() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());

        UserDetail userDetail = user.getUserDetail();
        if (userDetail != null) {
            UserDetailDTO userDetailDTO = new UserDetailDTO();
            userDetailDTO.setPhoneNumber(userDetail.getPhoneNumber());
            userDetailDTO.setSex(userDetail.getSex());
            userDTO.setUserDetail(userDetailDTO);
        }
        City city = user.getUserDetail().getCity();
        if (city != null)
            city.setCity_name(city.getCity_name());

        return userDTO;
    }
}
