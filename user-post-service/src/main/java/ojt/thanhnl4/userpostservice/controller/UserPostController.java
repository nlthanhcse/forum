package ojt.thanhnl4.userpostservice.controller;

import ojt.thanhnl4.userpostservice.model.UserPost;
import ojt.thanhnl4.userpostservice.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserPostController {
    @Autowired
    private UserPostService userPostService;

    @GetMapping("/user-post/{user_id}/{post_id}")
    public UserPost doInteractWithPost(@PathVariable(name = "user_id") Integer user_id,
                                       @PathVariable(name = "post_id") Integer post_id) {
        return this.userPostService.doInteractWithPost(user_id, post_id);
    }

    @DeleteMapping("/user-post/{user_id}/{post_id}")
    public UserPost deleteByUserIdAndPostId(@PathVariable(name = "user_id") Integer user_id,
                                            @PathVariable(name = "post_id") Integer post_id) {
        return this.userPostService.deleteByUserIdAndPostId(user_id, post_id);
    }

    @GetMapping("/{user_id}/{type}")
    public List<UserPost> getLikedOrUnlikedUserPostsByUserIdAndType(@PathVariable(name = "user_id") Integer user_id,
                                                                    @PathVariable(name = "type") String type) {
        return this.userPostService.getLikedOrUnlikedUserPostsByUserIdAndType(user_id, type);
    }
}
