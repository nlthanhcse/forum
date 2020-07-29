package ojt.thanhnl4.commentservice.controller;

import ojt.thanhnl4.commentservice.model.Comment;
import ojt.thanhnl4.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public List<Comment> getAll() {
        return this.commentService.getAll();
    }

    @GetMapping("/post/{post_id}")
    public List<Comment> getByPostId(@PathVariable(name = "post_id") Integer post_id) {
        return this.commentService.getByPostId(post_id);
    }

    @GetMapping("/comment/{commentId}")
    public Comment getById(@PathVariable(name = "commentId") Integer commentId) {
        return this.commentService.getById(commentId);
    }

        @PostMapping("/comment")
        public Comment addComment(@RequestBody Comment comment) {
            return this.commentService.addComment(comment);
        }

        @DeleteMapping("/comment/{commentId}")
        public Comment deleteById(@PathVariable(name = "commentId") Integer commentId) {
            return this.commentService.deleteById(commentId);
        }
}
