package ojt.thanhnl4.forumapigateway.repository;

import ojt.thanhnl4.forumapigateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    @Query("select u.role from User u where u.username like :username")
    String getRoleByUsername(@Param("username") String username);
}
