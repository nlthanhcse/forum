package ojt.thanhnl4.userservice.service;

import ojt.thanhnl4.userservice.model.User;
import ojt.thanhnl4.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getByUsername(String username) {
        return this.userRepository.findUsersByUsername(username);
    }

    public User getById(Integer id) {
        return this.userRepository.findUserById(id);
    }

    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteById(Integer id) {
        this.userRepository.deleteById(id);
    }
}
