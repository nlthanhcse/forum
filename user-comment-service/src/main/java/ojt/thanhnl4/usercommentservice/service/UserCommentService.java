package ojt.thanhnl4.usercommentservice.service;

import ojt.thanhnl4.usercommentservice.model.UserComment;
import ojt.thanhnl4.usercommentservice.repository.UserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentService {
    @Autowired
    private UserCommentRepository userCommentRepository;

    public UserComment doInteractWithComment(Integer user_id, Integer comment_id) {
        return this.userCommentRepository.findUserCommentById_User_IdAndId_Comment_Id(user_id, comment_id);
    }

    public UserComment deleteByUserIdAndCommentId(Integer user_id, Integer comment_id) {
        return this.userCommentRepository.deleteUserCommentById_User_IdAndId_Comment_Id(user_id, comment_id);
    }

    public List<UserComment> getLikedOrUnlikedUserCommentsByUserIdAndType(Integer user_id, String type) {
        return this.userCommentRepository.findAllById_User_IdAndAndType(user_id, type);
    }
}
