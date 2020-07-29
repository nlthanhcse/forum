package ojt.thanhnl4.userpostservice.repository;

import ojt.thanhnl4.userpostservice.model.Post;
import ojt.thanhnl4.userpostservice.model.UserPost;
import ojt.thanhnl4.userpostservice.model.UserPostId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostRepository extends JpaRepository<UserPost, UserPostId> {
//    @Query("select u from UserPost u where u.id.user.id = :userId and u.id.post.id = :post_id")
    UserPost findUserPostById_User_IdAndId_Post_Id(Integer user_id, Integer post_id);
    UserPost deleteUserPostById_User_IdAndId_Post_Id(Integer user_id, Integer post_id);
    List<UserPost> findAllById_User_IdAndAndType(Integer user_id, String type);
}
