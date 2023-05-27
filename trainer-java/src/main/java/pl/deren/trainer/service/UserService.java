package pl.deren.trainer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.deren.trainer.model.User;
import pl.deren.trainer.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    // TODO fix user details
    @Transactional
    public User editUser(User user) {
        User userEdited = userRepository.findById(user.getId()).orElseThrow();
        userEdited.setName(user.getName());
        userEdited.setSurname(userEdited.getSurname());
        userEdited.setEmail(user.getEmail());
        userEdited.setPassword(user.getPassword());
        userEdited.setCity(userEdited.getCity());
        userEdited.setPhone_number(userEdited.getPhone_number());
        userEdited.setSex(userEdited.getSex());
        userEdited.setImage(userEdited.getImage());
        return userEdited;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
