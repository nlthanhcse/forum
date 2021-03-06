package ojt.thanhnl4.commentservice.repository;

import ojt.thanhnl4.commentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAll();
    List<Comment> findAllByPost_Id(Integer post_id);
    Comment findCommentById(Integer  id);
    Comment deleteCommentById(Integer id);
}
