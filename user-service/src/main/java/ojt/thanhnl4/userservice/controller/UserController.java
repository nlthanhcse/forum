package ojt.thanhnl4.userservice.controller;

import ojt.thanhnl4.userservice.model.User;
import ojt.thanhnl4.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/user/username/{username}")
    public User getByUsername(@PathVariable(name = "username") String username) {
        return this.userService.getByUsername(username);
    }

    @GetMapping("/user/{user_id}")
    public User getById(@PathVariable(name = "user_id") Integer user_id) {
        return this.userService.getById(user_id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @DeleteMapping("/user/{user_id}")
    public void deleteById(@PathVariable(name = "user_id") Integer user_id) {
        this.userService.deleteById(user_id);
    }
}
