package ojt.thanhnl4.userservice.controller;

import ojt.thanhnl4.userservice.model.User;
import ojt.thanhnl4.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/user/{userId}")
    public User getById(@PathVariable(name = "userId") Integer userId) {
        return this.userService.getById(userId);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public User deleteById(@PathVariable(name = "userId") Integer userId) {
        return this.userService.deleteById(userId);
    }
}
