package pl.deren.trainer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.deren.trainer.model.User;
import pl.deren.trainer.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Todo add some safety
    @PostMapping("/users")
    public User addTraining(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/users")
    public User editTraining(@RequestBody User user){
        return userService.editUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteTraining(@PathVariable long id){
        userService.deleteUser(id);
    }
}
