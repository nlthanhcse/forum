package ojt.thanhnl4.postservice.service;

import ojt.thanhnl4.postservice.model.Post;
import ojt.thanhnl4.postservice.model.User;
import ojt.thanhnl4.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    public List<Post> getByUser(User user) {
        return this.postRepository.findAllByUser(user);
    }

    public Post getById(Integer id) {
        return this.postRepository.findPostById(id);
    }

    public Post addPost(Post post) {
        return this.postRepository.save(post);
    }

    public Post deleteById(Integer id) {
        return this.postRepository.deletePostById(id);
    }
}
