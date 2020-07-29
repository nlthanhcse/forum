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

    public List<Post> getByUserId(Integer user_id) {
        return this.postRepository.findAllByUserId(user_id);
    }

    public List<Post> getByCategoryId(Integer category_id) {
        return this.postRepository.findAllByCategory_Id(category_id);
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
