package pl.deren.trainer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.deren.trainer.DTO.UserDTO;
import pl.deren.trainer.model.User;
import pl.deren.trainer.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getUsersWithDetails();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable long id) throws Exception {
        return userService.getUserById(id);
    }

    @PutMapping
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
}
