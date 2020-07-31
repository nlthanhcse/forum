package ojt.thanhnl4.userservice.repository;

import ojt.thanhnl4.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findUsersByUsername(String username);
    User findUserById(Integer id);
    void deleteById(Integer id);
}
