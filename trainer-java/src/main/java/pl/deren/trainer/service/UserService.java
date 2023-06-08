package pl.deren.trainer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.deren.trainer.DTO.UserDTO;
import pl.deren.trainer.model.City;
import pl.deren.trainer.model.User;
import pl.deren.trainer.model.UserDetail;
import pl.deren.trainer.model.UserRole;
import pl.deren.trainer.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User editUser(User user) {
        User userEdited = userRepository.findById(user.getId()).orElseThrow();
        userEdited.setName(user.getName());
        userEdited.setSurname(user.getSurname());
        userEdited.setEmail(user.getEmail());
        userEdited.setPassword(user.getPassword());

        UserDetail userDetail = userEdited.getUserDetail();

        City city = userDetail.getCity();
        city.setCityName(user.getCityName());

        userDetail.setCity(city);
        userDetail.setPhoneNumber(user.getPhoneNumber());
        userDetail.setSex(user.getSex());

        UserRole userRole = userEdited.getUserRole();
        userRole.setRoleName(user.getRoleName());

        return userRepository.save(userEdited);
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

        if (user.getUserRole() != null) {
            userDTO.setRoleName(user.getUserRole().getRoleName());
        }

        if (user.getUserDetail() != null) {
            userDTO.setPhoneNumber(user.getUserDetail().getPhoneNumber());
            userDTO.setSex(user.getUserDetail().getSex());
            userDTO.setCreatedAt(user.getUserDetail().getCreatedAt());

            if (user.getUserDetail().getCity() != null) {
                userDTO.setCityName(user.getUserDetail().getCity().getCityName());
            }
        }

        return userDTO;
    }

    public UserDTO getUserById(long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found with ID: " + id));
        return convertToDTO(user);
    }
}
