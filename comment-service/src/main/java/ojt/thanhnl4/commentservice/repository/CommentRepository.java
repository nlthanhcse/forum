package ojt.thanhnl4.commentservice.repository;

import ojt.thanhnl4.commentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAll();
    Comment findCommentById(Integer  id);
    Comment deleteCommentById(Integer id);
}
