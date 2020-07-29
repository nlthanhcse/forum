package ojt.thanhnl4.commentservice.service;

import ojt.thanhnl4.commentservice.model.Comment;
import ojt.thanhnl4.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAll() {
        return this.commentRepository.findAll();
    }

    public Comment getById(Integer id) {
        return this.commentRepository.findCommentById(id);
    }

    public Comment addComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    public Comment deleteById(Integer id) {
        return this.commentRepository.deleteCommentById(id);
    }
}
