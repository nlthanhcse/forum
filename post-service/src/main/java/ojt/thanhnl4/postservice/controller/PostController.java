package ojt.thanhnl4.postservice.controller;

import ojt.thanhnl4.postservice.model.Post;
import ojt.thanhnl4.postservice.model.User;
import ojt.thanhnl4.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public List<Post> getAll() {
        return this.postService.getAll();
    }

    @GetMapping("/user/{user_id}")
    public List<Post> getByUserId(@PathVariable(name = "user_id") Integer user_id) {
        return this.postService.getByUserId(user_id);
    }

    @GetMapping("/category/{category_id}")
    public List<Post> getByCategoryId(@PathVariable(name = "category_id") Integer category_id) {
        return this.postService.getByCategoryId(category_id);
    }

    @GetMapping("/post/{post_id}")
    public Post getById(@PathVariable(name = "post_id") Integer post_id) {
        return this.postService.getById(post_id);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return this.postService.addPost(post);
    }

    @DeleteMapping("/post/{post_id}")
    public Post deleteById(@PathVariable(name = "post_id") Integer post_id) {
        return this.postService.deleteById(post_id);
    }
}
