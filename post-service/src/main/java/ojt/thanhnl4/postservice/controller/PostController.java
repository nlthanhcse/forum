package ojt.thanhnl4.postservice.controller;

import ojt.thanhnl4.postservice.model.Post;
import ojt.thanhnl4.postservice.model.User;
import ojt.thanhnl4.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    public List<Post> getAll() {
        return this.postService.getAll();
    }

    public List<Post> getByUser(User user) {
        return this.postService.getByUser(user);
    }

    public Post getById(Integer id) {
        return this.postService.getById(id);
    }

    public Post addPost(Post post) {
        return this.postService.addPost(post);
    }

    public Post deleteById(Integer id) {
        return this.postService.deleteById(id);
    }
}
