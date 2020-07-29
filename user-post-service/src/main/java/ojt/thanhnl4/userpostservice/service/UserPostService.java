package ojt.thanhnl4.userpostservice.service;

import ojt.thanhnl4.userpostservice.model.UserPost;
import ojt.thanhnl4.userpostservice.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostService {
    @Autowired
    private UserPostRepository userPostRepository;

    public UserPost doInteractWithPost(Integer user_id, Integer post_id) {
        return this.userPostRepository.findUserPostById_User_IdAndId_Post_Id(user_id, post_id);
    }

    public UserPost deleteByUserIdAndPostId(Integer user_id, Integer post_id) {
        return this.userPostRepository.deleteUserPostById_User_IdAndId_Post_Id(user_id, post_id);
    }

    public List<UserPost> getLikedOrUnlikedUserPostsByUserIdAndType(Integer user_id, String type) {
        return this.userPostRepository.findAllById_User_IdAndAndType(user_id, type);
    }
}
