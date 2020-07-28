package ojt.thanhnl4.userservice.repository;

import ojt.thanhnl4.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findUserById(Integer id);
    User deleteUserById(Integer id);
}
