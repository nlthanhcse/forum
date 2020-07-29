package ojt.thanhnl4.usercommentservice.controller;

import ojt.thanhnl4.usercommentservice.model.UserComment;
import ojt.thanhnl4.usercommentservice.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-comments")
public class UserCommentController {
    @Autowired
    private UserCommentService userCommentService;

    @GetMapping("/user-post/{user_id}/{comment_id}")
    public UserComment doInteractWithComment(@PathVariable(name = "user_id") Integer user_id,
                                          @PathVariable(name = "comment_id") Integer comment_id) {
        return this.userCommentService.doInteractWithComment(user_id, comment_id);
    }

    @DeleteMapping("/user-comment/{user_id}/{comment_id}")
    public UserComment deleteByUserIdAndPostId(@PathVariable(name = "user_id") Integer user_id,
                                            @PathVariable(name = "comment_id") Integer comment_id) {
        return this.userCommentService.deleteByUserIdAndCommentId(user_id, comment_id);
    }

    @GetMapping("/{user_id}/{type}")
    public List<UserComment> getLikedOrUnlikedUserPostsByUserIdAndType(@PathVariable(name = "user_id") Integer user_id,
                                                                    @PathVariable(name = "type") String type) {
        return this.userCommentService.getLikedOrUnlikedUserCommentsByUserIdAndType(user_id, type);
    }
}
