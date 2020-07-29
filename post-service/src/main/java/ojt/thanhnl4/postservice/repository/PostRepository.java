package ojt.thanhnl4.postservice.repository;

import ojt.thanhnl4.postservice.model.Post;
import ojt.thanhnl4.postservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAll();
    List<Post> findAllByUser(User user);
    Post findPostById(Integer id);
    Post deletePostById(Integer id);
}
