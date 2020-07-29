package ojt.thanhnl4.usercommentservice.repository;

import ojt.thanhnl4.usercommentservice.model.UserComment;
import ojt.thanhnl4.usercommentservice.model.UserCommentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCommentRepository extends JpaRepository<UserComment, UserCommentId> {
    UserComment findUserCommentById_User_IdAndId_Comment_Id(Integer user_id, Integer comment_id);
    UserComment deleteUserCommentById_User_IdAndId_Comment_Id(Integer user_id, Integer comment_id);
    List<UserComment> findAllById_User_IdAndAndType(Integer user_id, String type);
}
